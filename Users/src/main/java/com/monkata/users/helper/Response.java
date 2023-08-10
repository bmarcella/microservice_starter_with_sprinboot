package com.monkata.users.helper;

public class Response<T> {
	
	public boolean error;
	public T data;
	public String  message;
	public int status;
	
	public Response(boolean error, T data, String message, int status ) {
		this.error = error;
		this.data = data;
		this.message = message; 
		this.status = status;
	}

}
