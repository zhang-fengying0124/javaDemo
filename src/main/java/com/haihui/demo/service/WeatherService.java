package com.haihui.demo.service;

import com.haihui.demo.model.CityWeather;

public interface WeatherService {
    public CityWeather getWeatherByCity(String cityName);
}
