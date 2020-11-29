package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Suspension;
import com.dbsy.student.pojo.Transfer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface RetardationMapper {
    int insert(Retardation record);

    int insertSelective(Retardation record);

    int batchInsert(List list);

    int listCount(Map map);

    List<Map> list(Map map);

    List<Map>  list3(Map map);
    int listCount3(Map map);


    List<Map> listDropSchool(Map map);
    int listCountDrop(Map map);



    //查询所有正常学生信息
    List<Student> listStu(Map map);
    //所有正常学生个数
    int listCountStu(Map map);



    Map getSelf(int id);

    @Select("SELECT  cl.id id,cl.`name` clName FROM student stu LEFT JOIN clazz cl ON cl.department_id=stu.department_id AND cl.major_id=stu.major_id WHERE stu.id = #{stuId}")
    List<Map> listClName(int stuId);

    @Select("SELECT DISTINCT grade FROM clazz")
    List<Map> listGrade();

    @Update("insert into  retardation set save_date=#{saveDate},old_department_id=#{oldDepartmentId},old_major_id=#{oldMajorId},old_clazz_id=#{oldClazzId},remarks=#{remarks} ,student_id=#{id}")
    int updateLogic(Retardation retardation);

    //  3==留级；  2==退学；1==休学 ；0==正常
    @Update("update student set isDel=3 where id=#{id}")
    int updateLogicStu(Retardation retardation);

    @Select("select * from retardation where id = #{id}")
    Retardation get(int id);

    @Delete("delete from retardation where id = #{id}")
    int delete(int id);

    @Update("update student set isDel=0 where id=#{id}")
    int updateLogicStu3(int id);


    @Update("update retardation set new_clazz_id=#{newClazzId},is_pass=#{isPass},remarks=#{remarks},new_Grader=#{newGrader}  where id=#{id}")
    int update(Retardation retardation);

    @Update("update retardation set result=#{result},remarks=#{remarks}  where id=#{id}")
    int updateLast(Retardation retardation);

    @Update("update student set grade=#{newGrader} where id=#{studentId}")
    int updateLast_stu_grade(Retardation retardation);



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

    int updateSelective(Retardation retardation);
}