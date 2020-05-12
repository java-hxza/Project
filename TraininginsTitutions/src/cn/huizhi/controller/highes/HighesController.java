package cn.huizhi.controller.highes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Gift;
import cn.huizhi.pojo.Activity;
import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.pojo.Class;
import cn.huizhi.pojo.ClassTime;
import cn.huizhi.pojo.ClassType;
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.pojo.Student;
import cn.huizhi.pojo.StudentTool;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.Reserveschool;
import cn.huizhi.pojo.School;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ActivityService;
import cn.huizhi.service.ChildrenesClassStudnetService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.ClassTimeService;
import cn.huizhi.service.ClassTypeService;
import cn.huizhi.service.DepartMentService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.GiftService;
import cn.huizhi.service.StudentService;
import cn.huizhi.service.StudentToolService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
import cn.huizhi.service.ReserveschoolService;
import cn.huizhi.service.SchoolService;
import cn.huizhi.service.TeacherDictionService;
import cn.huizhi.service.TeacherService;
import cn.huizhi.service.TeacherTypeService;
import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.TeacherType;

@Controller
public class HighesController {

	/**
	 * 注入容器
	 */
	@Resource
	private FeeCategoryService feecategoryService;
	@Resource
	private PaymentMethodService paymentMethodService;
	@Resource
	private ExpenditureitemsService expenditureitemsService;
	@Resource
	HttpSession session;
	@Resource
	private TeacherService teacherService;
	@Resource
	private TeacherTypeService teacherTypeService;
	@Resource
	private TeacherDictionService teacherDictionService;
	@Resource
	private StudentService studentService;
	@Resource
	private DepartmentOfPediatricsService departmentOfPediatricsService;
	@Resource
	private OrderService orderService;
	@Resource
	private ClassService classService;
	@Resource
	private GiftService giftService;
	@Resource
	private ActivityService activityService;
	@Resource
	private ChildrenesClassStudnetService childrenesClassStudnetService;
	@Resource
	private ReserveschoolService reserveschoolService;
	@Resource
	private ClassTypeService classTypeService;
	@Resource
	private DepartMentService departMentService;
	@Resource
	private ClassTimeService classTimeService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private StudentToolService studentToolService;

	Integer OrderHour = 1;

