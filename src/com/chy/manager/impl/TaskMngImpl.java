package com.chy.manager.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.TaskDao;
import com.chy.entity.Param;
import com.chy.entity.Task;
import com.chy.entity.User;
import com.chy.manager.ParamMng;
import com.chy.manager.RelativeMng;
import com.chy.manager.TaskMng;
import com.chy.manager.UserMng;

@Service
public class TaskMngImpl implements TaskMng{

	public Page getByEmployee(Long employeeId,Page page){
		page=dao.get(null, employeeId, page);
		return page;
	}
	
	public Page getByEmployer(Long employerId,Page page){
		page=dao.get(employerId, null, page);
		return page;
	}
	
	public void releaseTask(Byte type,HttpServletRequest request){
		Long userId=(Long) request.getSession().getAttribute("userId");
		User employer=userMng.getById(userId);
		User employee=relMng.getByEmployer(userId);
		Map<String,Param> map=paramMng.getList(null, null, type);
		JSONObject paramJson=new JSONObject();
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			String key=it.next();
			String value=request.getParameter(key);
			paramJson.put(key, value);
		}
		Task task=new Task(employer, employee, type, new Date(), null, paramJson.toString());
		dao.save(task);
	}
	
	@Autowired
	private TaskDao dao;
	@Autowired
	private ParamMng paramMng;
	@Autowired
	private UserMng userMng;
	@Autowired
	private RelativeMng relMng;
}
