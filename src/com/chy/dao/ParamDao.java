package com.chy.dao;

import java.util.List;

import com.chy.entity.Param;

public interface ParamDao {

	public List<Param> getList(Long id,String name,Byte type);
}
