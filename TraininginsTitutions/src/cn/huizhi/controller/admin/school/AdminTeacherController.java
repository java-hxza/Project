package cn.huizhi.controller.admin.school;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.TeacherDiction;
import cn.huizhi.pojo.TeacherHour;
import cn.huizhi.pojo.User;
import cn.huizhi.pojo.UserDiction;
import cn.huizhi.service.ArtStuRegistrationService;
import cn.huizhi.service.ChildStuReistrationService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartMentService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.HighesStuRegistrationService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
import cn.huizhi.service.StudentService;
import cn.huizhi.service.TeacherDictionService;
import cn.huizhi.service.TeacherHourService;
import cn.huizhi.service.TeacherService;
import cn.huizhi.service.UserDictionService;
import cn.huizhi.service.UserService;
import cn.huizhi.pojo.ArtStuRegistration;
import cn.huizhi.pojo.ChildStuReistration;
import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.HighesStuRegistration;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.Student;

@Controller
public class AdminTeacherController {
	@Resource
	TeacherService teacherService;
	@Resource
	TeacherHourService teacherHourService;

	@Resource
	TeacherDictionService teacherDictionService;

	@Resource
	ClassService classService;

	@Resource
	ChildStuReistrationService childStuReistrationService;

	@Resource
	StudentService studentService;

	@Resource
	DepartMentService departMentServie;

	@Resource
	HighesStuRegistrationService highesStuRegistrationService;

	@Resource
	OrderService orderService;

	@Resource
	UserDictionService userDictionService;

	@Resource
	ArtStuRegistrationService artStuRegistrationService;

	@Resource
	PaymentMethodService paymentMethodService;

	@Resource
	DepartmentOfPediatricsService departmentOfPediatricsService;
	
	@Resource
	UserService userService;

	@RequestMapping("schoolTeacherInfo.html")
	public String schoolTeacherInfo(Integer schoolId, String schoolName, HttpSession session) {
		session.setAttribute("schoolName", schoolName);
		List<Teacher> teacherListBYSchoolId = teacherService.findTeacherListBySchoolId(schoolId);
		session.setAttribute("schoolId", schoolId);
		if (teacherListBYSchoolId.size() > 0) {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		} else {
			session.setAttribute("teacherListBYSchoolId", teacherListBYSchoolId);
		}

		return "admin/schoolTeacherInfo";
	}

