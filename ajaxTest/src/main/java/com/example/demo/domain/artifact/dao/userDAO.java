package com.example.demo.domain.artifact.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.artifact.dto.userDTO;

@Repository
public interface userDAO {

	List<userDTO> selectIdName(userDTO dto) throws Exception;
	
	userDTO selectone(userDTO dto) throws Exception;
	
	List<userDTO> ajax(userDTO dto) throws Exception;
	
	                        
}