	/**
	 * 查询所有账户信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Accountinformation.html")
	public String Accountinformation(Model model) {
		List<PaymentMethod> list = paymentMethodService.selectPaymentMethod();
		model.addAttribute("schoolType", (Integer) session.getAttribute("schoolType"));
		model.addAttribute("list", list);
		return "high/Accountinformation";
	}

	/**
	 * 删除账户信息
	 * 
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("delAccountinformation.html")
	@ResponseBody
	public Object DelAccountinformation(@RequestParam int paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (paymentMethodService.delPaymentMethod(paymentmethodId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加账户信息
	 * 
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("addAccountinformation.html")
	@ResponseBody
	public Object AddAccountinformation(@RequestParam String paymentmethodName) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (paymentMethodService.addPaymentMethod(paymentmethodName) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询所有收入项目
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Incomeitems.html")
	public String Incomeitems(Model model, HttpSession session) {
		List<FeeCategory> list = feecategoryService.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		model.addAttribute("list", list);
		return "high/Incomeitems";
	}

	/**
	 * 删除收入项目
	 * 
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("delIncomeitems.html")
	@ResponseBody
	public Object DelIncomeitems(@RequestParam int chargeTypeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (feecategoryService.delFeeCategory(chargeTypeId)) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加收入项目
	 * 
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("addIncomeitems.html")
	@ResponseBody
	public Object AddIncomeitems(FeeCategory feeCategory, HttpSession session) {

		Map<String, String> map = new HashMap<String, String>();
		if (feeCategory.getSchoolId() == null) {
			feeCategory.setSchoolId((Integer) session.getAttribute("schoolId"));
		}

		if (feecategoryService.addFeeCategory(feeCategory) > 0) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询所有支出项目
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Expenditureitemses.html")
	public String Expenditureitemses(Model model) {
		List<Expenditureitems> list = expenditureitemsService
				.selectExpenditureitems(String.valueOf((Integer) session.getAttribute("schoolId")));
		model.addAttribute("list", list);
		return "high/Expenditureitemses";
	}

	/**
	 * 删除支出项目
	 * 
	 * @param expenditureitemsId
	 * @return
	 */
	@RequestMapping("delExpenditureitemses.html")
	@ResponseBody
	public Object DelExpenditureitemses(@RequestParam int expenditureitemsId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (expenditureitemsService.delExpenditureitems(expenditureitemsId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加支出项目
	 * 
	 * @param expenditureitemsName
	 * @param category
	 * @return
	 */
	@RequestMapping("addExpenditureitemses.html")
	@ResponseBody
	public Object AddExpenditureitemses(@RequestParam String expenditureitemsName, @RequestParam String category) {
		HashMap<String, String> map = new HashMap<String, String>();
		Integer schoolId = (Integer) session.getAttribute("schoolId");
		if (expenditureitemsService.addExpenditureitems(expenditureitemsName, category, schoolId.toString()) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询所有的教师
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Teacher.html")
	public String Teacher(Model model) {
		List<Teacher> teacher = teacherService.findTeacherListBySchoolId((Integer) session.getAttribute("schoolId"));
		List<TeacherType> teacherType = teacherTypeService.selectTeacherType();
		List<DepartMent> departMents = departMentService.selectDepartMentListAll();
		model.addAttribute("teacher", teacher);
		model.addAttribute("departMents", departMents);
		model.addAttribute("teacherType", teacherType);
		return "high/Teacher";
	}

	/**
	 * 删除教师
	 * 
	 * @return
	 */
	@RequestMapping("delTeacher.html")
	@ResponseBody
	public Object delTeacher(@RequestParam Integer teacherId) {
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
	 * 修改教师
	 * 
	 * @return
	 */
	@RequestMapping("updateTeacher.html")
	@ResponseBody
	public Object updateTeacher(Teacher teacher, HttpSession session) {
		teacher.setFeeCategory((Integer) session.getAttribute("schoolType"));
		HashMap<String, String> map = new HashMap<String, String>();
		if (teacherService.updateTeacher(teacher) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加教师
	 * 
	 * @return
	 */
	@RequestMapping("addTeacher.html")
	@ResponseBody
	public Object addTeacher(Teacher teacher, HttpSession session) {
		teacher.setFeeCategory((Integer) session.getAttribute("schoolType"));
		HashMap<String, String> map = new HashMap<String, String>();
		if (teacherService.addTeacher(teacher) == 1 && teacherDictionService
				.addTeacherDiction((Integer) session.getAttribute("schoolId"), teacher.getTeacherId()) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 收费按课时
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("ChargeHours.html")
	public String ChargeHours(Model model) {
		List<Class> classes = classService.selectClass((Integer) session.getAttribute("schoolId"), 1);
		if (classes.size() > 0) {
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet",
					classes.get(0).getClassId(), 1);
			model.addAttribute("children", children);
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("activity", activity);
		model.addAttribute("gift", gift);
		model.addAttribute("classes", classes);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		return "high/AddChargeHours";
	}

	/**
	 * 收费按课时另开项目
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("ChargeHours2.html")
	public String ChargeHours2(Model model) {
		List<Student> student = studentService.selectStudentUsedIntegral("childrenesclassstudnet",
				(Integer) session.getAttribute("schoolId"));
		if (student.size() > 0) {
			List<Class> classes = classService.selectUnopenedClass(student.get(0).getStudentId());
			List<Student> studentInformation = studentService.selectStudentInformation(student.get(0).getStudentId());
			String sex = "";
			if(studentInformation.get(0).getStudentSex() == 0) {
				sex = "女";
			}else {
				sex = "男";
			}
			String studentInformations = studentInformation.get(0).getStudentName() + " " + sex + " " + studentInformation.get(0).getStudentBirth() + " " + studentInformation.get(0).getClasses().getClassName();
			model.addAttribute("studentInformation", studentInformations);
			String classIds = "";
			for (int i = 0; i < classes.size(); i++) {
				classIds += classes.get(i).getClassId() + ",";
			}
			List<Class> classes2 = classService.selectNotUnopenedClass(classIds.substring(0, classIds.length() - 1),
					(Integer) session.getAttribute("schoolId"),1);
			model.addAttribute("classes", classes2);
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("activity", activity);
		model.addAttribute("gift", gift);
		model.addAttribute("student", student);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		return "high/AddChargeHours2";
	}
	
	/**
	 * 查询学生信息
	 * @param studentId
	 * @return
	 */
	@RequestMapping("StudentInformation.html")
	@ResponseBody
	public Object StudentInformation(@RequestParam Integer studentId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Student> studentInformation = studentService.selectStudentInformation(studentId);
		String sex = "";
		if(studentInformation.get(0).getStudentSex() == 0) {
			sex = "女";
		}else {
			sex = "男";
		}
		String studentInformations = studentInformation.get(0).getStudentName() + " " + sex + " " + studentInformation.get(0).getStudentBirth() + " " + studentInformation.get(0).getClasses().getClassName();
		map.put("studentInformation", studentInformations);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询学生未开班级
	 * @param studentId
	 * @return
	 */
	@RequestMapping("ChargeHoursClass.html")
	@ResponseBody
	public Object ChargeHoursClass(@RequestParam Integer studentId,@RequestParam Integer classTypeTime) {
 		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Class> classes = classService.selectUnopenedClass(studentId);
		if(classes.size() > 0) {
			String classIds = "";
			for (int i = 0; i < classes.size(); i++) {
				classIds += classes.get(i).getClassId() + ",";
			}
			List<Class> classes2 = classService.selectNotUnopenedClass(classIds.substring(0, classIds.length() - 1),
					(Integer) session.getAttribute("schoolId"),classTypeTime);
			map.put("classes", classes2);
		}else {
			map.put("classes", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 根据班级选择学生
	 * 
	 * @param classId
	 * @return
	 */
	@RequestMapping("selectClassStudent.html")
	@ResponseBody
	public Object selectClassStudent(@RequestParam Integer classId) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (schoolType == 1) {
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet", classId, 1);
			map.put("children", children);
		} else if (schoolType == 2) {
			List<Student> children = studentService.selectStudentClass("highesclassstudnet", classId, 1);
			map.put("children", children);
		} else if (schoolType == 3) {
			List<Student> children = studentService.selectStudentClass("artclassstudnet", classId, 1);
			map.put("children", children);
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 根据班级选择学生2
	 * 
	 * @param classId
	 * @return
	 */
	@RequestMapping("selectClassStudent2.html")
	@ResponseBody
	public Object selectClassStudent2(@RequestParam Integer classId) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (schoolType == 1) {
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet", classId, 2);
			if (children.size() > 0) {
				Order order = orderService.selectOrderTF(children.get(0).getStudentId());
				map.put("order", order);
			}
			map.put("children", children);
		} else if (schoolType == 2) {
			List<Student> children = studentService.selectStudentClass("highesclassstudnet", classId, 2);
			if (children.size() > 0) {
				Order order = orderService.selectOrderTF(children.get(0).getStudentId());
				map.put("order", order);
			}
			map.put("children", children);
		} else if (schoolType == 3) {
			List<Student> children = studentService.selectStudentClass("artclassstudnet", classId, 2);
			if (children.size() > 0) {
				Order order = orderService.selectOrderTF(children.get(0).getStudentId());
				map.put("order", order);
			}
			map.put("children", children);
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 根据学生选择订单
	 * 
	 * @param classId
	 * @return
	 */
	@RequestMapping("selectClassStudentOrder.html")
	@ResponseBody
	public Object selectClassStudentOrder(@RequestParam Integer studentId) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (schoolType == 1) {
			Order order = orderService.selectOrderTF(studentId);
			map.put("order", order);
		} else if (schoolType == 2) {
			Order order = orderService.selectOrderTF(studentId);
			map.put("order", order);
		} else if (schoolType == 3) {
			Order order = orderService.selectOrderTF(studentId);
			map.put("order", order);
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加收费按课时
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addChargeHours.html")
	@ResponseBody
	public Object AddChargeHours(@RequestParam Integer stuId, @RequestParam String feecateId,
			@RequestParam Double dpMoney, @RequestParam String startTime,
			@RequestParam Integer departmentofpediatricsId, @RequestParam Integer addhour,
			@RequestParam Integer givehour, @RequestParam String remarks, @RequestParam Integer paymentmethodId,
			@RequestParam String date, @RequestParam Integer classId, @RequestParam Double integral,
			@RequestParam Integer giftId, @RequestParam Integer giftNumber, @RequestParam Integer activityId,
			@RequestParam Double discount, @RequestParam String startTimes, @RequestParam Double serviceCharge) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setStuId(stuId);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setRemarks(remarks);
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime + startTimes);
			order.setStartTime(startTime1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setIdentification(0);
		order.setAddhour(addhour);
		School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
		if (OrderHour >= 10) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 100) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 1000) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
					+ school.getSchoolNumber());
		} else {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
					+ school.getSchoolNumber());
		}
		schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"), school.getSchoolNumber() + 1);
		order.setGivehour(givehour);
		order.setDepartmentofpediatricsId(departmentofpediatricsId);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setServiceCharge(serviceCharge);
		order.setActivityId(activityId);
		order.setDiscount(discount);
		order.setClassId(classId);
		order.setIntegral(integral);
		order.setRenew(1);
		order.setGiftId(giftId);
		order.setFeecateMoney(String.valueOf(dpMoney));
		if (giftNumber == null) {
			order.setGiftNumber(0);
		} else {
			order.setGiftNumber(giftNumber);
		}
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.addOrder(order) == 1) {
			if (studentService.updateStudentOrderHour(addhour + givehour, stuId, integral) == 1) {
				if (giftNumber != null) {
					if (giftService.updateGift(-giftNumber, giftId) == 1) {
						map.put("add", "1");
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "1");
				}
			} else {
				map.put("add", "0");
				return JSONArray.toJSONString(map);
			}
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 收费按时间段
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("ChargePeriod.html")
	public String ChargePeriod(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 0);
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {
			if (schoolType == 1) {
				List<Student> children = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("children", children);

			} else if (schoolType == 2) {
				List<Student> children = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("children", children);
			} else if (schoolType == 3) {
				List<Student> children = studentService.selectStudentClass("artclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("children", children);
			}
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("gift", gift);
		model.addAttribute("activity", activity);
		model.addAttribute("schoolType", (Integer) session.getAttribute("schoolType"));
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		return "high/AddCharge";
	}
	
	/**
	 * 收费按时间段
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("ChargePeriod2.html")
	public String ChargePeriod2(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Student> student = studentService.selectStudentUsedIntegral("childrenesclassstudnet",
				(Integer) session.getAttribute("schoolId"));
		if (student.size() > 0) {
			List<Class> classes = classService.selectUnopenedClass(student.get(0).getStudentId());
			List<Student> studentInformation = studentService.selectStudentInformation(student.get(0).getStudentId());
			String sex = "";
			if(studentInformation.get(0).getStudentSex() == 0) {
				sex = "女";
			}else {
				sex = "男";
			}
			String studentInformations = studentInformation.get(0).getStudentName() + " " + sex + " " + studentInformation.get(0).getStudentBirth() + " " + studentInformation.get(0).getClasses().getClassName();
			model.addAttribute("studentInformation", studentInformations);
			String classIds = "";
			for (int i = 0; i < classes.size(); i++) {
				classIds += classes.get(i).getClassId() + ",";
			}
			List<Class> classes2 = classService.selectNotUnopenedClass(classIds.substring(0, classIds.length() - 1),
					(Integer) session.getAttribute("schoolId"),0);
			model.addAttribute("classes", classes2);
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("gift", gift);
		model.addAttribute("activity", activity);
		model.addAttribute("schoolType", (Integer) session.getAttribute("schoolType"));
		model.addAttribute("student", student);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		return "high/AddCharge2";
	}

	/**
	 * 添加收费按时间段
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addChargePeriod.html")
	@ResponseBody
	public Object AddChargePeriod(@RequestParam Integer stuId, @RequestParam String startTime,
			@RequestParam String feecateId, @RequestParam Double dpMoney, @RequestParam String firstdate,
			@RequestParam String lastdate, @RequestParam String personliable, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId, @RequestParam Integer classId, @RequestParam Integer giftId,
			@RequestParam Integer giftNumber, @RequestParam Double integral, @RequestParam Integer hour,
			@RequestParam String date, @RequestParam Double discount, @RequestParam Integer activityId,
			@RequestParam String startTimes, @RequestParam String feecateMoney, @RequestParam Double serviceCharge) {
		HashMap<String, String> map = new HashMap<String, String>();
		OrderHour += 1;
		Order order = new Order();
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime + startTimes);
			Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
			Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
			order.setStartTime(startTime1);
			order.setFirstdate(firstdate1);
			order.setLastdate(lastdate1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setStuId(stuId);
		order.setPersonliable(personliable);
		order.setRemarks(remarks);
		order.setGiftNumber(giftNumber);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setGiftId(giftId);
		order.setClassId(classId);
		order.setRenew(1);
		order.setServiceCharge(serviceCharge);
		order.setFeecateMoney(feecateMoney);
		order.setIntegral(integral);
		order.setActivityId(activityId);
		order.setDiscount(discount);
		School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
		if (OrderHour >= 10) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 100) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 1000) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
					+ school.getSchoolNumber());
		} else {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
					+ school.getSchoolNumber());
		}
		schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"), school.getSchoolNumber() + 1);
		order.setPaymentmethodId(paymentmethodId);
		order.setIdentification(0);
		if (orderService.addOrder(order) == 1) {
			if (studentService.updateStudentOrderHour(hour, stuId, integral) == 1) {
				if (giftNumber != 0) {
					if (giftService.updateGift(-giftNumber, giftId) == 1) {
						map.put("add", "1");
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "1");
				}
			} else {
				map.put("add", "0");
				return JSONArray.toJSONString(map);
			}
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 收费其他
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("ChargeOthers.html")
	public String ChargeOthers(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {

			if (schoolType == 1) {
				List<Student> high = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("high", high);
			} else if (schoolType == 2) {
				List<Student> high = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("high", high);
			} else if (schoolType == 3) {
				List<Student> high = studentService.selectStudentClass("artclassstudnet", classes.get(0).getClassId(),
						1);
				model.addAttribute("high", high);
			}
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		return "high/AddChargeOthers";
	}

	/**
	 * 添加收费其他
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addChargeOthers.html")
	@ResponseBody
	public Object AddChargeOthers(@RequestParam Integer stuId, @RequestParam String startTime,
			@RequestParam String feecateId, @RequestParam Double dpMoney, @RequestParam String personliable,
			@RequestParam String remarks, @RequestParam Integer paymentmethodId, @RequestParam String date,
			@RequestParam Integer classId, @RequestParam String startTimes, @RequestParam Double serviceCharge) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setIdentification(0);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime + startTimes);
			order.setStartTime(startTime1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setPersonliable(personliable);
		order.setDpMoney(dpMoney);
		order.setIntegral(0.0);
		order.setServiceCharge(serviceCharge);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setClassId(classId);
		order.setGiftId(0);
		order.setGiftNumber(0);
		School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
		if (OrderHour >= 10) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 100) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 1000) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
					+ school.getSchoolNumber());
		} else {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
					+ school.getSchoolNumber());
		}
		schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"), school.getSchoolNumber() + 1);
		OrderHour += 1;
		order.setStuId(stuId);
		if (orderService.addOrder(order) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("delCharge.html")
	@ResponseBody
	public Object delCharge(@RequestParam Integer orderId, @RequestParam Integer stuId, @RequestParam Integer hour,
			@RequestParam Double integral, @RequestParam Integer giftId, @RequestParam Integer giftNumber) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (orderService.delOrder(orderId) == 1) {
			if (studentService.updateStudentOrderHour(hour, stuId, integral) == 1) {
				if (giftNumber != 0) {
					if (giftService.updateGift(giftNumber, giftId) == 1) {
						map.put("del", "1");
					} else {
						map.put("del", "0");
						return JSONArray.toJSONString(map);
					}
				}
				map.put("del", "1");
			} else {
				map.put("del", "0");
				return JSONArray.toJSONString(map);
			}
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除其他支出订单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("delChargeOtheres.html")
	@ResponseBody
	public Object delChargeOtheres(@RequestParam Integer orderId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (orderService.delOrder(orderId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改课时订单
	 * 
	 * @return
	 */
	@RequestMapping("updateChargeHour.html")
	@ResponseBody
	public Object updateChargeHour(@RequestParam Integer stuId, @RequestParam String feecateId,
			@RequestParam Double dpMoney, @RequestParam Integer addhour, @RequestParam Integer givehour,
			@RequestParam String remarks, @RequestParam Integer paymentmethodId, @RequestParam Integer orderId,
			@RequestParam Integer hour, @RequestParam Integer giftId, @RequestParam Integer giftNumber,
			@RequestParam Integer giftId2, @RequestParam Integer giftNumber2, @RequestParam Double integral,
			@RequestParam Double integrals, @RequestParam Double discount, @RequestParam Integer activityId) {
		Order order = new Order();
		HashMap<String, String> map = new HashMap<String, String>();
		order.setStuId(stuId);
		order.setRemarks(remarks);
		order.setAddhour(addhour);
		order.setGivehour(givehour);
		order.setOrderId(orderId);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setDiscount(discount);
		order.setActivityId(activityId);
		order.setIntegral(integral);
		if (giftId != -2 && giftId != -1) {
			order.setGiftId(giftId);
		} else if (giftId == -2 && giftNumber == 0) {
			order.setGiftId(giftNumber);
		} else {
			order.setGiftId(giftId2);
		}
		order.setGiftNumber(giftNumber);
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.updateOrderAll(order) == 1) {
			if (dpMoney != 0) {
				if (studentService.updateStudentOrderHour(hour, stuId, integrals) == 1) {
					map.put("update", "1");
				} else {
					map.put("update", "0");
					return JSONArray.toJSONString(map);
				}
			} else {
				if (giftId != -1) {
					if (giftNumber2 != 0) {
						if (giftService.updateGift(giftNumber2, giftId2) == 1) {
							map.put("update", "1");
						} else {
							map.put("update", "0");
							return JSONArray.toJSONString(map);
						}
					}
					if (giftId != -2) {
						if (giftService.updateGift(-giftNumber, giftId) == 1) {
							map.put("update", "1");
						} else {
							map.put("update", "0");
							return JSONArray.toJSONString(map);
						}
					} else {
						map.put("update", "1");
					}
				} else {
					map.put("update", "1");
				}
				map.put("update", "1");
			}
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改时间段订单
	 * 
	 * @return
	 */
	@RequestMapping("updateCharge.html")
	@ResponseBody
	public Object updateCharge(@RequestParam Integer stuId, @RequestParam Double dpMoney,
			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId, @RequestParam Integer orderId, @RequestParam Integer time,
			@RequestParam Integer giftNumber, @RequestParam Integer giftId, @RequestParam Integer giftNumber2,
			@RequestParam Integer giftId2, @RequestParam Double integral, @RequestParam Integer activityId,
			@RequestParam Double integrals, @RequestParam String personliable, @RequestParam Double discount,
			@RequestParam String feecateId, @RequestParam String feecateMoney) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setStuId(stuId);
		order.setRemarks(remarks);
		try {
			Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
			Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
			order.setFirstdate(firstdate1);
			order.setLastdate(lastdate1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setOrderId(orderId);
		order.setDpMoney(dpMoney);
		order.setIntegral(integral);
		order.setFeecateId(feecateId);
		order.setFeecateMoney(feecateMoney);
		order.setActivityId(activityId);
		if (giftId != -2 && giftId != -1) {
			order.setGiftId(giftId);
		} else if (giftId == -2 && giftNumber == 0) {
			order.setGiftId(giftNumber);
		} else {
			order.setGiftId(giftId2);
		}
		order.setGiftNumber(giftNumber);
		order.setPersonliable(personliable);
		order.setDiscount(discount);
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.updateOrderAll(order) == 1) {
			if (dpMoney != 0) {
				if (studentService.updateStudentOrderHour(time, stuId, integrals) == 1) {
					map.put("update", "1");
				} else {
					map.put("update", "0");
					return JSONArray.toJSONString(map);
				}
			}
			if (giftId != -1) {
				if (giftNumber2 != 0) {
					if (giftService.updateGift(giftNumber2, giftId2) == 1) {
						map.put("update", "1");
					} else {
						map.put("update", "0");
						return JSONArray.toJSONString(map);
					}
				}
				if (giftId != -2) {
					if (giftService.updateGift(-giftNumber, giftId) == 1) {
						map.put("update", "1");
					} else {
						map.put("update", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("update", "1");
				}
			} else {
				map.put("update", "1");
			}
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改高中收费时间段
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping("updateCharges.html")
	@ResponseBody
	public Object updateCharges(@RequestParam Integer stuId, @RequestParam Double dpMoney,
			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId, @RequestParam Integer orderId, @RequestParam Integer time,
			@RequestParam String personliable, @RequestParam Double discount, @RequestParam String feecateId,
			@RequestParam String feecateMoney) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setOrderId(orderId);
		order.setDpMoney(dpMoney);
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setFeecateMoney(feecateMoney);
		order.setPersonliable(personliable);
		order.setDiscount(discount);
		try {
			Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
			Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
			order.setFirstdate(firstdate1);
			order.setLastdate(lastdate1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (orderService.updateOrderAll(order) == 1) {
			if (studentService.updateStudentOrderHour(time, stuId, 0.0) == 1) {
				map.put("update", "1");
			}
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改其他订单
	 * 
	 * @return
	 */
	@RequestMapping("updateChargeOther.html")
	@ResponseBody
	public Object updateChargeOther(@RequestParam Integer stuId, @RequestParam String startTime,
			@RequestParam String feecateId, @RequestParam Double dpMoney, @RequestParam String personliable,
			@RequestParam String remarks, @RequestParam Integer paymentmethodId, @RequestParam Integer orderId) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
			order.setStartTime(startTime1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setPersonliable(personliable);
		order.setDpMoney(dpMoney);
		order.setOrderId(orderId);
		order.setStuId(stuId);
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

//	/**
//	 * 费用支出
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("OrderExpenditure.html")
//	public String OrderExpenditure(Model model) {
//		List<Student> high = studentService.selectHigh(Integer.parseInt(user.getSchoolId()),
//				new HashMap<Object, Object>());
//		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
//		List<Expenditureitems> expenditureitems = expenditureitemsService.selectExpenditureitems(user.getSchoolId());
//		model.addAttribute("high", high);
//		model.addAttribute("school", high.get(0).getSchool());
//		model.addAttribute("paymentMethod", paymentMethod);
//		model.addAttribute("expenditureitems", expenditureitems);
//		return "high/Expenditure";
//	}

	/**
	 * 添加支出订单
	 * 
	 * @param schoolId
	 * @param stuId
	 * @param startTime
	 * @param feecategoryMoney
	 * @param expenditureitemsId
	 * @param paymentmethodId
	 * @param personliable
	 * @param remarks
	 * @return
	 */
	@RequestMapping("AddOrderExpenditure.html")
	@ResponseBody
	public Object AddOrderExpenditure(@RequestParam Integer stuId, @RequestParam String startTime,
			@RequestParam Double feecategoryMoney, @RequestParam Integer expenditureitemsId,
			@RequestParam Integer paymentmethodId, @RequestParam String personliable, @RequestParam String remarks,
			@RequestParam String date, @RequestParam Integer classId, @RequestParam String startTimes) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setIdentification(1);
		order.setRemarks(remarks);
		order.setPersonliable(personliable);
		order.setPaymentmethodId(paymentmethodId);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setStuId(stuId);
		order.setClassId(classId);
		order.setGiftId(0);
		order.setGiftNumber(0);
		order.setIntegral(0.0);
		School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
		if (OrderHour >= 10) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 100) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 1000) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
					+ school.getSchoolNumber());
		} else {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
					+ school.getSchoolNumber());
		}
		schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"), school.getSchoolNumber() + 1);
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime + startTimes);
			order.setStartTime(startTime1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setExpenditureitemsId(expenditureitemsId);
		order.setFeecategoryMoney(feecategoryMoney);
		if (orderService.addOrder(order) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改支出订单
	 * 
	 * @param schoolId
	 * @param stuId
	 * @param startTime
	 * @param feecategoryMoney
	 * @param expenditureitemsId
	 * @param paymentmethodId
	 * @param personliable
	 * @param remarks
	 * @return
	 */
	@RequestMapping("UpdateOrderExpenditure.html")
	@ResponseBody
	public Object UpdateOrderExpenditure(Order order) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询收费课时
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderHour.html")
	public String selectOrderHour(Model model, @RequestParam Integer orderCounts, @RequestParam Integer classId,
			@RequestParam String studentName) {
		Integer pageCount = 0;
		Integer orderNumber = orderService.selectCountHour((Integer) session.getAttribute("schoolId"));
		if ("000111".equals(studentName)) {
			studentName = null;
		}
		int num = orderNumber % 20 == 0 ? orderNumber / 20 : orderNumber / 20 + 1;
		model.addAttribute("orderCount", num);
		if (num == 0) {
			model.addAttribute("orderCounts", 0);
		} else {
			if (orderCounts <= 0) {
				model.addAttribute("orderCounts", 1);
			} else if (orderCounts == num) {
				model.addAttribute("orderCounts", orderCounts);
			} else {
				model.addAttribute("orderCounts", orderCounts + 1);
				orderCounts += 1;
			}
			if (orderCounts < 0) {
				orderCounts = 1;
			}
			for (int i = 1; i < orderCounts; i++) {
				pageCount += 20;
			}
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		if (classId == 0 && studentName == null) {
			List<Order> order = orderService.selectOrderHour((Integer) session.getAttribute("schoolId"), pageCount,
					null, classId);
			model.addAttribute("order", order);
		} else {
			List<Order> order = orderService.selectOrderHour((Integer) session.getAttribute("schoolId"), null,
					studentName, classId);
			model.addAttribute("order", order);
		}
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 1);
		model.addAttribute("classes", classes);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		model.addAttribute("gift", gift);
		model.addAttribute("activity", activity);
		if (classId != 0 || studentName != null) {
			model.addAttribute("JY", 0);
		} else {
			model.addAttribute("JY", 1);
		}
		return "high/ChargeHours";
	}

	/**
	 * 查询收费时间段
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderPeriod.html")
	public String selectOrderPeriod(Model model, @RequestParam Integer orderCounts, @RequestParam Integer classId,
			@RequestParam String studentName) {
		Integer pageCount = 0;
		Integer orderNumber = orderService.selectCount((Integer) session.getAttribute("schoolId"));
		if ("000111".equals(studentName)) {
			studentName = null;
		}
		int num = orderNumber % 20 == 0 ? orderNumber / 20 : orderNumber / 20 + 1;
		model.addAttribute("orderCount", num);
		if (num == 0) {
			model.addAttribute("orderCounts", 0);
		} else {
			if (orderCounts <= 0) {
				model.addAttribute("orderCounts", 1);
			} else if (orderCounts == num) {
				model.addAttribute("orderCounts", orderCounts);
			} else {
				model.addAttribute("orderCounts", orderCounts + 1);
				orderCounts += 1;
			}
			if (orderCounts < 0) {
				orderCounts = 1;
			}
			for (int i = 1; i < orderCounts; i++) {
				pageCount += 20;
			}
		}
		if ((Integer) session.getAttribute("schoolType") == 3) {
			if (classId == 0 && studentName == null) {
				List<Order> order = orderService.selectOrderPeriods((Integer) session.getAttribute("schoolId"),
						pageCount, null, classId);
				model.addAttribute("order", order);
			} else {
				List<Order> order = orderService.selectOrderPeriods((Integer) session.getAttribute("schoolId"), null,
						studentName, classId);
				model.addAttribute("order", order);
			}
		} else {
			if (classId == 0 && studentName == null) {
				List<Order> order = orderService.selectOrderPeriod((Integer) session.getAttribute("schoolId"),
						pageCount, null, classId);
				model.addAttribute("order", order);
			} else {
				List<Order> order = orderService.selectOrderPeriod((Integer) session.getAttribute("schoolId"), null,
						studentName, classId);
				model.addAttribute("order", order);
			}
		}
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		if ((Integer) session.getAttribute("schoolType") == 1) {
			List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 1);
			model.addAttribute("classes", classes);
		} else {
			List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 0);
			model.addAttribute("classes", classes);
		}
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		model.addAttribute("gift", gift);
		model.addAttribute("activity", activity);
		model.addAttribute("schoolType", (Integer) session.getAttribute("schoolType"));
		if (classId != 0 || studentName != null) {
			model.addAttribute("JY", 0);
		} else {
			model.addAttribute("JY", 1);
		}
		return "high/Charge";
	}

	/**
	 * 查询收费其他
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderOthers.html")
	public String selectOrderOthers(Model model, @RequestParam Integer orderCounts, @RequestParam Integer classId,
			@RequestParam String studentName) {
		Integer pageCount = 0;
		Integer orderNumber = orderService.selectCountOther((Integer) session.getAttribute("schoolId"));
		if ("000111".equals(studentName)) {
			studentName = null;
		}
		int num = orderNumber % 20 == 0 ? orderNumber / 20 : orderNumber / 20 + 1;
		model.addAttribute("orderCount", num);
		if (num == 0) {
			model.addAttribute("orderCounts", 0);
		} else {
			if (orderCounts <= 0) {
				model.addAttribute("orderCounts", 1);
			} else if (orderCounts == num) {
				model.addAttribute("orderCounts", orderCounts);
			} else {
				model.addAttribute("orderCounts", orderCounts + 1);
				orderCounts += 1;
			}
			if (orderCounts < 0) {
				orderCounts = 1;
			}
			for (int i = 1; i < orderCounts; i++) {
				pageCount += 20;
			}
		}
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		if (classId == 0 && studentName == null) {
			List<Order> order = orderService.selectOrderOther((Integer) session.getAttribute("schoolId"), pageCount,
					null, classId);
			model.addAttribute("order", order);
		} else {
			List<Order> order = orderService.selectOrderOther((Integer) session.getAttribute("schoolId"), null,
					studentName, classId);
			model.addAttribute("order", order);
		}
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		if (classId != 0 || studentName != null) {
			model.addAttribute("JY", 0);
		} else {
			model.addAttribute("JY", 1);
		}
		return "high/ChargeOthers";
	}

	/**
	 * 查询费用支出
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderExpenditure.html")
	public String selectOrderExpenditure(Model model, @RequestParam Integer orderCounts, @RequestParam Integer classId,
			@RequestParam String studentName) {
		Integer pageCount = 0;
		Integer orderNumber = orderService.selectCountExpenditure((Integer) session.getAttribute("schoolId"));
		if ("000111".equals(studentName)) {
			studentName = null;
		}
		int num = orderNumber % 20 == 0 ? orderNumber / 20 : orderNumber / 20 + 1;
		model.addAttribute("orderCount", num);
		if (num == 0) {
			model.addAttribute("orderCounts", 0);
		} else {
			if (orderCounts <= 0) {
				model.addAttribute("orderCounts", 1);
			} else if (orderCounts == num) {
				model.addAttribute("orderCounts", orderCounts);
			} else {
				model.addAttribute("orderCounts", orderCounts + 1);
				orderCounts += 1;
			}
			if (orderCounts < 0) {
				orderCounts = 1;
			}
			for (int i = 1; i < orderCounts; i++) {
				pageCount += 20;
			}
		}
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {
			if (schoolType == 1) {
				List<Student> student = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			} else if (schoolType == 2) {
				List<Student> student = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			} else if (schoolType == 3) {
				List<Student> student = studentService.selectStudentClass("artclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			}
		}
		Integer schoolId = (Integer) session.getAttribute("schoolId");
		if (classId == 0 && studentName == null) {
			List<Order> order = orderService.selectOrderExpenditure((Integer) session.getAttribute("schoolId"),
					pageCount, null, classId);
			model.addAttribute("order", order);
		} else {
			List<Order> order = orderService.selectOrderExpenditure((Integer) session.getAttribute("schoolId"), null,
					studentName, classId);
			model.addAttribute("order", order);
		}
		List<Expenditureitems> expenditureitems = expenditureitemsService.selectExpenditureitems(schoolId.toString());
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("expenditureitems", expenditureitems);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		if (classId != 0 || studentName != null) {
			model.addAttribute("JY", 0);
		} else {
			model.addAttribute("JY", 1);
		}
		return "high/Expenditure";
	}

	/**
	 * 查询退费订单
	 * 
	 * @param model
	 * @param orderCounts
	 * @param classId
	 * @param studentName
	 * @return
	 */
	@RequestMapping("selectRefund.html")
	public String selectRefund(Model model, @RequestParam Integer orderCounts, @RequestParam Integer classId,
			@RequestParam String studentName) {
		Integer pageCount = 0;
		Integer orderNumber = orderService.selectCountRefund((Integer) session.getAttribute("schoolId"));
		if ("000111".equals(studentName)) {
			studentName = null;
		}
		int num = orderNumber % 20 == 0 ? orderNumber / 20 : orderNumber / 20 + 1;
		model.addAttribute("orderCount", num);
		if (num == 0) {
			model.addAttribute("orderCounts", 0);
		} else {
			if (orderCounts <= 0) {
				model.addAttribute("orderCounts", 1);
			} else if (orderCounts == num) {
				model.addAttribute("orderCounts", orderCounts);
			} else {
				model.addAttribute("orderCounts", orderCounts + 1);
				orderCounts += 1;
			}
			if (orderCounts < 0) {
				orderCounts = 1;
			}
			for (int i = 1; i < orderCounts; i++) {
				pageCount += 20;
			}
		}
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {
			if (schoolType == 1) {
				List<Student> student = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			} else if (schoolType == 2) {
				List<Student> student = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			} else if (schoolType == 3) {
				List<Student> student = studentService.selectStudentClass("artclassstudnet",
						classes.get(0).getClassId(), 1);
				model.addAttribute("student", student);
			}
		}
		if (classId == 0 && studentName == null) {
			List<Order> order = orderService.selectOrderRefund((Integer) session.getAttribute("schoolId"), pageCount,
					null, classId);
			model.addAttribute("order", order);
		} else {
			List<Order> order = orderService.selectOrderRefund((Integer) session.getAttribute("schoolId"), null,
					studentName, classId);
			model.addAttribute("order", order);
		}
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		if (classId != 0 || studentName != null) {
			model.addAttribute("JY", 0);
		} else {
			model.addAttribute("JY", 1);
		}
		return "high/Refund";
	}

	/**
	 * 退费
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Refund.html")
	public String Refund(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {
			if (schoolType == 1) {
				List<Student> high = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId(), 2);
				if (high.size() > 0) {
					Order order = orderService.selectOrderTF(high.get(0).getStudentId());
					model.addAttribute("order", order);
				}
				model.addAttribute("high", high);
			} else if (schoolType == 2) {
				List<Student> high = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId(), 2);
				if (high.size() > 0) {
					Order order = orderService.selectOrderTF(high.get(0).getStudentId());
					model.addAttribute("order", order);
				}
				model.addAttribute("high", high);
			} else if (schoolType == 3) {
				List<Student> high = studentService.selectStudentClass("artclassstudnet", classes.get(0).getClassId(),
						2);
				if (high.size() > 0) {
					Order order = orderService.selectOrderTF(high.get(0).getStudentId());
					model.addAttribute("order", order);
				}
				model.addAttribute("high", high);
			}
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		model.addAttribute("classes", classes);
		model.addAttribute("paymentMethod", paymentMethod);
		return "high/AddRefund";
	}

	/**
	 * 添加退费
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addRefund.html")
	@ResponseBody
	public Object addRefund(@RequestParam Integer stuId, @RequestParam String startTime, @RequestParam String feecateId,
			@RequestParam String feecateMoney, @RequestParam String personliable, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId, @RequestParam String date, @RequestParam Integer classId,
			@RequestParam String startTimes, @RequestParam Double serviceCharge) {
		HashMap<String, String> map = new HashMap<String, String>();
		Order order = new Order();
		order.setIdentification(3);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startTime + startTimes);
			order.setStartTime(startTime1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setPersonliable(personliable);
		order.setFeecateMoney(feecateMoney);
		order.setIntegral(0.0);
		order.setServiceCharge(serviceCharge);
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setClassId(classId);
		order.setGiftId(0);
		order.setGiftNumber(0);
		School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
		if (OrderHour >= 10) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 100) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
					+ school.getSchoolNumber());
		} else if (OrderHour >= 1000) {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
					+ school.getSchoolNumber());
		} else {
			order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
					+ school.getSchoolNumber());
		}
		schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"), school.getSchoolNumber() + 1);
		order.setStuId(stuId);
		if (orderService.addOrder(order) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询学校活动
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectActivitySchools.html")
	public String selectActivitySchools(Model model) {
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("activity", activity);
		return "high/Activity";
	}

	/**
	 * 查询参与活动订单
	 * 
	 * @param startTime
	 * @param activityIdName
	 * @return
	 */
	@RequestMapping("selectActivityOrderes.html")
	@ResponseBody
	public Object selectActivityOrderes(@RequestParam String startTime, @RequestParam Integer activityId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Order> order = orderService.selectActivityOrders(startTime, activityId,
				(Integer) session.getAttribute("schoolId"));
		map.put("order", order);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加学校活动
	 * 
	 * @param activity
	 * @return
	 */
	@RequestMapping("addActivitySchools.html")
	@ResponseBody
	public Object addActivitySchools(Activity activity) {
		HashMap<String, String> map = new HashMap<String, String>();
		activity.setSchoolId((Integer) session.getAttribute("schoolId"));
		if (activityService.addActivitySchool(activity) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除学校活动
	 * 
	 * @param activityId
	 * @return
	 */
	@RequestMapping("delActivitySchools.html")
	@ResponseBody
	public Object delActivitySchools(Integer activityId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (activityService.delActivitySchool(activityId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询赠品
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectgifts.html")
	public String selectgifts(Model model) {
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		model.addAttribute("gift", gift);
		return "high/Gift";
	}

	/**
	 * 查询赠品报表统计
	 * 
	 * @param startTime
	 * @param giftId
	 * @return
	 */
	@RequestMapping("selectGiftes.html")
	@ResponseBody
	public Object selectGiftes(@RequestParam String startTime, @RequestParam Integer giftId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Order> order = orderService.selectGiftes(startTime, giftId, (Integer) session.getAttribute("schoolId"));
		map.put("order", order);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除赠品
	 * 
	 * @param giftId
	 * @return
	 */
	@RequestMapping("delgifts.html")
	@ResponseBody
	public Object delgifts(@RequestParam Integer giftId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (giftService.delGift(giftId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 添加赠品
	 * 
	 * @param gift
	 * @return
	 */
	@RequestMapping("addgifts.html")
	@ResponseBody
	public Object addgifts(Gift gift) {
		HashMap<String, String> map = new HashMap<String, String>();
		gift.setSchoolId((Integer) session.getAttribute("schoolId"));
		if (giftService.addGift(gift) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改赠品
	 * 
	 * @param giftId
	 * @param giftNumber
	 * @return
	 */
	@RequestMapping("updategifts.html")
	@ResponseBody
	public Object updategifts(@RequestParam Integer giftId, @RequestParam Integer giftNumber) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (giftService.updateGift(giftNumber, giftId) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查询 赠品、税分
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectUsedIntegral.html")
	public String selectUsedIntegral(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		String table = null;
		if (schoolType == 1) {
			table = "childrenesclassstudnet";
		} else if (schoolType == 2) {
			table = "highesclassstudnet";
		} else if (schoolType == 3) {
			table = "artclassstudnet";
		}
		List<Student> student = studentService.selectStudentUsedIntegral(table,
				(Integer) session.getAttribute("schoolId"));
		if (student.size() > 0) {
			String sql = "";
			for (int i = 0; i < student.size(); i++) {
				sql = sql + student.get(i).getStudentId() + " or ";
			}
			sql = sql.substring(0, sql.length() - 3);
			System.out.println();
			List<Order> order = orderService.selectUsedIntegral(sql);
			model.addAttribute("order", order);
		}
		List<Class> classes = classService.selectMyClass((Integer) session.getAttribute("schoolId"));
		model.addAttribute("student", student);
		model.addAttribute("classes", classes);
		return "high/GiftUsedIntegral";
	}

	/**
	 * 课程到期提醒
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectStudentDepartmentofpediatrics.html")
	public String selectStudentDepartmentofpediatrics(Model model) {
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		return "high/CourseReminder";
	}

	/**
	 * 注册学生页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("StduentRegister.html")
	public String StduentRegister(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		if (schoolType == 1) {
			model.addAttribute("schoolTypes", 1);
		} else if (schoolType == 2) {
			model.addAttribute("schoolTypes", 2);
		} else if (schoolType == 3) {
			model.addAttribute("schoolTypes", 3);
		}
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Teacher> teachers = teacherService.selectTeacherType((Integer) session.getAttribute("schoolId"));
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		List<ClassType> classType = classTypeService.selectClassTypes((Integer) session.getAttribute("schoolId"));
		List<ClassTime> classTime = classTimeService.selectClassTime((Integer) session.getAttribute("schoolId"));
		model.addAttribute("activity", activity);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("teachers", teachers);
		model.addAttribute("gift", gift);
		model.addAttribute("classType", classType);
		model.addAttribute("classTime", classTime);
		return "high/RegisterStudent";
	}

	/**
	 * 注册学生选择班级
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("RegisterClassStudent.html")
	@ResponseBody
	public Object RegisterClassStudent(@RequestParam Integer classTypeId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Class> classes = classService.selectVIPClass(classTypeId, (Integer) session.getAttribute("schoolId"));
		map.put("classes", classes);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 注册少儿课时
	 * 
	 * @param classId
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param departmentofpediatricsId
	 * @param addhour
	 * @param givehour
	 * @param remarks2
	 * @param paymentmethodId
	 * @param date
	 * @param integral
	 * @param giftId
	 * @param giftNumber
	 * @param teacherId
	 * @param discount
	 * @param activityId
	 * @param schoolTime
	 * @param serviceCharge
	 * @param entertainTeacher
	 * @param consultationTeacher
	 * @return
	 */
	@RequestMapping("RegisterStudentsHour.html")
	@ResponseBody
	public Object RegisterStudentsHour(@RequestParam Integer classId, Student student, @RequestParam String feecateId,
			@RequestParam Double dpMoney, @RequestParam Integer departmentofpediatricsId, @RequestParam Integer addhour,
			@RequestParam Integer givehour, @RequestParam String remarks2, @RequestParam Integer paymentmethodId,
			@RequestParam String date, @RequestParam Double integral, @RequestParam Integer giftId,
			@RequestParam Integer giftNumber, @RequestParam Integer teacherId, @RequestParam Double discount,
			@RequestParam Integer activityId, @RequestParam String schoolTime, @RequestParam Double serviceCharge,
			@RequestParam String entertainTeacher, @RequestParam String consultationTeacher,
			@RequestParam String headmasters,@RequestParam String className,@RequestParam Integer teachers) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
 		HashMap<String, Object> map = new HashMap<String, Object>();
     		student.setIntegral(0.0);
 		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		student.setConsultationTeacher(consultationTeacher);
		student.setEntertainTeacher(entertainTeacher);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
 			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
			childrenesClassStudnet.setSchoolTime(schoolTime);
			childrenesClassStudnet.setHeadmaster(headmasters);
			try {
				Date startTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime());
				childrenesClassStudnet.setEnrollmentTime(startTimes);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet) == 1) {
				Order order = new Order();
				order.setStuId(childrenesClassStudnet.getStudentId());
				order.setSchoolId((Integer) session.getAttribute("schoolId"));
				order.setRemarks(remarks2);
				order.setStartTime(childrenesClassStudnet.getEnrollmentTime());
				order.setIdentification(0);
				order.setAddhour(addhour);
				order.setRenew(0);
				School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
				if (OrderHour >= 10) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 100) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 1000) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
							+ school.getSchoolNumber());
				} else {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
							+ school.getSchoolNumber());
				}
				schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"),
						school.getSchoolNumber() + 1);
				order.setGivehour(givehour);
				order.setTeacherId(teacherId);
				order.setDepartmentofpediatricsId(departmentofpediatricsId);
				order.setFeecateId(feecateId);
				order.setDpMoney(discount);
				order.setServiceCharge(serviceCharge);
				order.setDiscount(dpMoney);
				order.setActivityId(activityId);
				order.setClassId(classId);
				order.setIntegral(integral);
				order.setGiftId(giftId);
				if (giftNumber == null) {
					order.setGiftNumber(0);
				} else {
					order.setGiftNumber(giftNumber);
				}
				order.setPaymentmethodId(paymentmethodId);
				if (orderService.addOrder(order) == 1) {
					if (studentService.updateStudentOrderHour(addhour + givehour, childrenesClassStudnet.getStudentId(),
							integral) == 1) {
						if (giftNumber != null) {
							if (giftService.updateGift(-giftNumber, giftId) == 1) {
								StudentTool studentTool = new StudentTool();
								studentTool.setStudentId(student.getStudentId());
								studentTool.setTeacherId(teachers);
								studentTool.setTeacherName(headmasters);
								studentTool.setClassId(classId);
								studentTool.setClassName(className);
								if(studentToolService.addStudentTool(studentTool) == 1) {
									map.put("add", "1");
								}else {
									map.put("add", "0");
								}
							} else {
								map.put("add", "0");
								return JSONArray.toJSONString(map);
							}
						} else {
								StudentTool studentTool = new StudentTool();
								studentTool.setStudentId(student.getStudentId());
								studentTool.setTeacherId(teachers);
								studentTool.setTeacherName(headmasters);
								studentTool.setClassId(classId);
								studentTool.setClassName(className);
								if(studentToolService.addStudentTool(studentTool) == 1) {
									map.put("add", "1");
								}else {
									map.put("add", "0");
								}
						}
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "0");
					return JSONArray.toJSONString(map);
				}
			} else {
				map.put("add", "0");
				return JSONArray.toJSONString(map);
			}
		} else {
			map.put("add", "0");
		}

		return JSONArray.toJSONString(map);
	}

	/**
	 * 注册少儿学生时间段
	 * 
	 * @param classId
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param firstdate
	 * @param lastdate
	 * @param personliable
	 * @param remarks3
	 * @param entertainTeacher
	 * @param consultationTeacher
	 * @param paymentmethodId
	 * @param giftId
	 * @param giftNumber
	 * @param integral
	 * @param hour
	 * @param date
	 * @param discount
	 * @return
	 */
	@RequestMapping("RegisterStudentsCharge.html")
	@ResponseBody
	public Object RegisterStudentsCharge(@RequestParam Integer classId, Student student, @RequestParam String feecateId,
			@RequestParam Double dpMoney, @RequestParam String firstdate, @RequestParam String lastdate,
			@RequestParam String personliable, @RequestParam String remarks3, @RequestParam Integer paymentmethodId,
			@RequestParam Integer giftId, @RequestParam Integer giftNumber, @RequestParam Double integral,
			@RequestParam Integer hour, @RequestParam String date, @RequestParam Double discount,
			@RequestParam String startTimes, @RequestParam String feecateMoney, @RequestParam Integer activityId,
			@RequestParam String schoolTime, @RequestParam Double serviceCharge, @RequestParam String entertainTeacher,
			@RequestParam String consultationTeacher, @RequestParam String headmasters,@RequestParam String className,@RequestParam Integer teacherId,@RequestParam Integer teacherIds) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		student.setEntertainTeacher(entertainTeacher);
		student.setConsultationTeacher(consultationTeacher);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
			childrenesClassStudnet.setSchoolTime(schoolTime);
			childrenesClassStudnet.setHeadmaster(headmasters);
			try {
				Date startTimes2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime() + startTimes);
				childrenesClassStudnet.setEnrollmentTime(startTimes2);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet) == 1) {
				Order order = new Order();
				try {
					Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
					Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
					order.setStartTime(childrenesClassStudnet.getEnrollmentTime());
					order.setFirstdate(firstdate1);
					order.setLastdate(lastdate1);
				} catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				order.setSchoolId((Integer) session.getAttribute("schoolId"));
				order.setStuId(childrenesClassStudnet.getStudentId());
				order.setPersonliable(personliable);
				order.setRemarks(remarks3);
				order.setGiftNumber(giftNumber);
				order.setFeecateId(feecateId);
				order.setDpMoney(dpMoney);
				order.setGiftId(giftId);
				order.setServiceCharge(serviceCharge);
				order.setClassId(classId);
				order.setActivityId(activityId);
				order.setRenew(0);
				order.setTeacherId(teacherId);
				order.setIntegral(integral);
				order.setFeecateMoney(feecateMoney);
				order.setDiscount(discount);
				School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
				if (OrderHour >= 10) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 100) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 1000) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
							+ school.getSchoolNumber());
				} else {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
							+ school.getSchoolNumber());
				}
				schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"),
						school.getSchoolNumber() + 1);
				order.setPaymentmethodId(paymentmethodId);
				order.setIdentification(0);
				if (orderService.addOrder(order) == 1) {
					if (studentService.updateStudentOrderHour(hour, childrenesClassStudnet.getStudentId(),
							integral) == 1) {
						if (giftNumber != 0) {
							if (giftService.updateGift(-giftNumber, giftId) == 1) {
								StudentTool studentTool = new StudentTool();
								studentTool.setStudentId(student.getStudentId());
								studentTool.setTeacherId(teacherIds);
								studentTool.setTeacherName(headmasters);
								studentTool.setClassId(classId);
								studentTool.setClassName(className);
								if(studentToolService.addStudentTool(studentTool) == 1) {
									map.put("add", "1");
								}else {
									map.put("add", "0");
								}
							} else {
								map.put("add", "0");
								return JSONArray.toJSONString(map);
							}
						} else {
								StudentTool studentTool = new StudentTool();
								studentTool.setStudentId(student.getStudentId());
								studentTool.setTeacherId(teacherIds);
								studentTool.setTeacherName(headmasters);
								studentTool.setClassId(classId);
								studentTool.setClassName(className);
								if(studentToolService.addStudentTool(studentTool) == 1) {
									map.put("add", "1");
								}else {
									map.put("add", "0");
								}
						}
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "0");
					return JSONArray.toJSONString(map);
				}
			}
		} else {
			map.put("add", "0");
		}

		return JSONArray.toJSONString(map);
	}

	/**
	 * 注册高中学生时间段
	 * 
	 * @param classId
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param firstdate
	 * @param lastdate
	 * @param personliable
	 * @param remarks3
	 * @param paymentmethodId
	 * @param giftId
	 * @param entertainTeacher
	 * @param consultationTeacher
	 * @param giftNumber
	 * @param integral
	 * @param hour
	 * @param date
	 * @param discount
	 * @return
	 */
	@RequestMapping("RegisterStudentsCharges.html")
	@ResponseBody
	public Object RegisterStudentsCharges(@RequestParam Integer classId, Student student,
			@RequestParam String feecateId, @RequestParam Double dpMoney, @RequestParam String firstdate,
			@RequestParam String lastdate, @RequestParam String personliable, @RequestParam String remarks3,
			@RequestParam Integer paymentmethodId, @RequestParam Integer hour, @RequestParam String startTimes,
			@RequestParam String date, @RequestParam Double discount, @RequestParam String feecateMoney,
			@RequestParam Double serviceCharge, @RequestParam String entertainTeacher,
			@RequestParam String consultationTeacher, @RequestParam String headmasters) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		student.setConsultationTeacher(consultationTeacher);
		student.setEntertainTeacher(entertainTeacher);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
			childrenesClassStudnet.setHeadmaster(headmasters);
			try {
				Date startTimes2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime() + startTimes);
				childrenesClassStudnet.setEnrollmentTime(startTimes2);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (childrenesClassStudnetService.insertChildrenesClassStudnets(childrenesClassStudnet) == 1) {
				map.put("add", "1");
				Order order = new Order();
				try {
					Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
					Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
					order.setStartTime(childrenesClassStudnet.getEnrollmentTime());
					order.setFirstdate(firstdate1);
					order.setLastdate(lastdate1);
				} catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				order.setSchoolId((Integer) session.getAttribute("schoolId"));
				order.setStuId(childrenesClassStudnet.getStudentId());
				order.setPersonliable(personliable);
				order.setRemarks(remarks3);
				order.setGiftNumber(0);
				order.setFeecateId(feecateId);
				order.setDpMoney(discount);
				order.setGiftId(0);
				order.setRenew(0);
				order.setServiceCharge(serviceCharge);
				order.setClassId(classId);
				order.setIntegral(0.0);
				order.setFeecateMoney(feecateMoney);
				order.setDiscount(dpMoney);
				School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
				if (OrderHour >= 10) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 100) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 1000) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
							+ school.getSchoolNumber());
				} else {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
							+ school.getSchoolNumber());
				}
				schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"),
						school.getSchoolNumber() + 1);
				order.setPaymentmethodId(paymentmethodId);
				order.setIdentification(0);
				if (orderService.addOrder(order) == 1) {
					if (studentService.updateStudentOrderHour(hour, childrenesClassStudnet.getStudentId(), 0.0) == 1) {
						map.put("add", "1");
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "0");
					return JSONArray.toJSONString(map);
				}
			} else {
				map.put("add", "0");
				return JSONArray.toJSONString(map);
			}

		} else {
			map.put("add", "0");
		}

		return JSONArray.toJSONString(map);
	}

	/**
	 * 注册学生艺考
	 * 
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param firstdate
	 * @param lastdate
	 * @param personliable
	 * @param remarks3
	 * @param paymentmethodId
	 * @param giftId
	 * @param entertainTeacher
	 * @param consultationTeacher
	 * @param giftNumber
	 * @param integral
	 * @param hour
	 * @param date
	 * @param discount
	 * @return
	 */
	@RequestMapping("RegisterStudentsYiKao.html")
	@ResponseBody
	public Object RegisterStudentsYiKao(Student student, @RequestParam String feecateId, @RequestParam Double dpMoney,
			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String personliable,
			@RequestParam String remarks3, @RequestParam Integer paymentmethodId, @RequestParam Integer giftId,
			@RequestParam Integer giftNumber, @RequestParam Double integral, @RequestParam Integer hour,
			@RequestParam String date, @RequestParam Double discount, @RequestParam String feecateMoney,
			@RequestParam String feecateMoneyYiKao, @RequestParam String startTimes, @RequestParam Integer activityId,
			@RequestParam Double serviceCharge, @RequestParam String professionalTeacher,
			@RequestParam String headmaster, @RequestParam String entertainTeacher,
			@RequestParam String consultationTeacher,@RequestParam Double deposit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStartTime(student.getStartTime() + startTimes);
		student.setStudentHour(0.0);
		student.setHeadmaster(headmaster);
		student.setEntertainTeacher(entertainTeacher);
		student.setConsultationTeacher(consultationTeacher);
		student.setProfessionalTeacher(professionalTeacher);
		if (studentService.addStudnetInfo(student) == 1) {
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			Reserveschool reserveschool = new Reserveschool();
			reserveschool.setSchoolId((Integer) session.getAttribute("schoolId"));
			reserveschool.setState(0);

			reserveschool.setStudentId(s.getStudentId());
			if (reserveschoolService.addReserve(reserveschool) == 1) {
				Order order = new Order();
				try {
					Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
					Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
					Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime());
					order.setStartTime(startTime);
					order.setFirstdate(firstdate1);
					order.setLastdate(lastdate1);
				} catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				order.setSchoolId((Integer) session.getAttribute("schoolId"));
				order.setStuId(s.getStudentId());
				order.setPersonliable(personliable);
				order.setRemarks(remarks3);
				order.setGiftNumber(giftNumber);
				order.setFeecateId(feecateId);
				order.setDpMoney(dpMoney);
				order.setGiftId(giftId);
				order.setClassId(0);
				order.setRenew(0);
				order.setServiceCharge(serviceCharge);
				order.setIntegral(integral);
				order.setDeposit(deposit);
				order.setActivityId(activityId);
				order.setFeecateMoney(feecateMoney);
				order.setFeecateMoneyYiKao(feecateMoneyYiKao);
				order.setDiscount(discount);
				School school = schoolService.selectSchoolById((Integer) session.getAttribute("schoolId"));
				if (OrderHour >= 10) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-00"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 100) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-0"
							+ school.getSchoolNumber());
				} else if (OrderHour >= 1000) {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-"
							+ school.getSchoolNumber());
				} else {
					order.setOrderNumber(school.getSchoolNameSx() + "(" + school.getSchoolName() + ")-" + date + "-000"
							+ school.getSchoolNumber());
				}
				schoolService.updateSchoolNumber((Integer) session.getAttribute("schoolId"),
						school.getSchoolNumber() + 1);
				order.setPaymentmethodId(paymentmethodId);
				order.setIdentification(0);
				if (orderService.addOrder(order) == 1) {
					if (studentService.updateStudentOrderHour(hour, s.getStudentId(), integral) == 1) {
						if (giftNumber != 0) {
							if (giftService.updateGift(-giftNumber, giftId) == 1) {
								map.put("add", "1");
							} else {
								map.put("add", "0");
								return JSONArray.toJSONString(map);
							}
						} else {
							map.put("add", "1");
						}
					} else {
						map.put("add", "0");
						return JSONArray.toJSONString(map);
					}
				} else {
					map.put("add", "0");
					return JSONArray.toJSONString(map);
				}
			} else {
				map.put("add", "0");
				return JSONArray.toJSONString(map);
			}

		} else {
			map.put("add", "0");
		}

