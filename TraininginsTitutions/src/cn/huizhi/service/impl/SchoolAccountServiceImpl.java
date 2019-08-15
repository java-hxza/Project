package cn.huizhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.huizhi.mapper.SchoolAccountMapper;
import cn.huizhi.pojo.SchoolAccount;
import cn.huizhi.service.SchoolAccountService;

/**
 * 学校账户
 * @author wye
 *
 */
@Service
public class SchoolAccountServiceImpl  implements SchoolAccountService{
	@Resource
	SchoolAccountMapper schoolAccountMapper;
	
	public List<SchoolAccount> findSchoolAccountsBySchoolId(Integer schoolId) {
		return schoolAccountMapper.selectSchoolAccountsBySchoolId(schoolId);
	}

}
