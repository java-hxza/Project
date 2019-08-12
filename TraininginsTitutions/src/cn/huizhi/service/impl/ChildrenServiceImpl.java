package cn.huizhi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ChildrenMapper;
import cn.huizhi.pojo.Children;
import cn.huizhi.service.ChildrenService;
/**
 * 少儿学生信息
 * @author wye
 *
 */
@Service
public class ChildrenServiceImpl implements ChildrenService{
	@Resource
	ChildrenMapper childrenMapper;
	/**
	 * 新增少儿学生信息
	 */
	public int addChildren(Children children) {
		return childrenMapper.insertChildren(children);
	}
	public Children findChildrenInfoByChildren(Children children) {
		return childrenMapper.selectChildrenInfoByChildren(children);
	}

}
