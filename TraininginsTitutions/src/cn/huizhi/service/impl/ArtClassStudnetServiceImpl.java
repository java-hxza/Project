package cn.huizhi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ArtClassStudnetMapper;
import cn.huizhi.pojo.ArtClassStudnet;
import cn.huizhi.service.ArtClassStudnetService;

@Service
public class ArtClassStudnetServiceImpl implements ArtClassStudnetService {

	@Resource
	ArtClassStudnetMapper artClassStudnetMapper;
	
	@Override
	public Integer insertArtClassStudnetList(List<ArtClassStudnet> list) {
		// TODO Auto-generated method stub
		return artClassStudnetMapper.insertArtClassStudnetList(list);
	}

	@Override
	public Integer updateArtClassStudentByClass(ArtClassStudnet art) {
		// TODO Auto-generated method stub
		return artClassStudnetMapper.updateArtClassStudentByClass(art);
	}

	@Override
	public Integer updateArtStudentState(ArtClassStudnet art) {
		// TODO Auto-generated method stub
		return artClassStudnetMapper.updateArtStudentState(art);
	}

	@Override
	public List<ArtClassStudnet> findArtClassStudnetListByClassId(Integer classId) {
		// TODO Auto-generated method stub
		return artClassStudnetMapper.findArtClassStudnetListByClassId(classId);
	}

	@Override
	public Integer updateArtStudentGradution(List list) {
		// TODO Auto-generated method stub
		return artClassStudnetMapper.updateArtStudentGradution(list);
	}

}
