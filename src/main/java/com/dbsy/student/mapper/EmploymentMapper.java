package com.dbsy.student.mapper;

import com.dbsy.student.excel.vo.EmploymentEo;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmploymentMapper {
    int insert(Employment record);

    int insertSelective(Employment record);

    int batchInsert(List<Student> list);

    @Select("select * from employment where id = #{id}")
    Employment get(int id);

    @Select("select * from employment where student_id=#{studentId}")
    Employment getByStudentId(int studentId);

    int listCount(Map map);

    List<Employment> list(Map map);

    @Delete("delete from employment where id = #{id}")
    int delete(int id);

    int batchRemove(int[] ids);

    @Update("update employment set student_id=#{studentId},is_sign=#{isSign},phone_number=#{phoneNumber},remarks=#{remarks}  where id=#{id}")
    int update(Employment employment);

    @Update("insert into  employment set student_id=#{studentId},is_sign=#{isSign},phone_number=#{phoneNumber}, state=#{state},company=#{company},registration_to=#{registrationTo},remarks=#{remarks}")
    int addSingle(Map map);

    List<EmploymentEo> listExport(Map map);

    @Select("select state,count(*) as nums from employment group by state")
    List<Map> selectGroupByTo();
}