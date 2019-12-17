<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="my_suite_1">
	<listeners>
		<listener class-name="com.integritytech.fromework.util.TakeScreenshotListener"/>
		<!--<listener class-name="com.bwf.framework.utils.RetryListen"/>-->
		<listener class-name="org.uncommons.reportng.HTMLReporter"/>
		<listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
		
	</listeners>

	<test name="regression_test1">
		<classes>
			<!-- 创建教师端账号 -->		
			<class name="com.integritytech.ecq.test.admin.CreateTeacherTest"/>
			<!-- 创建、修改文档节测试类 -->		
			<class name="com.integritytech.ecq.test.teacher.DocSectionTest"/>
			<!-- 创建、修改CTF小节测试类 -->
			<class name="com.integritytech.ecq.test.teacher.CTFSectionTest"/>
			<!-- 创建、修改网络实验小节测试类 -->
			<class name="com.integritytech.ecq.test.teacher.WLSYSectionTest"/>
			<!-- 培训方案、课程体系测试类 -->
			<class name="com.integritytech.ecq.test.teacher.MySystemTest"/>
			<!-- 课程测试类 -->
			<class name="com.integritytech.ecq.test.teacher.MyBookTest"/>
			<!-- 导出培训方案测试类 -->
			<class name="com.integritytech.ecq.test.teacher.ExportPlanTest"/>
			<!-- 我的所有小节测试类 -->
			<class name="com.integritytech.ecq.test.teacher.MysectionTest"/>
			<!-- 学生测试类 -->
			<class name="com.integritytech.ecq.test.teacher.AllStudentsTest"/>
			<!-- 我的班级测试类 -->
			<class name="com.integritytech.ecq.test.teacher.MyclassTest"/>
			<!-- 导出学员测试类 -->
			<class name="com.integritytech.ecq.test.teacher.ExportStudentTest"/>
			<!-- 教员端新建学习任务测试类 -->
			<class name="com.integritytech.ecq.test.teacher.EdubookTest"/>
			
			
			<!-- 学生端修改密码，学习测试类 -->
			<class name="com.integritytech.ecq.test.student.ReleaseStudyTest"/>
			<!-- 学生端自学课程测试类-->
			<class name="com.integritytech.ecq.test.student.SelfStudyTest"/>
			<!-- 教师端题目分类的增改查；手动创建题目、导入题目；题目的增改查测试类-->
			<class name="com.integritytech.ecq.test.teacher.QuestionCateTest"/>
			<!-- 创建智能试卷下发智能试卷测试类-->
			<class name="com.integritytech.ecq.test.teacher.XFZNTestPaperTest"/>
			<!-- 智能选题试卷，考试测试类-->
			<class name="com.integritytech.ecq.test.student.StudyZNExaminationTest"/>
			<!-- 创建手工试卷下发手工试卷测试类-->
			<class name="com.integritytech.ecq.test.teacher.XFRGTestPaperTest"/>
			<!-- 学生端人工试卷考试测例类-->
			<class name="com.integritytech.ecq.test.student.StudyRGExaminationTest"/>
			<!-- 学生端个人统计中心测试类-->
			<class name="com.integritytech.ecq.test.student.StucountTest"/>
			<!-- 教师端教学统计中心测试类-->
			<class name="com.integritytech.ecq.test.teacher.TeacountTest"/>
			<!-- 教师端工具库管理测试类-->
			<class name="com.integritytech.ecq.test.teacher.ToolAdminTest"/>
			
			
			
			<!-- 教师端删除已下发学习、考试任务-->
			<class name="com.integritytech.ecq.test.teacher.DelEducationTest"/>
			<!-- 教师端删除CTF模板，虚拟机模板，场景模板-->
			<class name="com.integritytech.ecq.test.teacher.DelTrainTest"/>
			<!--  教师端删除班级、学员-->
			<class name="com.integritytech.ecq.test.teacher.DelClassstaffTest"/>
			<!-- 教师端删除我的体系、我的课程、我的所有小节、我的试卷、所有题目、题目分类、所有工具、工具分类-->
			<class name="com.integritytech.ecq.test.teacher.DelSubjectTest"/>
			<!-- 管理员删除教员-->
			<class name="com.integritytech.ecq.test.admin.DelTeacherTest"/>
				
		</classes>
		
	</test>

</suite>
