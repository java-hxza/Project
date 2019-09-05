package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ChildrenesClassStudnetMapper;
import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.service.ChildrenesClassStudnetService;
@Service
public class ChildrenesClassStudnetServiceImpl implements ChildrenesClassStudnetService{
	
	@Resource
	ChildrenesClassStudnetMapper childrenesClassStudnetMapper;
	/**
	 * 新增少儿班级学生
	 */
	public int addChildrenesClassStudnet(ChildrenesClassStudnet childrenesClassStudnet) {
		return childrenesClassStudnetMapper.insertChildrenesClassStudnet(childrenesClassStudnet);
	}
	@Override
	public List<ChildrenesClassStudnet> findChildrenesClassStudnetByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return childrenesClassStudnetMapper.findChildrenesClassStudnetByClassId(classId);
	}

}
