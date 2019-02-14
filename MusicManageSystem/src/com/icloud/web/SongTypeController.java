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
import com.icloud.entity.SongType;
import com.icloud.service.SongTypeService;


@Controller
@RequestMapping("/songtype")
public class SongTypeController {

	@Resource(name="songTypeService")
	private SongTypeService songTypeService;
	
	
	@RequestMapping("/getAllSongType")
	public String getAllSongType(Model model){
		String json = new Gson().toJson(songTypeService.getAllSongType());
		model.addAttribute("songTypes",json ); 
		return "songTypeManager";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	@ResponseBody
	public String addSongType(String typeName){
		HashMap<String, Object> map = new HashMap<String, Object>();
		SongType songType = new SongType();
		songType.setTypeName(typeName);
		int result =0;
		try{
			result = songTypeService.addSongType(songType);
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
	public String deletesongType(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= songTypeService.delSongType(Integer.parseInt(id));
		
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