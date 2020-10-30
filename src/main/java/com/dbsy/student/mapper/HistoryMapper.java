package com.dbsy.student.mapper;

import com.dbsy.student.pojo.History;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface HistoryMapper {

    //    @Insert("insert into history (id,ip,admin_id,insert_time,url,args,ret,method) values (#{ip},#{adminId},#{insertTime},#{url},#{args},#{ret},#{method})")
    int insert(History history);

    //    @Update("update history set ip=#{ip},admin_id=#{adminId},insert_time=#{insertTime},url=#{url},args=#{args},ret=#{ret},method=#{method} where id=#{id}")
    int update(History history);

    @Delete("delete from history where id = #{id}")
    int delete(Integer id);

    @Select("select * from history where id = #{id}")
    History select(Integer id);


    List<History> list(Map map);

    int count(Map map);
}
