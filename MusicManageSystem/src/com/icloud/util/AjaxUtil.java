package com.icloud.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxUtil {
   public static final int  SUCCESS = 1;
   public static final int FAIL = 0;
  
   public static void makeAjaxResponse( final HttpServletResponse response,String message , int status){
	   PrintWriter writer = null;
	  /* response.reset();*/
	   response.setCharacterEncoding("utf-8");
	   try {
		writer = response.getWriter();
		writer.println(printJson(message,status,null));
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		
		writer.flush();
		writer.close();
		
	}
   }
   
   public static void makeAjaxResponse(final HttpServletResponse response,String message , int status,List list){
	   PrintWriter writer = null;
	   response.setCharacterEncoding("utf-8");
	   try {
		writer = response.getWriter();
		writer.println(printJson(message,status,list));
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		writer.flush();
		writer.close();
	}
   }
   
   public static String printJson(String message,int status,List list){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("message", message);
	  map.put("status", status);
	  map.put("data", list);
	  Gson gson = new Gson();
	  return gson.toJson(map);
   }
}
