package cn.huizhi.controller.highes;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.huizhi.pojo.Expenditureitems;
import cn.huizhi.pojo.FeeCategory;
import cn.huizhi.pojo.PaymentMethod;
import cn.huizhi.service.ExpenditureitemsService;
import cn.huizhi.service.FeeCategoryService;
import cn.huizhi.service.PaymentMethodService;

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
	
	/**
	 * 查询所有账户信息
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
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("delAccountinformation.html")
	@ResponseBody
	public Object DelAccountinformation(@RequestParam int paymentmethodId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(paymentMethodService.delPaymentMethod(paymentmethodId) == 1) {
			map.put("del", "1");
		}else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}
	
	/**
	 * 添加账户信息
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("addAccountinformation.html")
	@ResponseBody
	public Object AddAccountinformation(@RequestParam String paymentmethodName) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(paymentMethodService.addPaymentMethod(paymentmethodName) == 1) {
			map.put("add", "1");
		}else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}
	
	/**
	 * 查询所有收入项目
	 * @param model
	 * @return
	 */
	@RequestMapping("Incomeitems.html")
	public String Incomeitems(Model model,HttpSession session) {
		List<FeeCategory> list = feecategoryService.selectFeeCategory((Integer)session.getAttribute("feeCategory"));
		model.addAttribute("list", list);
		return "high/Incomeitems";
	}
	
	/**
	 * 删除收入项目
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("delIncomeitems.html")
	@ResponseBody
	public Object DelIncomeitems(@RequestParam int chargeTypeId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(feecategoryService.delFeeCategory(chargeTypeId)) {
			map.put("del", "1");
		}else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}
	
	/**
	 * 添加收入项目
	 * @param chargeTypeId
	 * @return
	 */
	@RequestMapping("addIncomeitems.html")
	@ResponseBody
	public Object AddIncomeitems(@RequestParam String chargeTypeName,@RequestParam String category,HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(feecategoryService.addFeeCategory(chargeTypeName, category, (Integer)session.getAttribute("feeCategory")) == 1) {
			map.put("add", "1");
		}else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}
	
	/**
	 * 查询所有支出项目
	 * @param model
	 * @return
	 */
	@RequestMapping("Expenditureitemses.html")
	public String Expenditureitemses(Model model,HttpSession session) {
		List<Expenditureitems> list = expenditureitemsService.selectExpenditureitems((Integer)session.getAttribute("feeCategory"));
		model.addAttribute("list", list);
		return "high/Expenditureitemses";
	}
	
	/**
	 * 删除支出项目
	 * @param expenditureitemsId
	 * @return
	 */
	@RequestMapping("delExpenditureitemses.html")
	@ResponseBody
	public Object DelExpenditureitemses(@RequestParam int expenditureitemsId) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(expenditureitemsService.delExpenditureitems(expenditureitemsId) == 1) {
			map.put("del", "1");
		}else {
			map.put("del", "0");
		}
		return JSONArray.toJSONString(map);
	}
	
	/**
	 * 添加支出项目
	 * @param expenditureitemsName
	 * @param category
	 * @return
	 */
	@RequestMapping("addExpenditureitemses.html")
	@ResponseBody
	public Object AddExpenditureitemses(@RequestParam String expenditureitemsName,@RequestParam String category,HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(expenditureitemsService.addExpenditureitems(expenditureitemsName, category, (Integer)session.getAttribute("feeCategory")) == 1) {
			map.put("add", "1");
		}else {
			map.put("add", "0");
		}
		return JSONArray.toJSONString(map);
	}
}
