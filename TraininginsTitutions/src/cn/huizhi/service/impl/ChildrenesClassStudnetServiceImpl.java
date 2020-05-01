package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ChildrenesClassStudnetMapper;
import cn.huizhi.pojo.ChildrenesClassStudnet;
import cn.huizhi.service.ChildrenesClassStudnetService;

@Service
public class ChildrenesClassStudnetServiceImpl implements ChildrenesClassStudnetService {

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

	@Override
	public Integer updateChildrenesClassStudnet(ChildrenesClassStudnet cStudnet) {
		// TODO Auto-generated method stub
		return childrenesClassStudnetMapper.updateChildrenesClassStudnet(cStudnet);
	}

	@Override
	public int insertChildrenesClassStudnets(ChildrenesClassStudnet childrenesClassStudnet) {
		return childrenesClassStudnetMapper.insertChildrenesClassStudnets(childrenesClassStudnet);
	}

	@Override
	public Integer updateChildrenStudentState(ChildrenesClassStudnet childrenesClassStudnet) {
		// TODO Auto-generated method stub
		return childrenesClassStudnetMapper.updateChildrenStudentState(childrenesClassStudnet);
	}

	@Override
	public Integer updateChildrenStudentGradution(List list) {
		// TODO Auto-generated method stub
		return childrenesClassStudnetMapper.updateChildrenStudentGradution(list);
	}

	@Override
	public List<ChildrenesClassStudnet> findChildrenesClassStudnetByClassIdAndTime(String classId, String startTime,
			String endTime,String studentName,String teacherName,String schoolTime) {
		// TODO Auto-generated method stub
		return childrenesClassStudnetMapper.findChildrenesClassStudnetByClassIdAndTime(classId, startTime, endTime,studentName,teacherName,schoolTime);
	}

}
