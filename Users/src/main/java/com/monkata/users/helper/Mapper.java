package com.monkata.users.helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper <F> {

   
	  public <T> T map(F source, Class<T> resultClass) { ModelMapper modelMapper =
	  new ModelMapper(); return modelMapper.map(source, resultClass);
	  }
	 
	
}
