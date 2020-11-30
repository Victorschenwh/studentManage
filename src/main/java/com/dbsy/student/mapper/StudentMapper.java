package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    int batchInsert(List<Student> list);

    @Select("select * from student where id = #{id}")
    Student get(int id);

    Map getSelf(int id);

    int listCount(Map map);

    List<Student> list(Map map);

    @Delete("delete from student where id = #{id}")
    int delete(int id);

    int batchRemove(int[] ids);

    @Select("select * from student where number = #{number}")
    Student selectByNumber(String number);

    @Update("update student set number=#{number},name = #{name},gender=#{gender},phone_number=#{phoneNumber}," +
            "email=#{email},id_card=#{idCard},native_place=#{nativePlace}," +
            "photo=#{photo},admission_date=#{admissionDate},birthday=#{birthday}," +
            "password=#{password},score=#{score},clazz_id=#{clazzId},major_id=#{majorId},department_id=#{departmentId}," +
            "grade=#{grade},age=#{age},nation=#{nation},address=#{address},room=#{room},status=#{status} where id=#{id}")
    int update(Student student);

    @Select("select count(*) from student")
    int selectAllStudentsCount();

    @Select("select d.name,count(*) as nums  from  student s left join department d on s.department_id = d.id  where cet4 > 424 group by s.department_id")
    List<Map> selectPassCET4CountGroupByDepartment();

    @Select("select d.name,count(*) as nums  from  student s left join department d on s.department_id = d.id  where cet6 > 424 group by s.department_id")
    List<Map> selectPassCET6CountGroupByDepartment();

    @Select("select nation , count(*) as nums from student  group by nation")
    List<Map> selectGroupByNation();

    @Select("select count(*) from  student  where major_id = #{majorId}")
    int getMajorCountByMajorId(int majorId);

    @Select("select major_id,count(*) as nums from  student group by major_id")
    List<Map> getMajorCount();
}