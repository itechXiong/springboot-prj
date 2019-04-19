package com.xitech.app.portal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMappers {
	

	  @Select("SELECT * FROM CITY WHERE state = #{state}")
	  void findByState(@Param("state") String state);

}
