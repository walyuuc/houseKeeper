package com.chy.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.RelativeDao;
import com.chy.entity.Relative;
import com.chy.manager.RelativeMng;

@Service
public class RelativeMngImpl implements RelativeMng {

	public List<Relative> getByEmployee(Long employeeId,Page page){
		page.init(page.getPageSize(),dao.getCount(employeeId));
		return dao.getByEmployee(employeeId,page);
	}
	
	@Autowired
	private RelativeDao dao;
}

