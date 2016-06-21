package com.tianyl.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianyl.entity.City;
import com.tianyl.repository.CityRepository;
import com.tianyl.utils.SpringUtils;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping("/list")
	public void list(HttpServletResponse response) {
		List<City> cities = cityRepository.findAll();
		SpringUtils.renderJson(response, cities);
	}

	@RequestMapping("/save")
	public void save(HttpServletResponse response) {
		City city = new City("北京");
		cityRepository.save(city);
		SpringUtils.renderJson(response, "ok");
	}

}
