package cn.huizhi.controller.highes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import cn.huizhi.pojo.DepartMent;
import cn.huizhi.pojo.Student;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.Reserveschool;
import cn.huizhi.pojo.User;
import cn.huizhi.service.ActivityService;
import cn.huizhi.service.ChildrenesClassStudnetService;
import cn.huizhi.service.ClassService;
import cn.huizhi.service.DepartMentService;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.GiftService;
import cn.huizhi.service.StudentService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
import cn.huizhi.service.ReserveschoolService;
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
	DepartMentService departMentService;

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
		List<Class> classes = classService.selectClass((Integer) session.getAttribute("schoolId"), 0);
		if (classes.size() > 0) {
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet",
					classes.get(0).getClassId());
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
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet", classId);
			map.put("children", children);
		} else if (schoolType == 2) {
			List<Student> children = studentService.selectStudentClass("highesclassstudnet", classId);
			map.put("children", children);
		} else if (schoolType == 3) {
			List<Student> children = studentService.selectStudentClass("artclassstudnet", classId);
			map.put("children", children);
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
			@RequestParam Double discount, @RequestParam String startTimes) {
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
		order.setOrderNumber("KS" + date + stuId + new Random().nextInt(100));
		order.setGivehour(givehour);
		order.setDepartmentofpediatricsId(departmentofpediatricsId);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setActivityId(activityId);
		order.setDiscount(discount);
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
		List<Class> classes = classService.selectClass2((Integer) session.getAttribute("schoolId"), 1);
		model.addAttribute("classes", classes);
		if (schoolType == 1) {
			List<Student> children = studentService.selectStudentClass("childrenesclassstudnet",
					classes.get(0).getClassId());
			model.addAttribute("children", children);

		} else if (schoolType == 2) {
			List<Student> children = studentService.selectStudentClass("highesclassstudnet",
					classes.get(0).getClassId());
			model.addAttribute("children", children);
		} else if (schoolType == 3) {
			List<Student> children = studentService.selectStudentClass("artclassstudnet", classes.get(0).getClassId());
			model.addAttribute("children", children);
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
			@RequestParam String startTimes, @RequestParam String feecateMoney) {
		HashMap<String, String> map = new HashMap<String, String>();
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
		order.setFeecateMoney(feecateMoney);
		order.setIntegral(integral);
		order.setActivityId(activityId);
		order.setDiscount(discount);
		order.setOrderNumber("SJ" + date + stuId + new Random().nextInt(100));
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
		if (schoolType == 1) {
			List<Student> high = studentService.selectStudentClass("childrenesclassstudnet",
					classes.get(0).getClassId());
			model.addAttribute("high", high);
		} else if (schoolType == 2) {
			List<Student> high = studentService.selectStudentClass("highesclassstudnet", classes.get(0).getClassId());
			model.addAttribute("high", high);
		} else if (schoolType == 3) {
			List<Student> high = studentService.selectStudentClass("artclassstudnet", classes.get(0).getClassId());
			model.addAttribute("high", high);
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
			@RequestParam Integer classId, @RequestParam String startTimes) {
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
		order.setSchoolId((Integer) session.getAttribute("schoolId"));
		order.setClassId(classId);
		order.setGiftId(0);
		order.setGiftNumber(0);
		order.setOrderNumber("QT" + date + stuId + new Random().nextInt(100));
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

//	/**
//	 * 修改课时订单
//	 * 
//	 * @return
//	 */
//	@RequestMapping("updateChargeHour.html")
//	@ResponseBody
//	public Object updateChargeHour(@RequestParam Integer stuId, @RequestParam String feecateId,
//			@RequestParam Double dpMoney, @RequestParam Integer addhour, @RequestParam Integer givehour,
//			@RequestParam String remarks, @RequestParam Integer paymentmethodId, @RequestParam Integer orderId,
//			@RequestParam Integer hour, @RequestParam Integer giftId, @RequestParam Integer giftNumber,
//			@RequestParam Integer giftId2, @RequestParam Integer giftNumber2, @RequestParam Double integral,
//			@RequestParam Integer teacherId, @RequestParam Double integrals) {
//		Order order = new Order();
//		HashMap<String, String> map = new HashMap<String, String>();
//		order.setStuId(stuId);
//		order.setRemarks(remarks);
//		order.setAddhour(addhour);
//		order.setGivehour(givehour);
//		order.setOrderId(orderId);
//		order.setFeecateId(feecateId);
//		order.setDpMoney(dpMoney);
//		order.setTeacherId(teacherId);
//		order.setIntegral(integral);
//		if (giftId != -2 && giftId != -1) {
//			order.setGiftId(giftId);
//		} else if (giftId == -2 && giftNumber == 0) {
//			order.setGiftId(giftNumber);
//		} else {
//			order.setGiftId(giftId2);
//		}
//		order.setGiftNumber(giftNumber);
//		order.setPaymentmethodId(paymentmethodId);
//		if (orderService.updateOrderAll(order) == 1) {
//			if (dpMoney != 0) {
//				if (studentService.updateStudentOrderHour(hour, stuId, integrals) == 1) {
//					map.put("update", "1");
//				} else {
//					map.put("update", "0");
//					return JSONArray.toJSONString(map);
//				}
//			} else {
//				if (giftId != -1) {
//					if (giftNumber2 != 0) {
//						if (giftService.updateGift(giftNumber2, giftId2) == 1) {
//							map.put("update", "1");
//						} else {
//							map.put("update", "0");
//							return JSONArray.toJSONString(map);
//						}
//					}
//					if (giftId != -2) {
//						if (giftService.updateGift(-giftNumber, giftId) == 1) {
//							map.put("update", "1");
//						} else {
//							map.put("update", "0");
//							return JSONArray.toJSONString(map);
//						}
//					} else {
//						map.put("update", "1");
//					}
//				} else {
//					map.put("update", "1");
//				}
//				map.put("update", "1");
//			}
//		} else {
//			map.put("update", "0");
//		}
//		return JSONArray.toJSONString(map);
//	}

//	/**
//	 * 修改时间段订单
//	 * 
//	 * @return
//	 */
//	@RequestMapping("updateCharge.html")
//	@ResponseBody
//	public Object updateCharge(@RequestParam Integer stuId, @RequestParam Double dpMoney,
//			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String remarks,
//			@RequestParam Integer paymentmethodId, @RequestParam Integer orderId, @RequestParam Integer time,
//			@RequestParam Integer giftNumber, @RequestParam Integer giftId, @RequestParam Integer giftNumber2,
//			@RequestParam Integer giftId2, @RequestParam Double integral, @RequestParam Integer teacherId,
//			@RequestParam Double integrals, @RequestParam String personliable, @RequestParam Double discount) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		Order order = new Order();
//		order.setStuId(stuId);
//		order.setRemarks(remarks);
//		try {
//			Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
//			Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
//			order.setFirstdate(firstdate1);
//			order.setLastdate(lastdate1);
//		} catch (ParseException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		order.setOrderId(orderId);
//		order.setDpMoney(dpMoney);
//		order.setTeacherId(teacherId);
//		order.setIntegral(integral);
//		if (giftId != -2 && giftId != -1) {
//			order.setGiftId(giftId);
//		} else if (giftId == -2 && giftNumber == 0) {
//			order.setGiftId(giftNumber);
//		} else {
//			order.setGiftId(giftId2);
//		}
//		order.setGiftNumber(giftNumber);
//		order.setPersonliable(personliable);
//		order.setDiscount(discount);
//		order.setPaymentmethodId(paymentmethodId);
//		if (orderService.updateOrderAll(order) == 1) {
//			if (dpMoney != 0) {
//				if (studentService.updateStudentOrderHour(time, stuId, integrals) == 1) {
//					map.put("update", "1");
//				} else {
//					map.put("update", "0");
//					return JSONArray.toJSONString(map);
//				}
//			}
//			if (giftId != -1) {
//				if (giftNumber2 != 0) {
//					if (giftService.updateGift(giftNumber2, giftId2) == 1) {
//						map.put("update", "1");
//					} else {
//						map.put("update", "0");
//						return JSONArray.toJSONString(map);
//					}
//				}
//				if (giftId != -2) {
//					if (giftService.updateGift(-giftNumber, giftId) == 1) {
//						map.put("update", "1");
//					} else {
//						map.put("update", "0");
//						return JSONArray.toJSONString(map);
//					}
//				} else {
//					map.put("update", "1");
//				}
//			} else {
//				map.put("update", "1");
//			}
//			map.put("update", "1");
//		} else {
//			map.put("update", "0");
//		}
//		return JSONArray.toJSONString(map);
//	}

//	/**
//	 * 修改其他订单
//	 * 
//	 * @return
//	 */
//	@RequestMapping("updateChargeOther.html")
//	@ResponseBody
//	public Object updateChargeOther(@RequestParam Integer stuId, @RequestParam String startTime,
//			@RequestParam String feecateId, @RequestParam Double dpMoney, @RequestParam String personliable,
//			@RequestParam String remarks, @RequestParam Integer paymentmethodId, @RequestParam Integer orderId) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		Order order = new Order();
//		try {
//			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
//			order.setStartTime(startTime1);
//		} catch (ParseException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		order.setRemarks(remarks);
//		order.setPaymentmethodId(paymentmethodId);
//		order.setFeecateId(feecateId);
//		order.setPersonliable(personliable);
//		order.setDpMoney(dpMoney);
//		order.setOrderId(orderId);
//		order.setStuId(stuId);
//		if (orderService.updateOrderAll(order) == 1) {
//			map.put("update", "1");
//		} else {
//			map.put("update", "0");
//		}
//		return JSONArray.toJSONString(map);
//	}

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
		order.setOrderNumber("ZC" + date + stuId + new Random().nextInt(100));
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

//	/**
//	 * 修改支出订单
//	 * 
//	 * @param schoolId
//	 * @param stuId
//	 * @param startTime
//	 * @param feecategoryMoney
//	 * @param expenditureitemsId
//	 * @param paymentmethodId
//	 * @param personliable
//	 * @param remarks
//	 * @return
//	 */
//	@RequestMapping("UpdateOrderExpenditure.html")
//	@ResponseBody
//	public Object UpdateOrderExpenditure(@RequestParam Integer stuId, @RequestParam String startTime,
//			@RequestParam Double feecategoryMoney, @RequestParam Integer expenditureitemsId,
//			@RequestParam Integer paymentmethodId, @RequestParam String personliable, @RequestParam String remarks) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		Order order = new Order();
//		order.setRemarks(remarks);
//		order.setPersonliable(personliable);
//		order.setPaymentmethodId(paymentmethodId);
//		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
//		order.setStuId(stuId);
//		try {
//			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
//			order.setStartTime(startTime1);
//		} catch (ParseException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		order.setExpenditureitemsId(expenditureitemsId);
//		order.setFeecategoryMoney(feecategoryMoney);
//		if (orderService.updateOrderAll(order) == 1) {
//			map.put("update", "1");
//		} else {
//			map.put("update", "0");
//		}
//		return JSONArray.toJSONString(map);
//	}

	/**
	 * 查询收费课时
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderHour.html")
	public String selectOrderHour(Model model) {
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<Order> order = orderService.selectOrderHour((Integer) session.getAttribute("schoolId"));
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("order", order);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		model.addAttribute("gift", gift);
		return "high/ChargeHours";
	}

	/**
	 * 查询收费时间段
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderPeriod.html")
	public String selectOrderPeriod(Model model) {
		if ((Integer) session.getAttribute("schoolType") == 3) {
			List<Order> order = orderService.selectOrderPeriods((Integer) session.getAttribute("schoolId"));
			model.addAttribute("order", order);
		} else {
			List<Order> order = orderService.selectOrderPeriod((Integer) session.getAttribute("schoolId"));
			model.addAttribute("order", order);
		}

		List<Gift> gift = giftService.selectGift((Integer) session.getAttribute("schoolId"));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Teacher> teacher = teacherService.selectTeacherZS((Integer) session.getAttribute("schoolId"));
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		model.addAttribute("gift", gift);
		return "high/Charge";
	}

	/**
	 * 查询收费其他
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderOthers.html")
	public String selectOrderOthers(Model model) {
		List<FeeCategory> feeCategory = feecategoryService
				.selectFeeCategory((Integer) session.getAttribute("schoolId"));
		List<Order> order = orderService.selectOrderOther((Integer) session.getAttribute("schoolId"));
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("order", order);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		return "high/ChargeOthers";
	}

	/**
	 * 查询费用支出
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("selectOrderExpenditure.html")
	public String selectOrderExpenditure(Model model) {
		Integer schoolType = (Integer) session.getAttribute("schoolType");
		List<Class> classes = classService.selectClassAll((Integer) session.getAttribute("schoolId"));
		model.addAttribute("classes", classes);
		if (classes.size() > 0) {
			if (schoolType == 1) {
				List<Student> student = studentService.selectStudentClass("childrenesclassstudnet",
						classes.get(0).getClassId());
				model.addAttribute("student", student);
			} else if (schoolType == 2) {
				List<Student> student = studentService.selectStudentClass("highesclassstudnet",
						classes.get(0).getClassId());
				model.addAttribute("student", student);
			} else if (schoolType == 3) {
				List<Student> student = studentService.selectStudentClass("artclassstudnet",
						classes.get(0).getClassId());
				model.addAttribute("student", student);
			}
		}
		Integer schoolId = (Integer) session.getAttribute("schoolId");
		List<Order> order = orderService.selectOrderExpenditure(schoolId);
		List<Expenditureitems> expenditureitems = expenditureitemsService.selectExpenditureitems(schoolId.toString());
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<DepartmentOfPediatrics> departmentOfPediatrics = departmentOfPediatricsService
				.findDepartmentOfPediatrics((Integer) session.getAttribute("schoolId"));
		model.addAttribute("departmentOfPediatrics", departmentOfPediatrics);
		model.addAttribute("expenditureitems", expenditureitems);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("order", order);
		model.addAttribute("state", (Integer) session.getAttribute("state"));
		return "high/Expenditure";
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
		List<Activity> activity = activityService.selectActivitySchool((Integer) session.getAttribute("schoolId"));
		model.addAttribute("activity", activity);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		model.addAttribute("teacher", teacher);
		model.addAttribute("gift", gift);
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
	public Object RegisterClassStudent(@RequestParam Integer classType, @RequestParam Integer classTypeId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Class> classes = classService.selectVIPClass(classTypeId, classType,
				(Integer) session.getAttribute("schoolId"));
		map.put("classes", classes);
		return JSONArray.toJSONString(map);
	}

	/**
	 * 注册学生课时
	 * 
	 * @param student
	 * @param classes
	 * @param headmaster
	 * @return
	 */
	@RequestMapping("RegisterStudentsHour.html")
	@ResponseBody
	public Object RegisterStudentsHour(@RequestParam Integer classId, @RequestParam String headmaster, Student student,
			@RequestParam String feecateId, @RequestParam Double dpMoney,
			@RequestParam Integer departmentofpediatricsId, @RequestParam Integer addhour,
			@RequestParam Integer givehour, @RequestParam String remarks2, @RequestParam Integer paymentmethodId,
			@RequestParam String date, @RequestParam Double integral, @RequestParam Integer giftId,
			@RequestParam Integer giftNumber, @RequestParam Integer teacherId, @RequestParam Double discount,
			@RequestParam Integer activityId) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
			childrenesClassStudnet.setHeadmaster(headmaster);
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
			try {
				Date startTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime());
				childrenesClassStudnet.setEnrollmentTime(startTimes);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet) == 1) {
				map.put("add", "1");
				Order order = new Order();
				order.setStuId(childrenesClassStudnet.getStudentId());
				order.setSchoolId((Integer) session.getAttribute("schoolId"));
				order.setRemarks(remarks2);
				order.setStartTime(childrenesClassStudnet.getEnrollmentTime());
				order.setIdentification(0);
				order.setAddhour(addhour);
				order.setOrderNumber("KS" + date + childrenesClassStudnet.getStudentId() + new Random().nextInt(100));
				order.setGivehour(givehour);
				order.setTeacherId(teacherId);
				order.setDepartmentofpediatricsId(departmentofpediatricsId);
				order.setFeecateId(feecateId);
				order.setDpMoney(discount);
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
	 * 注册少儿学生时间段
	 * 
	 * @param classId
	 * @param headmaster
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param firstdate
	 * @param lastdate
	 * @param personliable
	 * @param remarks3
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
	public Object RegisterStudentsCharge(@RequestParam Integer classId, @RequestParam String headmaster,
			Student student, @RequestParam String feecateId, @RequestParam Double dpMoney,
			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String personliable,
			@RequestParam String remarks3, @RequestParam Integer paymentmethodId, @RequestParam Integer giftId,
			@RequestParam Integer giftNumber, @RequestParam Double integral, @RequestParam Integer hour,
			@RequestParam String date, @RequestParam Double discount, @RequestParam String startTimes,
			@RequestParam String feecateMoney, @RequestParam Integer activityId) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
			childrenesClassStudnet.setHeadmaster(headmaster);
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
			try {
				Date startTimes2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(student.getStartTime() + startTimes);
				childrenesClassStudnet.setEnrollmentTime(startTimes2);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (childrenesClassStudnetService.addChildrenesClassStudnet(childrenesClassStudnet) == 1) {
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
				order.setGiftNumber(giftNumber);
				order.setFeecateId(feecateId);
				order.setDpMoney(dpMoney);
				order.setGiftId(giftId);
				order.setClassId(classId);
				order.setActivityId(activityId);
				order.setIntegral(integral);
				order.setFeecateMoney(feecateMoney);
				order.setDiscount(discount);
				order.setOrderNumber("SJ" + date + childrenesClassStudnet.getStudentId() + new Random().nextInt(100));
				order.setPaymentmethodId(paymentmethodId);
				order.setIdentification(0);
				if (orderService.addOrder(order) == 1) {
					if (studentService.updateStudentOrderHour(hour, childrenesClassStudnet.getStudentId(),
							integral) == 1) {
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
	 * @param headmaster
	 * @param student
	 * @param feecateId
	 * @param dpMoney
	 * @param firstdate
	 * @param lastdate
	 * @param personliable
	 * @param remarks3
	 * @param paymentmethodId
	 * @param giftId
	 * @param giftNumber
	 * @param integral
	 * @param hour
	 * @param date
	 * @param discount
	 * @return
	 */
	@RequestMapping("RegisterStudentsCharges.html")
	@ResponseBody
	public Object RegisterStudentsCharges(@RequestParam Integer classId, @RequestParam String headmaster,
			Student student, @RequestParam String feecateId, @RequestParam Double dpMoney,
			@RequestParam String firstdate, @RequestParam String lastdate, @RequestParam String personliable,
			@RequestParam String remarks3, @RequestParam Integer paymentmethodId, @RequestParam Integer hour,
			@RequestParam String startTimes, @RequestParam String date, @RequestParam Double discount,
			@RequestParam String feecateMoney) {
		ChildrenesClassStudnet childrenesClassStudnet = new ChildrenesClassStudnet();
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStudentHour(0.0);
		if (studentService.addStudnetInfo(student) == 1) {
			childrenesClassStudnet.setState("1");
			childrenesClassStudnet.setStudentName(student.getStudentName());
			childrenesClassStudnet.setHeadmaster(headmaster);
			Student s = studentService.selectStudentId(student.getStudentName(), student.getStudentBirth(),
					student.getStudentSex());
			childrenesClassStudnet.setStudentId(s.getStudentId());
			childrenesClassStudnet.setClassId(classId);
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
				order.setClassId(classId);
				order.setIntegral(0.0);
				order.setFeecateMoney(feecateMoney);
				order.setDiscount(dpMoney);
				order.setOrderNumber("SJ" + date + childrenesClassStudnet.getStudentId() + new Random().nextInt(100));
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
			@RequestParam String feecateMoneyYiKao, @RequestParam String startTimes, @RequestParam Integer activityId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.setIntegral(0.0);
		student.setFeeCategory(1);
		student.setUsedIntegral(0.0);
		student.setStartTime(student.getStartTime() + startTimes);
		student.setStudentHour(0.0);
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
				order.setIntegral(integral);
				order.setActivityId(activityId);
				order.setFeecateMoney(feecateMoney);
				order.setFeecateMoneyYiKao(feecateMoneyYiKao);
				order.setDiscount(discount);
				order.setOrderNumber("SJ" + date + s.getStudentId() + new Random().nextInt(100));
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
	public Object selectHour(@RequestParam Integer time, @RequestParam Integer Choice, @RequestParam String studentName,
			@RequestParam Integer number) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (number == 0) {
			number = null;
		}
		if (Choice == 1) {
			List<Order> order = orderService.selectStduentHour(time, (Integer) session.getAttribute("schoolId"),
					studentName, number);
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
}
