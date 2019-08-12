package cn.huizhi.service;

import cn.huizhi.pojo.Children;
/**
 * 少儿学生信息
 * @author wye
 *
 */
public interface ChildrenService {
	/**
	 * 新增少儿学生信息
	 * @param children
	 * @return
	 */
	public int addChildren(Children children);
	
	/**
	 * 获取刚添加学生的信息
	 * @param children
	 * @return
	 */
	public Children findChildrenInfoByChildren(Children children);
}
