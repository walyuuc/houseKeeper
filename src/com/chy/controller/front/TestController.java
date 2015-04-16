package com.chy.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chy.entity.User;
import com.chy.manager.UserMng;
import com.chy.utils.ResponseUtils;

@Controller
public class TestController {

	@RequestMapping(value="/getUser/{id}")
	public String getUser(HttpServletRequest request, ModelMap model, @PathVariable Integer id){
		User user=userMng.getById(id);
		model.put("user", user);
		return "index";
	}
	
	@RequestMapping(value="/userlist")
	public String getUserList(HttpServletRequest request, ModelMap model){
		List<User> list = userMng.getList();
		model.put("userList", list);
		return "index";
	}
	
	@RequestMapping(value="/userJson")
	public void getUserJson(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		User user=userMng.getById(1);
		JSONObject json=JSONObject.fromObject(user);
		ResponseUtils.renderJson(response, json.toString());
	}
	
	@Autowired
	private UserMng userMng;
}
