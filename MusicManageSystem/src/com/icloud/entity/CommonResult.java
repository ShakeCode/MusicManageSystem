package com.icloud.entity;

import java.util.List;

public class CommonResult {

	private  String message;
	
	private  List data;
	
	private  Integer success;  //(1,0)
	
	private  Pager pager;
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public CommonResult(String message, List data, Integer success) {
		super();
		this.message = message;
		this.data = data;
		this.success = success;
	}
	
	public CommonResult( Integer success,String message) {
		super();
		this.success = success;
		this.message=message;
	}
	
	public CommonResult( List data, Integer success,String message) {
		super();
		this.data = data;
		this.success = success;
		this.message=message;
	}
	
	public CommonResult( Pager pager, Integer success,String message) {
		super();
		this.pager = pager;
		this.success = success;
		this.message=message;
	}
	
	public static CommonResult returnSuccess(List list){
		return new CommonResult(list,1,"success");
	}
	
	public static CommonResult returnSuccess(Pager pager){
		return new CommonResult(pager,1,"success");
	}
	
	public static CommonResult returnSuccess(Integer success,String message){
		return new CommonResult(success,message);
	}
	
	public static CommonResult returnError(Integer success,String message){
		return new CommonResult(success,message);
	}
}
