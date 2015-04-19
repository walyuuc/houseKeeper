package com.chy.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private Logger log=LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		log.info(request.getRemoteAddr()+" come in");
		return "index";
	}
}
