package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RadarEntity;

import com.example.demo.service.RadarDataService;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="/radarcontroller")
public class RadarDataController {
	@Autowired
	private RadarDataService dataService;

	@GetMapping(path = "/getdata/{userName}/{page}")
	public List<RadarEntity> getData(@PathVariable String userName, int page) {
		return dataService.getData(userName, page);
	}

	@PostMapping(path = "/saveradar")
	public ResponseEntity saveRadar(@RequestBody RadarEntity radarData) {

		dataService.saveData(radarData);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@GetMapping(path = "/radarlocations")
	public String radarLocations() {
		Gson gson = new Gson(); 
		String json = gson.toJson(dataService.radarLocations()); 
		//json=json.replace("\n", "").replace("\r", "");
		return json;
	}
}