	/**
	 * 根据教师主键查询教师信息
	 * 
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("selectTeacher.html")
	@ResponseBody
	public String selectTeacher(Integer teacherId) {
		Teacher teacher = teacherService.findTeacherByTeacherId(teacherId);
		Map<String, String> jsonMap = new HashMap<String, String>();
		List<DepartMent> departMents = departMentServie.selectDepartMentListAll();
		if (teacher != null) {
			jsonMap.put("teacher", JSON.toJSONString(teacher));
			jsonMap.put("departMents", JSON.toJSONString(departMents));
		}
		return JSON.toJSONString(jsonMap);
	}

	/**
	 * 校验登录名
	 * 
	 * @param teacherName
	 * @return
	 */
	@RequestMapping("teacherNameCheck.html")
	@ResponseBody
	public Map<String, String> teacherNameCheck(String teacherName) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		if (teacherService.findTeacherByTeacherName(teacherName) != null) {
			jsonMap.put("state", "0");
		} else {
			jsonMap.put("state", "1");
		}
		return jsonMap;
	}

	/**
	 * 添加教师
	 * 
	 * @param teacher
	 * @param schoolId
	 * @return
	 */
	@RequestMapping("regitTeacher.html")
	@ResponseBody
	public Map<String, String> createTeacher(Teacher teacher, Integer schoolId) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		// 如果添加成功返回1不成功返回0
		if (teacherService.addTeacher(teacher) > 0) {
			if (teacherDictionService.addTeacherDiction(schoolId, teacher.getTeacherId()) > 0) {
				jsonMap.put("state", "1");
			} else {
				jsonMap.put("state", "0");
			}
		} else {
			jsonMap.put("state", "0");
		}
		return jsonMap;
	}

	/**
	 * 删除教师
	 * 
	 * @return
	 */
	@RequestMapping("delAdminTeacher.html")
	@ResponseBody
	public Object delTeacher(@RequestParam Integer teacherId, Integer schoolId, HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (teacherService.delTeacher(teacherId) == 1) {
			if (teacherDictionService.delTeacherDiction((Integer) session.getAttribute("schoolId"), teacherId) == 1) {
				map.put("del", "1");
			} else {
				map.put("del", "0");
			}
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 根据教师主键查询教书所存在的学校
	 * 
	 * @param teacherId
	 * @param session
	 * @return
	 */
	@RequestMapping("teacherAuthorization.html")
	public String teacherAuthorization(Integer teacherId, HttpSession session) {
		// 调用方法
		List<TeacherDiction> teacherDictionListByTeacherId = teacherDictionService
				.findTeacherDictionListByTeacherId(teacherId);
		session.setAttribute("teacherDictionListByTeacherId", teacherDictionListByTeacherId);
		return "admin/school/authorization/teacherAuthorization";
	}

	@RequestMapping("authorization.html")
	@ResponseBody
	public Map<String, String> authorization(Integer teacherId, Integer schoolId,Integer state) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		TeacherDiction teacherDiction = teacherDictionService.findTeacherDictionBySchoolIdAndTeacherId(schoolId,
				teacherId);
		if (teacherDiction != null) {
			jsonMap.put("state", "2");
			return jsonMap;
		}
		if (teacherDictionService.addTeacherDiction(schoolId, teacherId) > 0) {
			
			Teacher teacher = new Teacher();
			if(state !=null) {
				teacher.setTeacherId(teacherId);
				teacher.setState(state);
				if(teacherService.updateTeacher(teacher)>0) {
					jsonMap.put("state", "1");
				}
			}
			jsonMap.put("state", "1");
		} else {
			jsonMap.put("state", "0");
		}
		return jsonMap;
	}

	/**
	 * 返回选择学校教师视图
	 * 
	 * @return
	 */
	@RequestMapping("selectOrderTeacherInfo.html")
	public String selectOrderTeacherInfo() {
		return "admin/teacher/selectOrderTeacherInfo";
	}

	/**
	 * 查询教师课时并返回信息
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("teacherInfo.html")
	public String teacherInfo(Integer schoolId, String schoolName, HttpSession session) {
		TeacherHour teacherHour = new TeacherHour();
		teacherHour.setSchoolId(schoolId);
		List<TeacherHour> teacherHourList = teacherHourService.findTeacherHourListBySchoolId(teacherHour);

		List<Teacher> teachers = teacherService.findTeacherListBySchoolId(schoolId);
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics(schoolId);

		session.setAttribute("schoolName", schoolName);
		session.setAttribute("teacherHourList", teacherHourList);
		session.setAttribute("teachers", teachers);
		session.setAttribute("schoolId", schoolId);
		session.setAttribute("departmentOfPediatrics", departmentOfPediatrics);
		return "admin/teacher/teacherInfo";
	}

	@RequestMapping("queryTeacherInfo.html")
	@ResponseBody
	public Map<String, Object> queryTeacherInfo(TeacherHour teacherHour, HttpSession session) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		Integer schoolId = (Integer) session.getAttribute("schoolId");
		teacherHour.setSchoolId(schoolId);
		List<TeacherHour> teacherHourList = teacherHourService.findTeacherHourListBySchoolId(teacherHour);

		jsonMap.put("teacherHourList", JSON.toJSONStringWithDateFormat(teacherHourList, "yyyy-MM-dd hh:mm:ss"));
		jsonMap.put("schoolName", session.getAttribute("schoolName"));

		return jsonMap;
	}

	/**
	 * 返回选择学校视图
	 * 
	 * @return
	 */
	@RequestMapping("selectClassSchoolInfo.html")
	public String selectClassSchool() {
		return "admin/classStudent/selectClassSchoolInfo";
	}
/*
	*//**
	 * 返回班级学校页面
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 *//*
	@RequestMapping("classSchoolInfo.html")
	public String classSchoolInfo(Integer schoolId, String schoolName, HttpSession session) {



		return "admin/classStudent/classSchoolInfo";
	}
*/
	/**
	 * 返回少儿班级学生课时信息
	 * 
	 * @param classId
	 * @param session
	 * @return
	 */
	@RequestMapping("childrenStudentHourInfo.html")
	public String studentHourInfo(Integer schoolId,String schoolName, HttpSession session) {
		List<ChildStuReistration> stuReistrationList = childStuReistrationService
				.findchildStuReistrationListByClass(null, null, null);
		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classList", classList);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("stuReistrationList", stuReistrationList);
		return "admin/classStudent/studentHourInfo";
	}
	
	/**
	 * 按照条件查询少儿课时记录
	 * @param startTime
	 * @param endTime
	 * @param classId
	 * @param session
	 * @return
	 */
	@RequestMapping("queryStudentHour.html")
	public String queryStudentHour(String startTime, String endTime, Integer classId,HttpSession session) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (endTime == null || endTime == "") {
			endTime = formatter.format(new Date());
		}
		if (startTime == null || startTime == "") {
			startTime = formatter.format(new Date());
		}

		List<ChildStuReistration> stuReistrationList = childStuReistrationService
				.findchildStuReistrationListByClass(classId, startTime, endTime);
		session.setAttribute("stuReistrationList", stuReistrationList);
		return "admin/classStudent/studentHourInfo";
	}

	@RequestMapping("studentBill.html")
	@ResponseBody
	public Map<String, Object> studentBill(Integer studentId) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		List<Order> studentOrders = orderService.selectOrderListByStudentId(studentId);

		jsonMap.put("studentOrders", JSON.toJSONStringWithDateFormat(studentOrders, "yyyy-MM-dd hh:mm:ss"));

		String paymentName = null;
		List<String> parmentNameArray = new ArrayList<String>();
		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();

		for (int i = 0; i < paymentMethods.size(); i++) {
			for (int j = 0; j < studentOrders.size(); j++) {
				if (paymentMethods.get(i).getPaymentmethodId() == studentOrders.get(j).getPaymentmethodId()) {
					paymentName = paymentMethods.get(i).getPaymentmethodName();
					parmentNameArray.add(paymentName);
				}
			}
		}
		jsonMap.put("paymentName", parmentNameArray);

		return jsonMap;
	}
	/*	*//**
			 * 返回高中班级课时信息
			 * 
			 * @param classId
			 * @param session
			 * @return
			 */
	/*
	 * @RequestMapping("highStudentHourInfo.html") public String
	 * HighStudentHourInfo(Integer classId, HttpSession session) { List
	 * stuReistrationList =
	 * highesStuRegistrationService.selectHighesStuRegistrationListByClassId(classId
	 * );
	 * 
	 * session.setAttribute("stuReistrationList", stuReistrationList);
	 * 
	 * return "admin/classStudent/studentHourInfo"; }
	 * 
	 *//**
		 * 返回艺考班级课时
		 * 
		 * @param classId
		 * @param session
		 * @return
		 *//*
			 * @RequestMapping("artStudentHourInfo.html") public String
			 * artStudentHourInfo(Integer classId,HttpSession session) {
			 * List<ArtStuRegistration> artStuRegistrationList =
			 * artStuRegistrationService.findArtStuRegistrationByClassId(classId);
			 * 
			 * session.setAttribute("stuReistrationList", artStuRegistrationList);
			 * 
			 * return "admin/classStudent/studentHourInfo"; }
			 */

	/**
	 * 返回选择学校页面
	 * 
	 * @return
	 */
	@RequestMapping("selectAddStuInfo.html")
	public String selectAddStuInfo() {

		return "admin/addStudentInfo/selectAddStuInfo";
	}

	/**
	 * 返回新增学员信息
	 * 
	 * @return
	 */
	@RequestMapping("childrenAddStudentInfo.html")
	public String ChildrenAddStudentInfo(Integer schoolId, String schoolName, String startTime, String endTime,
			Integer schoolType, HttpSession session) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);

		List<Student> addstudentList = studentService.selectChildren(schoolId, map);

		session.setAttribute("stuCount", addstudentList.size());
		session.setAttribute("stuClassification", "少儿");
		session.setAttribute("schoolType", schoolType);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		return "admin/addStudentInfo/addStudentInfo";
	}

	/**
	 * 返回新增学员信息
	 * 
	 * @return
	 */
	@RequestMapping("highAddStudentInfo.html")
	public String hegiAddStudentInfo(Integer schoolId, String schoolName, String startTime, String endTime,
			Integer schoolType, HttpSession session) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);

		List<Student> addstudentList = studentService.selectHigh(schoolId, map);

		session.setAttribute("stuCount", addstudentList.size());
		session.setAttribute("stuClassification", "高中");
		session.setAttribute("schoolType", schoolType);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		return "admin/addStudentInfo/addStudentInfo";
	}

	/**
	 * 返回新增学员信息
	 * 
	 * @return
	 */
	@RequestMapping("yiKaoAddStudentInfo.html")
	public String yiKaoAddStudentInfo(Integer schoolId, String schoolName, String startTime, String endTime,
			Integer schoolType, HttpSession session) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);

		List<Student> addstudentList = studentService.selectHigh(schoolId, map);

		session.setAttribute("stuCount", addstudentList.size());
		session.setAttribute("stuClassification", "艺考");
		session.setAttribute("schoolType", schoolType);
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolId", schoolId);
		return "admin/addStudentInfo/addStudentInfo";
	}

	/**
	 * 教师上课明细
	 * 
	 * @return
	 */
	@RequestMapping("selectSchoolTeacherClassHourInfo.html")
	public String selectSchoolTeacherClassHourInfo() {
		return "admin/teacher/selectSchoolTeacherClassHourInfo";
	}

	/**
	 * 返回班级学校页面
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param session
	 * @return
	 */
	@RequestMapping("teacherClassSchoolInfo.html")
	public String TeacherClassSchoolInfo(Integer schoolId, String schoolName, HttpSession session) {

		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classList", classList);

		return "admin/teacher/classSchoolInfo";
	}

	/**
	 * 返回教师上课明细页面
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @return
	 */
	@RequestMapping("teacherClassHourInfo.html")
	public String teacherClassHourInfo(Integer classId, String schoolName, Integer schoolType, HttpSession session) {
		// 判断学校类型
		session.setAttribute("schoolName", schoolName);

		List<TeacherHour> teacherHourList = teacherHourService.selectCurriculumInfo(classId, null);

		/*
		 * if (schoolType == 1) { List<ChildStuReistration> childStuHourDetailedList =
		 * childStuReistrationService .selectTeacherDetailed(classId);
		 * 
		 * session.setAttribute("childStuHourDetailedList", childStuHourDetailedList);
		 * return "admin/teacher/childrenFeeInfo"; } if (schoolType == 2) {
		 * List<HighesStuRegistration> highesStuRegistrations =
		 * highesStuRegistrationService .selectStudentHourDetailed(classId);
		 * 
		 * session.setAttribute("highesStuRegistrations", highesStuRegistrations);
		 * return "admin/teacher/highFeeInfo";
		 * 
		 * } if (schoolType == 3) {
		 * 
		 * }
		 */

		session.setAttribute("teacherHourList", teacherHourList);
		return "admin/teacher/childrenFeeInfo";
	}

	@RequestMapping("selectStudentFeeInfo.html")
	public String selectStudentFeeInfo() {
		return "admin/studentInfo/selectStudentFeeInfo";
	}

