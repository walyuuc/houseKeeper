package com.chy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chy.common.Finder;
import com.chy.common.HibernateSimpleDao;
import com.chy.dao.ParamDao;
import com.chy.entity.Param;

@Repository
public class ParamDaoImpl extends HibernateSimpleDao implements ParamDao {

	public List<Param> getList(Long id,String name,Byte type){
		String sql="from Param bean where 1=1";
		Finder f=Finder.create(sql);
		if(id!=null){
			f.append(" and bean.id=:id");
			f.setParam("id", id);
		}
		if(name!=null){
			f.append(" and bean.name=:name");
			f.setParam("name", name);
		}
		if(type!=null){
			f.append(" and bean.type=:type");
			f.setParam("type", type);
		}
		f.setCacheable(true);
		return find(f);
	}
}
