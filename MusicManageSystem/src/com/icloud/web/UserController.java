package com.icloud.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.icloud.entity.CommonResult;
import com.icloud.entity.Manager;
import com.icloud.entity.User;
import com.icloud.service.ManagerService;
import com.icloud.service.UserService;
import com.icloud.util.AjaxUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource(name="userService")
	private UserService userService;
	@Resource(name="managerService")
	private ManagerService managerService;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/register")
	public String register(String username,String passward,String role){
		try {
			//判断用户角色
			if("1".equals(role)){
				User user = new User();
				user.setName(username);
				user.setPassword(passward);
				
				User isUser = userService.getUserByName(username,passward);
				if(isUser != null){
					AjaxUtil.makeAjaxResponse(response,"用户已存在",AjaxUtil.FAIL);
				}else{
					Integer i = userService.addUser(user);
					if(i !=null){
						AjaxUtil.makeAjaxResponse(response,"success",AjaxUtil.SUCCESS);
					}else{
						AjaxUtil.makeAjaxResponse(response,"error",AjaxUtil.FAIL);
					}	
				}
				//管理员注册
			}else if("2".equals(role)){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/login/home")
	public String loginTo(String username,String passward,String role){
		//用户角色判断
		if("1".equals(role)){
			User user = userService.getUserByName(username,passward);
			if(null != user){
				request.setAttribute("user", user);
				request.setAttribute("username", user.getName());
				AjaxUtil.makeAjaxResponse(response,"success",AjaxUtil.SUCCESS);
			}else{
				AjaxUtil.makeAjaxResponse(response,"error",AjaxUtil.FAIL);
			}
			
			//����T���
		}else if("2".equals(role)){
			Manager manager = managerService.getManagerByName(username, passward);
			if(manager != null){
				AjaxUtil.makeAjaxResponse(response,"success",AjaxUtil.SUCCESS);
			}else{
				AjaxUtil.makeAjaxResponse(response,"error",AjaxUtil.FAIL);
			}
		}
		
		return null;
	}
	@RequestMapping("/login/index")
	public String loginIndex(){
		
		return "index";
	}
	
	
	@RequestMapping("/getAllUser")
	public String getAllUser(Model model){
		String json = new Gson().toJson(userService.getAllUser());
		model.addAttribute("users",json ); 
		return "userManager";
	}

	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(String id,String name,String password,String nickname,String sex,
			String qq,String email,String introduction){
		User user = new User(Integer.parseInt(id),name,password,nickname,sex,qq,email,introduction);
		boolean result = userService.updateUser(user);
		HashMap<String, String> map = new HashMap<String, String>();
		if(result){
			map.put("isSuccess", "success");
			String json = new Gson().toJson(map);
			return json;
		}else{
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}
		
	}
	
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(String name,String password,String nickname,String sex,
			String qq,String email,String introduction){
		HashMap<String, Object> map = new HashMap<String, Object>();
		User user = new User(name,password,nickname,sex,qq,email,introduction);
		int result =0;
		try{
			result = userService.addUser(user);
		}catch(Exception e){
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}	
		//成功执行
		map.put("isSuccess", "success");
		map.put("id", result);
		String json = new Gson().toJson(map);
		return json;
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= userService.delUser(Integer.parseInt(id));
		
		if(result){
			map.put("isSuccess", "success");
			String json = new Gson().toJson(map);
			return json;
		}else{
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}
	}
	
}