package com.icloud.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.icloud.entity.Singer;
import com.icloud.service.SingerService;

@Controller
@RequestMapping("/singer")
public class SingerController {

	@Resource(name="singerService")
	private SingerService singerService;
	
	
	@RequestMapping("/getAllSinger")
	public String getAllSinger(Model model){
		String json = new Gson().toJson(singerService.getAllSinger());
		model.addAttribute("singers",json ); 
		return "singerManager";
	}
	
    @RequestMapping("/uploadPhoto")
	@ResponseBody
	public String uploadSong(@RequestParam("uploadFile")MultipartFile file,HttpServletRequest request) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// ÅÐ¶ÏÎÄ¼þÊÇ·ñÎª¿Õ  
        if (!file.isEmpty()) {  
            try {  
                // ÎÄ¼þ±£´æÂ·¾¶ (ÏîÄ¿Â·¾¶) 
            	String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
                int num=t.indexOf(".metadata");
                String path=t.substring(1,num).replace('/', '\\')+"MusicManageSystem\\WebContent\\img\\";
                
                String filePath = path  + file.getOriginalFilename();  
                
                File destFile = new File(filePath);
                File parentFile = destFile.getParentFile();
                if(!parentFile.exists()){
                	parentFile.mkdirs();
                }
                if(!destFile.exists()){
                	destFile.createNewFile();
                }
                // ×ª´æÎÄ¼þ  
                file.transferTo(destFile);
                map.put("isSuccess", "success");
                map.put("photoName", "../../img/"+file.getOriginalFilename());
            }catch(Exception e){
            	 e.printStackTrace();  
            }
        }else{
        	map.put("isSuccess", "faile");
        }
		return new Gson().toJson(map);
	}

	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateSinger(String id,String name, String sex, int views, String hobby,String type,String photoName){
		Singer singer = new Singer(Integer.parseInt(id),name, sex, views, hobby,type,photoName);
		boolean result = singerService.updateSinger(singer);
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
	public String addSinger(String name, String sex, int views, String hobby,String type,String introduction,String photoName){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Singer singer = new Singer(name, sex, views, hobby, type,introduction, photoName);
		int result =0;
		try{
			result = singerService.addSinger(singer);
		}catch(Exception e){
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}	
		//³É¹¦Ö´ÐÐ
		map.put("isSuccess", "success");
		map.put("id", result);
		String json = new Gson().toJson(map);
		return json;
	}	
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteSinger(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= singerService.delSinger(Integer.parseInt(id));
		
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