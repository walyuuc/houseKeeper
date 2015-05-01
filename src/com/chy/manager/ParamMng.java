package com.chy.manager;

import java.util.Map;

import com.chy.entity.Param;

public interface ParamMng {

	public Map<String,Param> getList(Long id,String name,Byte type);
}
