package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Transfer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
@Mapper
public interface TransferMapper {
    int insert(Transfer record);

    int insertSelective(Transfer record);

    int listCount(Map map);

    List<Transfer> list(Map map);

    @Select("select * from transfer where id = #{id}")
    Transfer get(int id);

    @Delete("delete from transfer where id = #{id}")
    int delete(int id);

    @Update("update transfer set student_id=#{studentId},old_department_id=#{oldDepartmentId},old_major_id=#{oldMajorId},old_clazz_id=#{oldClazzId},new_department_id=#{newDepartmentId},new_major_id=#{newMajorId},new_clazz_id=#{newClazzId},is_pass=#{isPass},old_out_date=#{oldOutDate},new_in_date=#{newInDate}  where id=#{id}")
    int update(Transfer transfer);

    int batchRemove(int[] ids);

    @Select("select * from transfer")
    List<Transfer> getAll();

    @Select("select * from transfer where student_id=#{studentId}")
    List<Transfer> getTransferByStudentId(int studentId);

    @Select("select * from transfer where old_department_id=#{oldDepartmentId}")
    List<Transfer> getTransferByOldDepartmentId(int oldDepartmentId);

    @Select("select * from transfer where old_major_id=#{oldMajorId}")
    List<Transfer> getTransferByOldMajorId(int oldMajorId);

    @Select("select * from transfer where old_clazz_id=#{oldClazzId}")
    List<Transfer> getTransferByOldClazzId(int oldClazzId);

    @Select("select * from transfer where new_department_id=#{newDepartmentId}")
    List<Transfer> getTransferByNewDepartmentId(int newDepartmentId);

    @Select("select * from transfer where new_major_id=#{newMajorId}")
    List<Transfer> getTransferByNewMajorId(int newMajorId);

    @Select("select * from transfer where new_clazz_id=#{newClazzId}")
    List<Transfer> getTransferByNewClazzId(int newClazzId);
}