//package cn.huizhi.controller.root;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.chrono.ChronoLocalDate;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
//
//import cn.huizhi.pojo.ArtClassStudnet;
//import cn.huizhi.pojo.ArtStuRegistration;
//import cn.huizhi.pojo.ChildStuReistration;
//import cn.huizhi.pojo.Class;
//import cn.huizhi.pojo.DepartmentOfPediatrics;
//import cn.huizhi.pojo.Expenditureitems;
//import cn.huizhi.pojo.FeeCategory;
//import cn.huizhi.pojo.HighesClassStudnet;
//import cn.huizhi.pojo.HighesStuRegistration;
//import cn.huizhi.pojo.Order;
//import cn.huizhi.pojo.PaymentMethod;
//import cn.huizhi.pojo.Reserveschool;
//import cn.huizhi.pojo.Student;
//import cn.huizhi.pojo.TeacherDiction;
//import cn.huizhi.pojo.TeacherHour;
//import cn.huizhi.pojo.User;
//import cn.huizhi.pojo.UserDiction;
//import cn.huizhi.service.ArtClassStudnetService;
//import cn.huizhi.service.ArtStuRegistrationService;
//import cn.huizhi.service.ChildStuReistrationService;
//import cn.huizhi.service.ClassService;
//import cn.huizhi.service.DepartmentOfPediatricsService;
//import cn.huizhi.service.ExpenditureitemsService;
//import cn.huizhi.service.FeeCategoryService;
//import cn.huizhi.service.HighesClassStudnetService;
//import cn.huizhi.service.HighesStuRegistrationService;
//import cn.huizhi.service.OrderService;
//import cn.huizhi.service.PaymentMethodService;
//import cn.huizhi.service.ReserveschoolService;
//import cn.huizhi.service.StudentService;
//import cn.huizhi.service.TeacherDictionService;
//import cn.huizhi.service.TeacherHourService;
//import cn.huizhi.service.UserDictionService;
//import cn.huizhi.service.UserService;
//
//@Controller
//public class RootSchoolController {
//	/**
//	 * 学校账户信息
//	 */
//	@Resource
//	OrderService orderService;
//
//	@Resource
//	UserService userService;
//
//	@Resource
//	DepartmentOfPediatricsService departmentOfPediatricsService;
//
//	@Resource
//	FeeCategoryService feeCategoryService;
//
//	@Resource
//	PaymentMethodService paymentMethodService;
//
//	@Resource
//	ClassService classService;
//	@Resource
//	ExpenditureitemsService expenditureitemsService;
//
//	@Resource
//	ChildStuReistrationService childStuReistrationService;
//
//	@Resource
//	TeacherHourService teacherHourService;
//
//	@Resource
//	HighesStuRegistrationService highesStuRegistrationService;
//
//	@Resource
//	ArtStuRegistrationService artStuRegistrationService;
//
//	@Resource
//	StudentService studentService;
//
//	@Resource
//	HighesClassStudnetService highesClassStudnetService;
//
//	@Resource
//	ReserveschoolService reserveSchoolService;
//
//	@Resource
//	ArtClassStudnetService artClassStudnetService;
//	
//	@Resource
//	UserDictionService userDictionService;
//	
//	@Resource
//	TeacherDictionService teacherDictionService;
//	
//	/**
//	 * 切换账户
//	 * 
//	 * @return
//	 */
//	@RequestMapping("switchingAccounts.html")
//	public String switchingAccounts(HttpSession session) {
//
//		return "root/switchingAccounts";
//	}
//
//	/**
//	 * 学校账户余额
//	 * 
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("rootSchoolInfo.html")
//	public String schoolInfo(HttpSession session) {
//
//		Order orders = new Order();
//		orders.setSchoolId((Integer) session.getAttribute("schoolId"));
//		List<Order> schoolOrderList = orderService.findOrderListBySchool(orders);
//		/**
//		 * 共支出
//		 */
//		Double schoolExPenSum = 0.0;
//		/**
//		 * 共收入
//		 */
//		Double schoolFeeceat = 0.0;
//		if (schoolOrderList.size() > 0) {
//			for (Order order : schoolOrderList) {
//				if (order.getIdentification() == 0) {
//					schoolFeeceat += order.getDpMoney();
//				} else if (order.getIdentification() == 1) {
//					schoolExPenSum += order.getFeecategoryMoney();
//				}
//			}
//		}
//		session.setAttribute("schoolExPenSum", schoolExPenSum);
//		session.setAttribute("schoolFeeceat", schoolFeeceat);
//		session.setAttribute("schoolId", orders.getSchoolId());
//		session.setAttribute("schoolOrderList", schoolOrderList);
//		return "root/school/schoolInfo";
//	}
//	
//	
//	@RequestMapping("schoolExpen.html")
//	@ResponseBody
//	public String expenditureOrder(Order order) {
//
//		List<Order> expenditureOrderList = orderService.findOrderListBySchool(order);
//		if (expenditureOrderList.size() > 0) {
//			return JSON.toJSONStringWithDateFormat(expenditureOrderList, "yyyy-MM-dd hh:mm:ss",
//					SerializerFeature.WriteDateUseDateFormat);
//		}
//		return "";
//	}
//
//	/**
//	 * 学校收入总会报表
//	 * 
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("orderInfo.html")
//	public String schoolOrderInfo(HttpSession session) {
//
//		Order order = new Order();
//		order.setSchoolId((Integer) session.getAttribute("schoolId"));
//
//		/**
//		 * 查询数据
//		 */
//		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
//
//		// 课程类型
//		List<DepartmentOfPediatrics> departmentOfPediatricsList = departmentOfPediatricsService
//				.findDepartmentOfPediatrics(order.getSchoolId());
//
//		List<Expenditureitems> expenditureitemList = expenditureitemsService
//				.selectExpenditureitems(String.valueOf(order.getSchoolId()));
//
//		// 账户类型信息
//		List<PaymentMethod> payMentList = paymentMethodService.selectPaymentMethod();
//		// 收入项目类型
//		List<FeeCategory> feeCategoryList = feeCategoryService.selectFeeCategory(order.getSchoolId());
//
//		List<Class> classBySchooList = classService.findChildrenescClasses(String.valueOf(order.getSchoolId()));
//		/**
//		 * 共支出
//		 */
//		Double schoolExPenSum = 0.0;
//		/**
//		 * 共收入
//		 */
//		Double schoolFeeceat = 0.0;
//		if (orderListBySchool.size() > 0) {
//			for (Order order2 : orderListBySchool) {
//				if (order2.getIdentification() == 0) {
//					schoolFeeceat += order2.getDpMoney();
//				} else if (order2.getIdentification() == 1) {
//					schoolExPenSum += order2.getFeecategoryMoney();
//				}
//			}
//		}
//
//		// 总收入，总支出
//		session.setAttribute("schoolExPenSum", schoolExPenSum);
//		session.setAttribute("schoolFeeceat", schoolFeeceat);
//		session.setAttribute("schoolId", order.getSchoolId());
//
//		// 查询添加
//		session.setAttribute("departmentOfPediatricsList", departmentOfPediatricsList);
//		session.setAttribute("classBySchooList", classBySchooList);
//		session.setAttribute("payMentList", payMentList);
//		session.setAttribute("feeCategoryList", feeCategoryList);
//		session.setAttribute("orderListBySchool", orderListBySchool);
//		session.setAttribute("expenditureitemList", expenditureitemList);
//
//		return "root/schoolOrder/schoolOrderInfo";
//	}
//
//	/**
//	 * 支出项目
//	 * @param order
//	 * @param schoolName
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("feecateOrderInfo.html")
//	@ResponseBody
//	public Map<String, String> feecateOrderInfo(Order order, String schoolName, HttpSession session) {
//
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		/**
//		 * 查询数据
//		 */
//		List<Order> orderListBySchool = orderService.findOrderListBySchool(order);
//
//		/**
//		 * 共支出
//		 */
//		Double schoolExPenSum = 0.0;
//		/**
//		 * 共收入
//		 */
//		Double schoolFeeceat = 0.0;
//		if (orderListBySchool.size() > 0) {
//			for (Order order2 : orderListBySchool) {
//				if (order2.getIdentification() == 0) {
//					schoolFeeceat += order2.getDpMoney();
//				} else if (order2.getIdentification() == 1) {
//					schoolExPenSum += order2.getFeecategoryMoney();
//				}
//			}
//		}
//
//		jsonMap.put("orderListBySchool", JSON.toJSONStringWithDateFormat(orderListBySchool, "yyyy-MM-dd hh:mm:ss",
//				SerializerFeature.WriteDateUseDateFormat));
//		jsonMap.put("schoolFeeceat", schoolFeeceat.toString());
//		return jsonMap;
//
//	}
//
//	/**
//	 * 返回班级学校页面
//	 * 
//	 * @param schoolId
//	 * @param schoolName
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("classInfo.html")
//	public String classInfo(Integer schoolId, String schoolName, HttpSession session) {
//
//		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));
//
//		session.setAttribute("classList", classList);
//
//		return "root/classStudent/classSchoolInfo";
//	}
//
//	/**
//	 * 返回学生课时页面
//	 * 
//	 * @param classId
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("schoolStudentHour.html")
//	public String schoolTeacherHour(Integer classId, HttpSession session) {
//		User user = (User) session.getAttribute("user");
//
//		Integer schoolType = (Integer) session.getAttribute("schoolType");
//
//		if (schoolType == 1) {
//			List stuReistrationList = childStuReistrationService.findchildStuReistrationListByClass(classId);
//			session.setAttribute("stuReistrationList", stuReistrationList);
//			return "admin/classStudent/studentHourInfo";
//		}
//		if (schoolType == 2) {
//
//		}
//		if (schoolType == 3) {
//
//		}
//
//		return "";
//	}
//
//	/**
//	 * 返回班级学校页面
//	 * 
//	 * @param schoolId
//	 * @param schoolName
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("curriculumClassInfo.html")
//	public String curriculumClassInfo() {
//		return "root/curriculum/classSchoolInfo";
//	}
//
//	/**
//	 * 返回课程信息
//	 * 
//	 * @param classId
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("curriculumInfo.html")
//	public String curriculumInfo(Integer classId, HttpSession session) {
//
//		List<TeacherHour> curriculumInfoList = teacherHourService.selectCurriculumInfo(classId, null);
//		session.setAttribute("classId", classId);
//		session.setAttribute("curriculumInfoList", curriculumInfoList);
//		return "root/curriculum/classCurriculumInfo";
//	}
//
//	/**
//	 * 创建课程信息
//	 * 
//	 * @param classId
//	 * @return
//	 */
//	@RequestMapping("createCurriclum.html")
//	public String createCurriclum(Integer classId, HttpSession session) {
//
//		Class classInfo = classService.findClassByClassId(classId);
//
//		session.setAttribute("classInfo", classInfo);
//		return "root/curriculum/create/createClassCurriculumInfo";
//	}
//
//	/**
//	 * 返回操作员信息
//	 * 
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("schoolOperatorChilk.html")
//	public String schoolOperatorChilk(HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		List<User> findUserAllByAdmin = userService.findListAll(String.valueOf(user.getuId()));
//		session.setAttribute("findUserAllByAdmin", findUserAllByAdmin);
//		return "root/basicSettings/operator";
//	}
//	
//	
//	@RequestMapping("rootOperatorAuthorization.html")
//	public String operatorAuthorization(Integer uId,HttpSession session) {
//		
//		List<TeacherDiction> dictionListByUId =  teacherDictionService.findTeacherDictionListByTeacherId(uId);
//		
//		session.setAttribute("dictionListByUId", dictionListByUId);
//		
//		return "root/basicSettings/operatorAuthorization";
//	}
//	
//	/**
//	 * 添加权限
//	 * @param userDiction
//	 * @return
//	 */
//	@RequestMapping("rootOperatorAuthor.html")
//	@ResponseBody
//	public Map<String,String> operatorAuthor(TeacherDiction teacherDiction){
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		
//		
//		if(teacherDictionService.addTeacherDiction(teacherDiction.getSchoolId(), teacherDiction.getTeacherId())>0) {
//			jsonMap.put("state","1");
//		}else {
//			jsonMap.put("state","1");
//		}
//		
//		return jsonMap;
//	}
//
//
//	/**
//	 * 添加课程信息
//	 * 
//	 * @param teacherHour
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("insertCurriculum.html")
//	@ResponseBody
//	public Map<String, String> insertCurriculum(TeacherHour teacherHour, HttpSession session) {
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		User user = (User) session.getAttribute("user");
//		teacherHour.setSchoolId((Integer) session.getAttribute("schoolId"));
//		if (teacherHourService.insertTeacherHour(teacherHour) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "0");
//		}
//		return jsonMap;
//	}
//
//	/**
//	 * 根据课程信息查询课程
//	 * 
//	 * @param teacherHourId
//	 * @return
//	 */
//	@RequestMapping("queryCurriculumInfo.html")
//	@ResponseBody
//	public String queryCurriculumInfo(Integer teacherHourId) {
//
//		List<TeacherHour> teacherHour = teacherHourService.selectCurriculumInfo(null, teacherHourId);
//
//		if (teacherHour != null) {
//			return JSON.toJSONStringWithDateFormat(teacherHour, "yyyy-MM-dd hh:mm:ss",
//					SerializerFeature.WriteDateUseDateFormat);
//		}
//		return "";
//	}
//
//	/**
//	 * 修改课程信息
//	 * 
//	 * @param teacherHour
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("updateCurriculumInfo.html")
//	@ResponseBody
//	public Map<String, String> updateCurriculumInfo(TeacherHour teacherHour, HttpSession session) {
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		User user = (User) session.getAttribute("user");
//		teacherHour.setSchoolId((Integer) session.getAttribute("schoolId"));
//		if (teacherHourService.updateTeacherHour(teacherHour) > 0) {
//			jsonMap.put("update", "1");
//		} else {
//			jsonMap.put("update", "0");
//		}
//
//		return jsonMap;
//
//	}
//
//	/**
//	 * 删除课程信息
//	 * 
//	 * @param teacherHourId
//	 * @return
//	 */
//	@RequestMapping("delCurriculumInfo.html")
//	@ResponseBody
//	public Map<String, String> delCurriculumInfo(Integer teacherHourId) {
//
//		Map<String, String> jsonMap = new HashMap<String, String>();
//
//		if (teacherHourService.delTeacherHour(teacherHourId) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "0");
//		}
//
//		return jsonMap;
//
//	}
//
//	/**
//	 * 少儿学生上课登记
//	 * 
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("childrenClassBatchRegistration.html")
//	@ResponseBody
//	public Map<String, String> childrenClassBatchRegistration(String map) {
//		// 转换为map集合
//		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		// 创建添加的内容集合
//		List<ChildStuReistration> list = new ArrayList<ChildStuReistration>();
//		/**
//		 * 修改课时总数
//		 */
//		List<Student> sutList = new ArrayList<Student>();
//
//		Student stu = null;
//		ChildStuReistration children = null;
//		// 循环赋值
//		for (String key : map2.keySet()) {
//
//			if (key == "teacherId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassId(Integer.valueOf((String) studentIdList.get(i)));
//				}
//			}
//			if (key == "studentId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < studentIdList.size(); i++) {
//					// 创建少儿对象
//					children = new ChildStuReistration();
//					children.setChildStuId(Integer.valueOf((String) studentIdList.get(i)));
//					list.add(children);
//
//					// 创建学生对象
//					stu = new Student();
//					stu.setStudentId(Integer.valueOf((String) studentIdList.get(i)));
//					sutList.add(stu);
//				}
//			}
//			if (key == "studentName") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setStudentName(String.valueOf(studentIdList.get(i)));
//				}
//			}
//			if (key == "classHours") {
//				for (int i = 0; i < list.size(); i++) {
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					try {
//						list.get(i).setClassHours(formatter.parse((String) map2.get(key)));
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if (key == "dpId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setDpId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classHour") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassHour(Double.valueOf((String) map2.get(key)));
//					sutList.get(i).setStudentHour(Double.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "teacherInClass") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherInClass(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "contentOfCourses") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setContentOfCourses(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "thId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setThId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//		}
//
//		if (childStuReistrationService.insertChilStuRistration(list) > 0) {
//			if (studentService.updateStuHour(sutList) > 0) {
//				jsonMap.put("state", "1");
//			}
//		} else {
//			jsonMap.put("state", "1");
//		}
//
//		return jsonMap;
//
//	}
//
//	/**
//	 * 高中上课登记
//	 * 
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("highClassBatchRegistration.html")
//	@ResponseBody
//	public Map<String, String> highClassBatchRegistration(String map) {
//		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		List<HighesStuRegistration> list = new ArrayList<HighesStuRegistration>();
//		HighesStuRegistration high = null;
//		for (String key : map2.keySet()) {
//
//			if (key == "teacherId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassId(Integer.valueOf((String) studentIdList.get(i)));
//				}
//			}
//			if (key == "studentId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < studentIdList.size(); i++) {
//					high = new HighesStuRegistration();
//					high.setHighesStuId(Integer.valueOf((String) studentIdList.get(i)));
//					list.add(high);
//				}
//			}
//			if (key == "studentName") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setStudentName(String.valueOf(studentIdList.get(i)));
//				}
//			}
//			if (key == "classHours") {
//				for (int i = 0; i < list.size(); i++) {
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					try {
//						list.get(i).setClassHours(formatter.parse(String.valueOf(map2.get(key))));
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if (key == "dpId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setDpId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classHour") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassHour(Double.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "teacherInClass") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherInClass(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "contentOfCourses") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setContentOfCourses(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "thId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setThId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//		}
//
//		if (highesStuRegistrationService.insertHighesStuRegistration(list) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "1");
//		}
//
//		return jsonMap;
//
//	}
//
//	/**
//	 * 艺考学生批量登记上课
//	 * 
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("artClassBatchRegistration.html")
//	@ResponseBody
//	public Map<String, String> artClassBatchRegistration(String map) {
//		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		List<ArtStuRegistration> list = new ArrayList<ArtStuRegistration>();
//
//		ArtStuRegistration art = null;
//		for (String key : map2.keySet()) {
//			if (key == "teacherId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassId(Integer.valueOf((String) studentIdList.get(i)));
//				}
//			}
//			if (key == "studentId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < studentIdList.size(); i++) {
//					art = new ArtStuRegistration();
//					art.setHighesStuId(Integer.valueOf((String) studentIdList.get(i)));
//					list.add(art);
//				}
//			}
//			if (key == "studentName") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setStudentName(String.valueOf(studentIdList.get(i)));
//				}
//			}
//			if (key == "classHours") {
//				for (int i = 0; i < list.size(); i++) {
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					try {
//						list.get(i).setClassHours(formatter.parse(String.valueOf(map2.get(key))));
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if (key == "dpId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setDpId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "classHour") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassHour(Double.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "teacherInClass") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setTeacherInClass(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "contentOfCourses") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setContentOfCourses(String.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "thId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setThId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//		}
//
//		if (artStuRegistrationService.insertArtStuRegistration(list) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "1");
//		}
//
//		return jsonMap;
//
//	}
//
//	/**
//	 * 高中退学
//	 * 
//	 * @param studentId
//	 * @param session
//	 * @return
//	 */
//	@SuppressWarnings("unlikely-arg-type")
//	@RequestMapping("exitSchool.html")
//	public String highExitSchool(Integer studentId, String studentName, Integer classId, HttpSession session) {
//		// 查询学生的订单信息
// 		List<Order> stuOrders = orderService.selectOrderListByStudentId(studentId);
//		// 存放学生的收费项目
//		List<FeeCategory> feeCategories = new ArrayList<FeeCategory>();
//		// 支出项目
//		List<Expenditureitems> expenditureitems = expenditureitemsService
//				.selectExpenditureitems(String.valueOf((Integer) session.getAttribute("schoolId")));
//
//		// 退费方式
//		List<PaymentMethod> paymentMethods = paymentMethodService.selectPaymentMethod();
//		// 查询学校下的所有收费项目
//		List<FeeCategory> list1 = feeCategoryService.selectFeeCategory(Integer.valueOf((Integer) session.getAttribute("schoolId")));
//		FeeCategory feeCategory = null;
//		String[] feeId;
//
//		String feeIds = "";
//
//		String feeIdName = "";
//
//		Double price = 0.0;
//
//		Double nowPrice = 0.0;
//
//		Double sumMoney = 0.0;
//		// 循环读取订单的收费项目并添加到集合
//		for (Order order : stuOrders) {
//			feeId = order.getFeecateId().split(",");
//			feeIds = order.getFeecateId();
//			for (int i = 0; i < feeId.length; i++) {
//				for (int j = 0; j < list1.size(); j++) {
//					if (list1.get(j).getChargeTypeId() == Integer.valueOf(feeId[i])) {
//						feeCategory = new FeeCategory();
//						feeCategory = list1.get(i);
//						feeIdName += feeCategory.getChargeTypeName();
//						feeIdName += "/";
//						feeCategories.add(feeCategory);
//					}
//				}
//			}
//
//			if (order.getFirstdate() != null && order.getLastdate() != null) {
//
//				// 获取订单开始时间和结束时间
//				long to1 = order.getFirstdate().getTime();
//				long from1 = order.getLastdate().getTime();
//				long date = new Date().getTime();
//
//				// 计算天数
//				int sumDarte = (int) ((from1 - to1) / (1000 * 60 * 60 * 24));
//
//				// 差价天数
//				int nowDate = (int) ((from1 - date) / (1000 * 60 * 60 * 24));
//
//				// 总单价
//				price = order.getDpMoney() / sumDarte;
//				// 退差价
//				nowPrice = price * nowDate;
//				// 总价格
//				sumMoney += order.getDpMoney();
//			}
//		}
//
//		BigDecimal bd = new BigDecimal(nowPrice);
//
//		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
//
//		session.setAttribute("sumMoney", sumMoney);
//		session.setAttribute("nowPrice", bd);
//		session.setAttribute("feeCategories", feeCategories);
//		session.setAttribute("stuOrders", stuOrders);
//		session.setAttribute("studentName", studentName);
//		session.setAttribute("studentId", studentId);
//		session.setAttribute("feeIds", feeIds);
//		session.setAttribute("feeIdName", feeIdName);
//		session.setAttribute("paymentMethods", paymentMethods);
//		session.setAttribute("expenditureitems", expenditureitems);
//		session.setAttribute("classId", classId);
//
//		return "root/studentInfo/high/highExitSchool";
//	}
//
//	/**
//	 * 退学修改
//	 * 
//	 * @param order
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("highExitSchoolSave.html")
//	@ResponseBody
//	public Map<String, Object> highExitSchoolSave(Order order, HttpSession session) {
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//
//		order.setIdentification(1);
//
//		order.setSchoolId((Integer) session.getAttribute("schoolId"));
//		order.setClassId((Integer) session.getAttribute("classId"));
//		order.setOrderNumber("KS" + new Date() + order.getStuId() + new Random().nextInt(100));
//		order.setIntegral(0.0);
//		
//		HighesClassStudnet highesClassStudnet = new HighesClassStudnet();
//		highesClassStudnet.setClassesStudentId(order.getStuId());
//		highesClassStudnet.setState(2);
//		if (orderService.addOrder(order) > 0
//				&& highesClassStudnetService.updateHighStudentState(highesClassStudnet) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "0");
//		}
//		return jsonMap;
//	}
//
//	/**
//	 * 跳转分班页面
//	 * 
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("assignment.html")
//	public String assignment(HttpSession session) {
//
//		Integer schoolId = (Integer) session.getAttribute("schoolId");
//		List<Reserveschool> reserveSchoolList = reserveSchoolService.findReserveschoolBySchoolId(schoolId);
//
//		List<Class> classList = classService.findChildrenescClasses(String.valueOf(schoolId));
//
//		session.setAttribute("reserveSchoolList", reserveSchoolList);
//		session.setAttribute("classList", classList);
//
//		return "root/classAssignment/seeStudentInfo";
//	}
//
//	/**
//	 * 保存分班
//	 * 
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("fenBanSave.html")
//	@ResponseBody
//	public Map<String, Object> fenBanSave(String map) {
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//		Map<String, Object> map2 = (Map<String, Object>) JSONObject.parse(map);
//
//		List<ArtClassStudnet> list = new ArrayList<ArtClassStudnet>();
//
//		ArtClassStudnet art = null;
//		ReserveSchool reserveSchool = null;
//
//		List<Reserveschool> rList = new ArrayList<Reserveschool>();
//
//		for (String key : map2.keySet()) {
//			if (key == "studentId") {
//				List studentIdList = (List) map2.get(key);
//				for (int i = 0; i < studentIdList.size(); i++) {
//					// 添加艺考学生
//					art = new ArtClassStudnet();
//					art.setStudentId(Integer.valueOf((String) studentIdList.get(i)));
//					art.setState(1);
//					list.add(art);
//
//					// 修改学生状态
//					reserveSchool = new Reserveschool();
//					reserveSchool.setStudentId(Integer.valueOf((String) studentIdList.get(i)));
//					reserveSchool.setState(1);
//					rList.add(reserveSchool);
//
//				}
//
//			}
//
//			if (key == "studentName") {
//				List studentNameList = (List) map2.get(key);
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setStudentName(String.valueOf(studentNameList.get(i)));
//
//				}
//			}
//
//			if (key == "startTime") {
//				List startTimeList = (List) map2.get(key);
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				for (int i = 0; i < startTimeList.size(); i++) {
//					try {
//						list.get(i).setEnrollmentTime(formatter.parse((String) startTimeList.get(i)));
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if (key == "classId") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setClassId(Integer.valueOf((String) map2.get(key)));
//				}
//			}
//			if (key == "teacherName") {
//				for (int i = 0; i < list.size(); i++) {
//					list.get(i).setHeadmaster(String.valueOf(map2.get(key)));
//				}
//			}
//
//		}
//
//		if (artClassStudnetService.insertArtClassStudnetList(list) > 0
//				&& reserveSchoolService.updateReserveState(rList) > 0) {
//			jsonMap.put("state", "1");
//		} else {
//			jsonMap.put("state", "0");
//		}
//
//		return jsonMap;
//	}
//	
//	
//	/**
//	 * 返回班级科别主页
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("classTypeInfo.html")
//	public String classTypeInfo(HttpSession session){
//		Integer schoolId = (Integer) session.getAttribute("schoolId");
//		List<DepartmentOfPediatrics> classDepartmentOfPediatrics = departmentOfPediatricsService.findDepartmentOfPediatrics(schoolId);
//		session.setAttribute("classDepartmentOfPediatrics", classDepartmentOfPediatrics);
//		
//		List<FeeCategory> feeCategorieList = feeCategoryService.selectFeeCategory(schoolId);
//		session.setAttribute("feeCategorieList", feeCategorieList);
//		
//		return "root/classTypeInfo/classType";
//	}
//	
//	/**
//	 * 添加班级科别
//	 * @param departmentOfPediatrics
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("addDepartmentOfPediatrics.html")
//	@ResponseBody
//	public Map<String,String> addDepartmentOfPediatrics(DepartmentOfPediatrics departmentOfPediatrics,HttpSession session){
//		Map<String, String> jsonMap = new HashMap<String, String>();
//		departmentOfPediatrics.setSchoolId((Integer) session.getAttribute("schoolId"));
//		if(departmentOfPediatricsService.addDepartmentOfPediatrics(departmentOfPediatrics)>0) {
//			jsonMap.put("state", "1");
//		}else {
//			jsonMap.put("state", "0");
//		}
//		return jsonMap;
//	}
//	
//	/**
//	 * 删除班级类型
//	 * @param dpId
//	 * @return
//	 */
//	@RequestMapping("deleteDepartmentOfPediatrics.html")
//	@ResponseBody
//	public Map<String, String> deleteDepartmentOfPediatrics(Integer dpId){
//		
//		Map<String,String> jsonMap = new HashMap<String, String>();
//		
//		if(departmentOfPediatricsService.delDepartmentOfPediatrics(dpId)>0) {
//			jsonMap.put("state", "1");
//		}else {
//			jsonMap.put("state", "0");
//		}
//		return jsonMap;
//		
//	}
//	
//	/**
//	 * 教师课时总表
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("teacherHourSum.html")
//	public String teacherHourSum(HttpSession session) {
//		
//		List<TeacherHour> teacherHourList = teacherHourService.findTeacherHourListBySchoolId((Integer) session.getAttribute("schoolId"));
//		session.setAttribute("teacherHourList", teacherHourList);
//		
//		return "root/teacher/teacherInfo";
//	}
//	
//	/**
//	 * 跳转学生课时选择班级页面
//	 * @return
//	 */
//	@RequestMapping("classStudentHourInfo.html")
//	public String classStudentHourInfo() {
//		return "root/classStudent/classSchoolInfo";
//	}
//	
//	/**
//	 * 返回学生课时页面
//	 * @param classId
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("studentHourInfo.html")
//	public String studentHourInfo(Integer classId,HttpSession session) {
//		Integer  schoolType = (Integer) session.getAttribute("schoolType");
//		List stuReistrationList = null;
//		if(schoolType == 1) {
//			stuReistrationList = childStuReistrationService.findchildStuReistrationListByClass(classId);
//		}
//		if(schoolType == 2) {
//			stuReistrationList = highesStuRegistrationService.selectHighesStuRegistrationListByClassId(classId);
//		}
//		if(schoolType == 3) {
//			stuReistrationList = artStuRegistrationService.findArtStuRegistrationByClassId(classId);
//		}
//		
//		session.setAttribute("stuReistrationList", stuReistrationList);
//		
//		return "root/classStudent/studentHourInfo";
//	}
//}
