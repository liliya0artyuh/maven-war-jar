package dill.utils;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class TestUtils {


	@Autowired 
	private ObjectMapper objectMapper;
	 

	

}
