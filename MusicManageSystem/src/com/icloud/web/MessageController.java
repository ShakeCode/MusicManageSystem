package com.icloud.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.icloud.entity.Announcement;
import com.icloud.entity.Message;
import com.icloud.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource(name="messageService")
	private MessageService messageService;
	

	@RequestMapping("/select/current")
	@ResponseBody
	public Message getNowMessage(){
		Message message = messageService.selectNowMessage();
		return message;
	}
	
	
	@RequestMapping("/getAllMessage")
	public String getAllMessage(Model model){
		String json = new Gson().toJson(messageService.getAllMessage());
		model.addAttribute("messages",json ); 
		return "messageManager";
	}
	
	@RequestMapping("/getMessage")
	public String getMessage(String offer,Model model){
		String json = new Gson().toJson(messageService.getMessageList(Integer.parseInt(offer)));
		//TODO:鍔犻〉鏁�0
		Map<String, Integer> re = new HashMap<String, Integer>(); 
		re.put("total", messageService.getCount());
		String page = new Gson().toJson(re);
		model.addAttribute("messages",json ); 
		model.addAttribute("page",page ); 
		return "messageManager";
	}

	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	@ResponseBody
	public String updateMessage(String id, String contant, String songID){
		Message message = new Message(Integer.parseInt(id),contant,Integer.parseInt(songID));
		boolean result = messageService.updateMessage(message);
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
	public String addMessage( String contant, String songID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Message message = new Message(contant,Integer.parseInt(songID));
		int result =0;
		try{
			result = messageService.addMessage(message);
		}catch(Exception e){
			map.put("isSuccess", "faile");
			String json = new Gson().toJson(map);
			return json;
		}	
		//鎴愬姛鎵ц
		map.put("isSuccess", "success");
		map.put("id", result);
		String json = new Gson().toJson(map);
		return json;
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteMessage(String id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result	= messageService.delMessage(Integer.parseInt(id));
		
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

	@RequestMapping("/getAnnouncement")
	public String getAnnouncement(Model model){
		Map<String , Object> map = Announcement.get();
		model.addAttribute("title",map.get("title") );
		model.addAttribute("content",map.get("content") );
		return "announcementManager";
	}
	
	@RequestMapping("/saveAnnouncement")
	@ResponseBody
	public String setAnnouncement(String title,String content){
		boolean result = Announcement.set(title, content);
		HashMap<String, Object> map = new HashMap<String, Object>();
		String isSuccess = "success";
		//澶辫触
		if(!result){
			isSuccess = "false";
		}
		map.put("isSuccess", isSuccess);		
		String json = new Gson().toJson(map);
		return json;
	}
}