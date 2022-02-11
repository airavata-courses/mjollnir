package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

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


public HashMap<String, String> radarLocations()
{
	try {
	

	    File resource = ResourceUtils.getFile("classpath:Locations.csv");
	    InputStream inputStream = new FileInputStream(resource);
	    try {
	        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	        String data = new String(bdata, StandardCharsets.UTF_8);
	       data=data.replaceAll("\\s{2,}", "-");
	       System.out.println(data);
	        String[] dataList=data.split("-");
	        HashMap<String, String> map = new HashMap<>();
for(int i =1;i<dataList.length;i=i+1)
{
	String[] temp=dataList[i].split(",\"");
	map.put(temp[0], temp[1].substring(0,temp[1].length()-1));
	
	
}
	       System.out.println(dataList.length+" "+map.size());
	       
	        
	        return map;
	    } catch (IOException e) {
	    	System.out.println("IOException");
	    }
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return null;
}
}
