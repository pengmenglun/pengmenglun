package com.company.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysLogMapper {
	  @Delete("delete from sys_logs where id=#{id}")
	  int deleteObject(Integer id);
	  
	  @Select("select id,createdTime from sys_logs limit #{startIndex},#{pageSize}")
	  List<Map<String,Object>> findPageObjects(
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
	  
	  
}
//SysLogMapper.xml--->mybatis-configs.xml
//SysLogMapper.class-->MyBatisConfig











