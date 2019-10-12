package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.HighesClassStudnetMapper;
import cn.huizhi.pojo.HighesClassStudnet;
import cn.huizhi.service.HighesClassStudnetService;
@Service
public class HighesClassStudnetServiceImpl implements HighesClassStudnetService{
	
	@Resource
	HighesClassStudnetMapper highesClassStudnetMapper;
	
	@Override
	public List<HighesClassStudnet> findHighesClassStudnetListByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return highesClassStudnetMapper.findHighesClassStudnetListByClassId(classId);
	}

	@Override
	public Integer updateHighStudentState(HighesClassStudnet cStudnet) {
		// TODO Auto-generated method stub
		return highesClassStudnetMapper.updateHighStudentState(cStudnet);
	}

	@Override
	public Integer updateHighStudentClass(List<HighesClassStudnet> cStudnet) {
		// TODO Auto-generated method stub
		return highesClassStudnetMapper.updateHighStudentClass(cStudnet);
	}

	@Override
	public Integer updateHighStudentGradution(List list) {
		// TODO Auto-generated method stub
		return highesClassStudnetMapper.updateHighStudentGradution(list);
	}

}
