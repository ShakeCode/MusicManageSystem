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
import com.icloud.entity.Manager;
import com.icloud.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Resource(name="managerService")
	private ManagerService managerService;
	
	
	@RequestMapping("/getAllManager")
	public String getAllManager(Model model){
		String json = new Gson().toJson(managerService.getAllManager());
		model.addAttribute("managers",json ); 
		return "managerManager";
	}
	
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateManager(String id, String name, String password){
		Manager manager = new Manager(Integer.parseInt(id),name,password);
		boolean result = managerService.updateManager(manager);
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
	public String addManager(String name,String password){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Manager manager = new Manager(name,password);
		int result =0;
		try{
			result = managerService.addManager(manager);
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
	public String deleteManager(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= managerService.delManager(Integer.parseInt(id));
		
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