/*	*//**
	 * 学生收费情况
	 * 
	 * @param schoolId
	 * @param schoolName
	 * @param schoolType
	 * @param session
	 * @return
	 *//*
	@RequestMapping("classStudentFeeInfo.html")
	public String classStudentFeeInfo(String schoolName, Integer schoolType, HttpSession session) {
	

		return "admin/studentInfo/classSchoolInfo";
	}
*/
	/**
	 * 返回学生明细表
	 * 
	 * @return
	 */
	@RequestMapping("studentFeeSituation.html")
	public String studentFeeSituation(Integer schoolId,  String schoolName, Integer schoolType, HttpSession session) {

		List<Order> studentFeeSituationList = null;
		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));

		session.setAttribute("classList", classList);
		if (schoolType == 1) {
			studentFeeSituationList = orderService.selectChildrenFeeSituation(null, null, null, null);
		}
		if (schoolType == 2) {
			studentFeeSituationList = orderService.selectHighsFeeSituation(null, null, null);
		}
		if (schoolType == 3) {
			studentFeeSituationList = orderService.selectArtFeeSituation(null, null, null);
		}
		session.setAttribute("schoolName", schoolName);
		session.setAttribute("schoolType", schoolType);
		session.setAttribute("studentFeeSituationList", studentFeeSituationList);
		return "admin/studentInfo/studentFeeSituation";
	}

	/**
	 * 返回学院收费情况报表
	 * 
	 * @param startTime
	 * @param endTime
	 * @param session
	 * @return
	 */
	@RequestMapping("queryStudent.html")
	public String queryStudent(String startTime, String endTime,Integer classId ,HttpSession session) {
		List<Order> studentFeeSituationList = null;
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (endTime == null || endTime == "" ) {
			endTime = formatter.format(new Date());
		}
		if (startTime == null || startTime == "") {
			startTime = formatter.format(new Date());
		}

		if (schoolType == 1) {
			studentFeeSituationList = orderService.selectChildrenFeeSituation(classId, null, startTime, endTime);
		}
		if (schoolType == 2) {
			studentFeeSituationList = orderService.selectHighsFeeSituation(classId, startTime, endTime);
		}
		if (schoolType == 3) {
			studentFeeSituationList = orderService.selectArtFeeSituation(classId, startTime, endTime);
		}

		session.setAttribute("studentFeeSituationList", studentFeeSituationList);

		return "admin/studentInfo/studentFeeSituation";

	}

	@RequestMapping("operatorAuthorization.html")
	public String operatorAuthorization(Integer uId, HttpSession session) {
		List<UserDiction> dictionListByUId = userDictionService.findDictionListByUserId(uId);

		session.setAttribute("dictionListByUId", dictionListByUId);

		return "admin/basicSettings/operatorAuthorization";
	}

	/**
	 * 添加权限
	 * 
	 * @param userDiction
	 * @return
	 */
	@ResponseBody
	@RequestMapping("operatorAuthor.html")
	public Map<String, String> operatorAuthor(UserDiction userDiction, Integer state) {
		Map<String, String> jsonMap = new HashMap<String, String>();

		if (userDictionService.insertUserDiction(userDiction) > 0) {
			if (state != null) {
				User user = new User();
				user.setuId(userDiction.getUserId());
				user.setState(state);
				if (userService.modifyUser(user)>0) {
					jsonMap.put("state", "1");
				}
			}
			jsonMap.put("state", "1");
		} else {
			jsonMap.put("state", "1");
		}

		return jsonMap;
	}

}
