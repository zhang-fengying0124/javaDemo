package com.haihui.demo.service.impl;

import com.haihui.demo.model.CityWeather;
import com.haihui.demo.service.WeatherService;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WeatherServiceImpl implements WeatherService {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	public CityWeather getWeatherByCity(String cityName) {
		//接口地址
		String apiUrl = "http://web.juhe.cn:8080/environment/air/cityair?city=" + cityName + "&key=087095134902ea434c24705642cb2f44";

		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder()
		    .url(apiUrl)
		    .build();
		Call call = okHttpClient.newCall(request);
		String resuString = "";
		try {
		    Response response = call.execute();
		    resuString = response.body().string();
//		    System.out.println(response.body().string());
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		System.out.println(resuString);
		
//		 Gson gson = new GsonBuilder().create();
//		 gson.toJson(resuString);
		 
		

//        
        //new weather对象
		CityWeather cityWeather = new CityWeather();
		
		return cityWeather;
	}
	

	//测试是否有效
	public static void main(String[] args) {
		WeatherServiceImpl test = new WeatherServiceImpl();
		System.out.println(test.getWeatherByCity("大连"));
	}
}
