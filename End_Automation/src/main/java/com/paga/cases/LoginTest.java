package com.paga.cases;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paga.config.TestConfig;
import com.paga.dao.h2.H2LoginCaseRepository;
import com.paga.dao.h2.entity.LoginCase;
import com.paga.utils.ConfigBeanPropUrl;

import java.io.IOException;
import java.util.Optional;

@SpringBootTest
public class LoginTest extends AbstractTestNGSpringContextTests {
    //获取configUrl.properties配置文件中的url
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

    @Autowired
    private H2LoginCaseRepository h2LoginCaseRepository;

    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取HttpClient对象",alwaysRun=true)
    public void beforeTest(){
        TestConfig.defaultHttpClient = HttpClients.createDefault();

    }

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void loginTrue() throws Exception {
        //按id获取用例数据
        Optional<LoginCase>  loginCaseOp = h2LoginCaseRepository.findById(1);
        LoginCase loginCase = loginCaseOp.get();
        //发送请求,获取结果
        int actual = getResult(loginCase);
        //验证状态码
        Assert.assertEquals(loginCase.getExpected(),actual);
    }

   //@Test(description = "用户登陆失败接口")
    public void loginFalse() throws IOException {
        Optional<LoginCase>  loginCaseOp = h2LoginCaseRepository.findById(2);
        LoginCase loginCase = loginCaseOp.get();
        //发送请求,获取结构
        int actual = getResult(loginCase);
        //验证结果
        Assert.assertEquals(loginCase.getExpected(),actual);
    }

    private int getResult(LoginCase loginCase) throws IOException {
        //接口url
        System.out.println("登陆接口url："+configBeanPropUrl.getLogin());
        HttpPost post = new HttpPost(configBeanPropUrl.getLogin());
        JSONObject param = new JSONObject();
        param.put("username",loginCase.getUserName());
        param.put("password",loginCase.getPassWord());
        post.setHeader("Content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口的响应结果："+jsonStr);
        JSONObject jsonObject = new JSONObject(jsonStr);
        int userStatus = jsonObject.getInt("userStatus");
        //获取jwtToken并赋值到TestConfig.store
        if(userStatus==1){
            String jwtToken = jsonObject.getString("jwtToken");
            System.out.println("jwtToken："+jwtToken);
            TestConfig.jwtToken = jwtToken;
            TestConfig.username = jsonObject.getString("username");
            TestConfig.fullName = jsonObject.getString("fullName");
        }
        return userStatus;
    }
}
