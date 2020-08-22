package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Retardation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
@Mapper
public interface RetardationMapper {
    int insert(Retardation record);

    int insertSelective(Retardation record);

    int listCount(Map map);

    List<Retardation> list(Map map);

    @Select("select * from retardation where id = #{id}")
    Retardation get(int id);

    @Delete("delete from retardation where id = #{id}")
    int delete(int id);

    @Update("update retardation set student_id=#{studentId},old_department_id=#{oldDepartmentId},old_major_id=#{oldMajorId},old_clazz_id=#{oldClazzId},new_department_id=#{newDepartmentId},new_major_id=#{newMajorId},new_clazz_id=#{newClazzId},save_date=#{saveDate},is_pass=#{isPass},result=#{result},remarks=#{remarks}  where id=#{id}")
    int update(Retardation retardation);

    int batchRemove(int[] ids);

    @Select("select * from retardation")
    List<Retardation> getAll();

    @Select("select * from retardation where student_id=#{studentId}")
    List<Retardation> getRetardationByStudentId(int studentId);

    @Select("select * from retardation where old_department_id=#{oldDepartmentId}")
    List<Retardation> getRetardationByOldDepartmentId(int oldDepartmentId);

    @Select("select * from retardation where old_major_id=#{oldMajorId}")
    List<Retardation> getRetardationByOldMajorId(int oldMajorId);

    @Select("select * from retardation where old_clazz_id=#{oldClazzId}")
    List<Retardation> getRetardationByOldClazzId(int oldClazzId);

    @Select("select * from retardation where new_department_id=#{newDepartmentId}")
    List<Retardation> getRetardationByNewDepartmentId(int newDepartmentId);

    @Select("select * from retardation where new_major_id=#{newMajorId}")
    List<Retardation> getRetardationByNewMajorId(int newMajorId);

    @Select("select * from retardation where new_clazz_id=#{newClazzId}")
    List<Retardation> getRetardationByNewClazzId(int newClazzId);
}