		return JSONArray.toJSONString(map);
	}

	/**
	 * 课程提醒
	 * 
	 * @param time
	 * @param Choice
	 * @return
	 */
	@RequestMapping("selectHour.html")
	@ResponseBody
	public Object selectHour(@RequestParam String time, @RequestParam Integer Choice, @RequestParam String studentName,
			@RequestParam Integer number) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (number == 0) {
			number = null;
		}
		if (Choice == 1) {
			List<Order> order = orderService.selectStduentHour(Integer.parseInt(time),
					(Integer) session.getAttribute("schoolId"), studentName, number);
			System.out.println(order.size());
			for (int i = 0; i < order.size(); i++) {
				if (i != order.size() - 1) {
					if (order.get(i).getStuId() == order.get(i + 1).getStuId()) {
						order.get(i + 1).setDpMoney(order.get(i).getDpMoney() + order.get(i + 1).getDpMoney());
						order.get(i + 1).setAddhour(order.get(i).getAddhour() + order.get(i + 1).getAddhour());
						order.remove(i);
						i = i - 1;
					}
				}
			}
			map.put("order", order);

		} else if (Choice == 2) {
			List<Order> order = orderService.selectStduentDay(time, (Integer) session.getAttribute("schoolId"),
					studentName, number);
			for (int i = 0; i < order.size(); i++) {
				if (i != order.size() - 1) {
					if (order.get(i).getStuId() == order.get(i + 1).getStuId()) {
						if (order.get(i).getOrderId() > order.get(i + 1).getOrderId()) {
							order.remove(i + 1);
						} else if (order.get(i).getOrderId() < order.get(i + 1).getOrderId()) {
							order.remove(i);
						}
						i = i - 1;
					}
				}
			}
			map.put("order", order);
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 招生报表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("RecruitStudents.html")
	public String RecruitStudents(Model model) {
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<Class> classes = classService.selectMyClass((Integer) session.getAttribute("schoolId"));
		model.addAttribute("teacher", teacher);
		model.addAttribute("classes", classes);
		return "high/RecruitStudents";
	}

	/**
	 * 根据条件查找招生报表
	 * 
	 * @param studentName
	 * @param classes
	 * @param teacherId
	 * @param startTime
	 * @return
	 */
	@RequestMapping("RecruitStudents2.html")
	@ResponseBody
	public Object RecruitStudents2(@RequestParam String studentName, @RequestParam Integer classes,
			@RequestParam Integer teacherId, @RequestParam String startTime) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Order> order = orderService.RecruitStudentes(studentName, startTime, classes, teacherId,
				(Integer) session.getAttribute("schoolId"));
		map.put("order", order);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查看本校班级类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectClassTypes.html")
	public String selectClassTypes(Model model) {
		List<ClassType> classType = classTypeService.selectClassTypes((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classType", classType);
		model.addAttribute("schoolType", (Integer) session.getAttribute("schoolType"));
		return "high/ClassType";
	}

	/**
	 * 添加本校班级类型
	 * 
	 * @param classType
	 * @return
	 */
	@RequestMapping("addClassTypes.html")
	@ResponseBody
	public Object addClassTypes(ClassType classType) {
		HashMap<String, String> map = new HashMap<String, String>();
		classType.setSchoolId((Integer) session.getAttribute("schoolId"));
		if (classTypeService.addClassTypes(classType) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 修改本校班级类型
	 * 
	 * @param classType
	 * @return
	 */
	@RequestMapping("updateClassTypes.html")
	@ResponseBody
	public Object updateClassTypes(ClassType classType) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (classTypeService.updateClassTypes(classType) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除本校班级类型
	 * 
	 * @param classTypeId
	 * @return
	 */
	@RequestMapping("delClassTypes.html")
	@ResponseBody
	public Object delClassTypes(Integer classTypeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (classTypeService.delClassTypes(classTypeId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 查看本校上课时间
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectClassTime.html")
	public String selectClassTime(Model model) {
		List<ClassTime> classTime = classTimeService.selectClassTime((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classTime", classTime);
		return "high/ClassTime";
	}

	/**
	 * 添加本校上课时间
	 * 
	 * @param classTime
	 * @return
	 */
	@RequestMapping("addClassTime.html")
	@ResponseBody
	public Object addClassTime(ClassTime classTime) {
		HashMap<String, String> map = new HashMap<String, String>();
		classTime.setSchoolId((Integer) session.getAttribute("schoolId"));
		if (classTimeService.addClassTime(classTime) == 1) {
			map.put("add", "1");
		} else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 删除本校上课时间
	 * 
	 * @param classTimeId
	 * @return
	 */
	@RequestMapping("delClassTime.html")
	@ResponseBody
	public Object delClassTime(Integer classTimeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (classTimeService.delClassTime(classTimeId) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}


	/**
	 * 删除本校上课时间
	 * 
	 * @param classTimeId
	 * @return
	 */
	@RequestMapping("updateClassTime.html")
	@ResponseBody
	public Object updateClassTime(Integer classTimeId,String classTimeName) {
		HashMap<String, String> map = new HashMap<String, String>();
		ClassTime classTime = new ClassTime();
		classTime.setClassTimeId(classTimeId); 
		classTime.setClassTimeName(classTimeName);
		if (classTimeService.updateClassTime(classTime) == 1) {
			map.put("del", "1");
		} else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}
	/**
	 * 转到批量收费页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("BulkCharging.html")
	public String BulkCharging(Model model) {
		List<Student> student = studentService.selectAllStudent((Integer) session.getAttribute("schoolId"));
		List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 0);
		model.addAttribute("classes", classes);
		model.addAttribute("student", student);
		return "high/BulkCharging";
	}

	/**
	 * 根据班级、名字查找学生
	 * 
	 * @param classId
	 * @param StudentName
	 * @return
	 */
	@RequestMapping("selectBulkCharging.html")
	public String selectBulkCharging(Model model, @RequestParam Integer classId, @RequestParam String studentName) {
		List<Student> student = studentService.selectByClassIdStudent((Integer) session.getAttribute("schoolId"),
				classId, studentName);
		model.addAttribute("student", student);
		return "high/BulkCharging";
	}
}
