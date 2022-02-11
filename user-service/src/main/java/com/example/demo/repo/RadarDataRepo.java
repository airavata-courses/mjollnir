package com.example.demo.repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RadarData;
import com.example.demo.model.RadarEntity;
import com.example.demo.model.User;

@Repository
public interface RadarDataRepo extends JpaRepository<RadarEntity,Long> {
	 default List<RadarEntity> getLatestData(String userName,Integer count)
    {
        return getByuserNameOrderByStartDateDesc(userName,PageRequest.of(0, count));
    }

	public List<RadarEntity> getByuserNameOrderByStartDateDesc(String userName, PageRequest of);

	//public List<RadarEntity> getByuserName(String userName, PageRequest of);
}