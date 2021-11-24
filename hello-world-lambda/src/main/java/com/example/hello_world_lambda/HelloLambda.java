package com.example.hello_world_lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambda implements RequestHandler<Object, Object>  {

	@Override
	public Object handleRequest(Object input, Context context) {
		System.out.print("Hello from lambda");
		return "Hello from lambda";
	}

}
