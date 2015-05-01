package com.chy.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.dao.ParamDao;
import com.chy.entity.Param;
import com.chy.manager.ParamMng;

@Service
public class ParamMngImpl implements ParamMng {

	public Map<String,Param> getList(Long id,String name,Byte type){
		List<Param> list=dao.getList(id, name, type);
		return changeParamsToMap(list);
	}
	
	public Map<String,Param> changeParamsToMap(List<Param> list){
		Map<String,Param> map=new HashMap<String, Param>();
		for(int i=0;i<list.size();i++){
			map.put(String.valueOf(list.get(i).getId()), list.get(i));
		}
		return map;
	}
	
	@Autowired
	private ParamDao dao;
}
