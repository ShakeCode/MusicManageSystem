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
import com.icloud.entity.Lyc;
import com.icloud.service.LycService;

@Controller
@RequestMapping("/lyc")
public class LycController {

	@Resource(name="lycService")
	private LycService lycService;
	
	
	@RequestMapping("/getAllLyc")
	public String getAllLyc(Model model){
		String json = new Gson().toJson(lycService.getAllLyc());
		model.addAttribute("lycs",json ); 
		return "lycManager";
	}

	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateLyc(String id,String lycName,String songName, String songID, String lycURL, String author){
		Lyc lyc = new Lyc(Integer.parseInt(id),lycName,songName,Integer.parseInt(songID),lycURL,author);
		boolean result = lycService.updateLyc(lyc);
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
	public String addLyc(String lycName,String songName, String songID, String lycURL, String author){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Lyc lyc = new Lyc(lycName,songName,Integer.parseInt(songID),lycURL,author);
		int result =0;
		try{
			result = lycService.addLyc(lyc);
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
	public String deleteLyc(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= lycService.delLyc(Integer.parseInt(id));
		
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