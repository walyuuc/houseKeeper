package com.chy.controller.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chy.entity.User;
import com.chy.manager.UserMng;
import com.chy.utils.ResponseUtils;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getPage() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, HttpServletRequest request, ModelMap model) {
		boolean res = userMng.register(user);
		model.put("res", res == true ? "注册成功" : "注册失败");
		return "register";
	}

	@RequestMapping(value = "register/{username}")
	public void getByUsername(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String username) {
		User user = null;
		if (!StringUtils.isBlank(username)) {
			user = userMng.getByUsername(username);
		}
		JSONObject res = new JSONObject();
		if (user != null) {
			res.put("res", "此用户名已存在");
		} else {
			res.put("res", "此用户名可以使用");
		}
		ResponseUtils.renderJson(response, res.toString());
	}

	@Autowired
	private UserMng userMng;
}
