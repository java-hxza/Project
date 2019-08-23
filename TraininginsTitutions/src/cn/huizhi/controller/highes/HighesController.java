package cn.huizhi.controller.highes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import cn.huizhi.pojo.DepartmentOfPediatrics;
import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.Student;
import cn.huizhi.pojo.Order;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.pojo.User;
import cn.huizhi.service.DepartmentOfPediatricsService;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.StudentService;
import cn.huizhi.service.OrderService;
import cn.huizhi.service.PaymentMethodService;
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

	/**
	 * 查询所有账户信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("Accountinformation.html")
	public String Accountinformation(Model model) {
		List<PaymentMethod> list = paymentMethodService.selectPaymentMethod();
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
		List<FeeCategory> list = feecategoryService.selectFeeCategory();
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
	public Object AddIncomeitems(@RequestParam String chargeTypeName, @RequestParam String category) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (feecategoryService.addFeeCategory(chargeTypeName, category) == 1) {
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
		User user = (User) session.getAttribute("user");
		List<Expenditureitems> list = expenditureitemsService.selectExpenditureitems(user.getSchoolId());
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
		User user = (User) session.getAttribute("user");
		if (expenditureitemsService.addExpenditureitems(expenditureitemsName, category, user.getSchoolId()) == 1) {
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
		User u = (User) session.getAttribute("user");
		List<Teacher> teacher = teacherService.selectTeacher(Integer.parseInt(u.getSchoolId()));
		List<TeacherType> teacherType = teacherTypeService.selectTeacherType();
		model.addAttribute("teacher", teacher);
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
		User user = (User) session.getAttribute("user");
		HashMap<String, String> map = new HashMap<String, String>();
		if (teacherService.delTeacher(teacherId) == 1) {
			if (teacherDictionService.delTeacherDiction(Integer.parseInt(user.getSchoolId()), teacherId) == 1) {
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
<<<<<<< HEAD
	 */
	@RequestMapping("updateTeacher.html")
	@ResponseBody
	public Object updateTeacher(@RequestParam String teacherName, @RequestParam String telephone,
			@RequestParam String remarks, @RequestParam String loginPassword, @RequestParam Integer teacherTypeId,
			@RequestParam Integer teacherId) {
		Teacher teacher = new Teacher();
		teacher.setLoginPassword(loginPassword);
		teacher.setTeacherName(teacherName);
		teacher.setTeacherTypeId(teacherTypeId);
		teacher.setRemarks(remarks);
		teacher.setTelephone(telephone);
		teacher.setFeeCategory(2);
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
	public Object addTeacher(@RequestParam String teacherName, @RequestParam String telephone,
			@RequestParam String remarks, @RequestParam Integer teacherTypeId, @RequestParam String loginPassword) {
		Teacher teacher = new Teacher();
		User user = (User) session.getAttribute("user");
		teacher.setFeeCategory(2);
		teacher.setTeacherName(teacherName);
		teacher.setLoginPassword(loginPassword);
		teacher.setRemarks(remarks);
		teacher.setTelephone(telephone);
		teacher.setTeacherTypeId(teacherTypeId);
		HashMap<String, String> map = new HashMap<String, String>();
		if (teacherService.addTeacher(teacher) == 1) {
			Teacher teachers = teacherService.selectTeachers(teacher);
			if (teacherDictionService.addTeacherDiction(Integer.parseInt(user.getSchoolId()),
					teachers.getTeacherId()) == 1) {
				map.put("add", "1");
			} else {
				map.put("add", "0");
			}
		} else {
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
		User user = (User) session.getAttribute("user");
		List<Student> children = studentService.selectChildren(Integer.parseInt(user.getSchoolId()));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService.selectFeeCategory();
		List<DepartmentOfPediatrics> departmentOfPediatric = departmentOfPediatricsService.findDepartmentOfPediatrics();
		model.addAttribute("school", children.get(0).getSchool());
		model.addAttribute("children", children);
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("departmentOfPediatric", departmentOfPediatric);
		model.addAttribute("feeCategory", feeCategory);
		return "high/ChargeHours";
	}

	/**
	 * 添加收费按课时
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addChargeHours.html")
	@ResponseBody
	public Object AddChargeHours(@RequestParam Integer stuId, @RequestParam Integer feecateId,
			@RequestParam double dpMoney, @RequestParam Date startTime, @RequestParam Integer departmentofpediatricsId,
			@RequestParam double addhour, @RequestParam double givehour, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setStuId(stuId);
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setRemarks(remarks);
		order.setStartTime(startTime);
		order.setIdentification(0);
		order.setAddhour(addhour);
		order.setOrderNumber("JF" + stuId);
		order.setGivehour(givehour);
		order.setDepartmentofpediatricsId(departmentofpediatricsId);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.addOrder(order) == 1) {
			map.put("add", "1");
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
		User user = (User) session.getAttribute("user");
		List<Student> high = studentService.selectHigh(Integer.parseInt(user.getSchoolId()));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService.selectFeeCategory();
		model.addAttribute("high", high);
		model.addAttribute("school", high.get(0).getSchool());
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		return "high/Charge";
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
			@RequestParam Integer feecateId, @RequestParam double dpMoney, @RequestParam String firstdate,
			@RequestParam String lastdate, @RequestParam String personliable, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		try {
			Date startTime1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
			Date firstdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(firstdate);
			Date lastdate1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastdate);
			order.setStartTime(startTime1);
			order.setFirstdate(firstdate1);
			order.setLastdate(lastdate1);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStuId(stuId);
		order.setPersonliable(personliable);
		order.setRemarks(remarks);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setPaymentmethodId(paymentmethodId);
		order.setIdentification(0);
		if (orderService.addOrder(order) == 1) {
			map.put("add", "1");
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
		User user = (User) session.getAttribute("user");
		List<Student> high = studentService.selectYiKao(Integer.parseInt(user.getSchoolId()));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<FeeCategory> feeCategory = feecategoryService.selectFeeCategory();
		model.addAttribute("high", high);
		model.addAttribute("school", high.get(0).getSchool());
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("feeCategory", feeCategory);
		return "high/ChargeOthers";
	}

	/**
	 * 添加收费其他
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addChargeOthers.html")
	@ResponseBody
	public Object AddChargeOthers(@RequestParam Integer stuId, @RequestParam Date startTime,
			@RequestParam Integer feecateId, @RequestParam double dpMoney, @RequestParam String personliable,
			@RequestParam String remarks, @RequestParam Integer paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setIdentification(0);
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStartTime(startTime);
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setPersonliable(personliable);
		order.setDpMoney(dpMoney);
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
	public Object delCharge(@RequestParam Integer orderId) {
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
	public Object updateChargeHour(@RequestParam Integer stuId, @RequestParam Integer feecateId,
			@RequestParam double dpMoney, @RequestParam Date startTime, @RequestParam Integer departmentofpediatricsId,
			@RequestParam double addhour, @RequestParam double givehour, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId) {
		Order order = new Order();
		User user = (User) session.getAttribute("user");
		HashMap<String, String> map = new HashMap<String, String>();
		order.setStuId(stuId);
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setRemarks(remarks);
		order.setStartTime(startTime);
		order.setAddhour(addhour);
		order.setGivehour(givehour);
		order.setDepartmentofpediatricsId(departmentofpediatricsId);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
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
	public Object updateCharge(@RequestParam Integer stuId, @RequestParam Date startTime,
			@RequestParam Integer feecateId, @RequestParam double dpMoney, @RequestParam Date firstdate,
			@RequestParam Date lastdate, @RequestParam String personliable, @RequestParam String remarks,
			@RequestParam Integer paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStuId(stuId);
		order.setStartTime(startTime);
		order.setPersonliable(personliable);
		order.setFirstdate(firstdate);
		order.setLastdate(lastdate);
		order.setRemarks(remarks);
		order.setFeecateId(feecateId);
		order.setDpMoney(dpMoney);
		order.setPaymentmethodId(paymentmethodId);
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
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
	public Object updateChargeOther(@RequestParam Integer stuId, @RequestParam Date startTime,
			@RequestParam Integer feecateId, @RequestParam double dpMoney, @RequestParam String personliable,
			@RequestParam String remarks, @RequestParam Integer paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStartTime(startTime);
		order.setRemarks(remarks);
		order.setPaymentmethodId(paymentmethodId);
		order.setFeecateId(feecateId);
		order.setPersonliable(personliable);
		order.setDpMoney(dpMoney);
		order.setStuId(stuId);
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}

	/**
	 * 费用支出
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("OrderExpenditure.html")
	public String OrderExpenditure(Model model) {
		User user = (User) session.getAttribute("user");
		List<Student> high = studentService.selectHigh(Integer.parseInt(user.getSchoolId()));
		List<PaymentMethod> paymentMethod = paymentMethodService.selectPaymentMethod();
		List<Expenditureitems> expenditureitems = expenditureitemsService.selectExpenditureitems(user.getSchoolId());
		model.addAttribute("high", high);
		model.addAttribute("school", high.get(0).getSchool());
		model.addAttribute("paymentMethod", paymentMethod);
		model.addAttribute("expenditureitems", expenditureitems);
		return "high/Expenditure";
	}

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
	public Object AddOrderExpenditure(@RequestParam Integer stuId, @RequestParam Date startTime,
			@RequestParam double feecategoryMoney, @RequestParam Integer expenditureitemsId,
			@RequestParam Integer paymentmethodId, @RequestParam String personliable, @RequestParam String remarks) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setIdentification(1);
		order.setRemarks(remarks);
		order.setPersonliable(personliable);
		order.setPaymentmethodId(paymentmethodId);
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStuId(stuId);
		order.setStartTime(startTime);
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
	public Object UpdateOrderExpenditure(@RequestParam Integer stuId, @RequestParam Date startTime,
			@RequestParam double feecategoryMoney, @RequestParam Integer expenditureitemsId,
			@RequestParam Integer paymentmethodId, @RequestParam String personliable, @RequestParam String remarks) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		order.setRemarks(remarks);
		order.setPersonliable(personliable);
		order.setPaymentmethodId(paymentmethodId);
		order.setSchoolId(Integer.parseInt(user.getSchoolId()));
		order.setStuId(stuId);
		order.setStartTime(startTime);
		order.setExpenditureitemsId(expenditureitemsId);
		order.setFeecategoryMoney(feecategoryMoney);
		if (orderService.updateOrderAll(order) == 1) {
			map.put("update", "1");
		} else {
			map.put("update", "0");
		}
		return JSONArray.toJSONString(map);
	}
}
