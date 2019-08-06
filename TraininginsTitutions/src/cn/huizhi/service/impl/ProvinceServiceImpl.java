package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.ProvinceMapper;
import cn.huizhi.pojo.Province;
import cn.huizhi.service.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Resource
	ProvinceMapper provinceMapper;//注入到容器中
	
	public List<Province> findProvinces() {
		return provinceMapper.selectProvinces();
	}

}
