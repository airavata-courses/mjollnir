package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RadarEntity;
import com.example.demo.repo.RadarDataRepo;

@Service
public class RadarDataService {
	
@Autowired	
private RadarDataRepo dataRepo;


public void saveData(RadarEntity radarEntity)
{
	try {
	dataRepo.save(radarEntity);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}

public List<RadarEntity> getData(String userName,int i)
{
	try {
	return dataRepo.getLatestData(userName,i);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return null;
}
}
