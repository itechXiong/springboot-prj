package com.xitech.app.portal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xitech.app.portal.entity.XitechSysUser;

@Mapper
public interface XitechSysUserMapper {
	

	  @Select("SELECT * FROM xitech_sys_user WHERE id = #{id}")
	  public XitechSysUser findSysUserById(@Param("id") String id);
	  
	  public XitechSysUser selectById(@Param("id")String id);

}
