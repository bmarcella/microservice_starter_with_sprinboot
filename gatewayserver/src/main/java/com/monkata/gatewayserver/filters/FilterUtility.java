 package com.monkata.gatewayserver.filters;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtility {
    public static String CORRELATION_ID = "monkata-correlaton-id";
    
	public String getCorrelationId(HttpHeaders requestHeaders) {
		if(requestHeaders.get(CORRELATION_ID) != null) {
			List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID);
			return requestHeaderList.stream().findFirst().get();
		} else {
		  return null;
		}
	}

	private ServerWebExchange setRequestHeader (ServerWebExchange exchange, String name, String value) {
		// TODO Auto-generated method stub
		return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
	}
	
	public ServerWebExchange setCorrelation(ServerWebExchange exchange, String correlationId) {
	   return this.setRequestHeader(exchange,CORRELATION_ID, correlationId);
	}



}
