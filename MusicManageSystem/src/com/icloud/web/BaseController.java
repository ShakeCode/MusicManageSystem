package com.icloud.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	public  HttpServletRequest request;
	public HttpServletResponse response;
	public  HttpSession session;
	
	@ModelAttribute
	public void initBase(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  
	}
}
