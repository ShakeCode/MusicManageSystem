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
import com.icloud.entity.Album;
import com.icloud.service.AlbumService;

@Controller
@RequestMapping("/ablum")
public class AlbumController {

	@Resource(name="albumService")
	private AlbumService albumService;
	
	
	@RequestMapping("/getAllAblum")
	public String getAllAlbum(Model model){
		String json = new Gson().toJson(albumService.getAllAlbum());
		model.addAttribute("albums",json ); 
		return "ablumManager";
	}

	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateAlbum(String id,String name, String singer, String views, String introduction){
		Album album = new Album(Integer.parseInt(id),name,singer,Integer.parseInt(views),introduction);
		boolean result = albumService.updateAlbum(album);
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
	public String addAlbum(String name, String singer, String views, String introduction){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Album album = new Album(name,singer,Integer.parseInt(views),introduction);
		int result =0;
		try{
			result = albumService.addAlbum(album);
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
	public String deleteAlbum(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= albumService.delAlbum(Integer.parseInt(id));
		
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