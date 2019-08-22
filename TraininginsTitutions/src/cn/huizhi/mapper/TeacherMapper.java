package cn.huizhi.mapper;

/**
 * 教师
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.huizhi.pojo.Teacher;
import cn.huizhi.pojo.User;

public interface TeacherMapper {

	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> selectTeacher(Integer schoolId);
	
	/**
	 * 删除教师 
	 * @param uId
	 * @return
	 */
	public Integer delTeacher(Integer teacherId);
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	public Integer updateTeacher(Teacher teacher);
	
	/**
	 * 添加教师
	 * @param user
	 * @return
	 */
	public Integer addTeacher(Teacher teacher );
	
	/**
	 * 根据学校主键查询该学校下所有老师
	 * @param schoolId
	 * @return
	 */
	public List<Teacher> selectTeacherListBySchoolId(@Param("schoolId")Integer schoolId);
	
	
	/**
	 * 根据学校主键和教师类别主键查询老师
	 * @param teacherTypeId
	 * @param schoolId
	 * @return
	 */
	public List<Teacher> selecTeachersByTeacherTypeId(@Param("teacherTypeId")Integer teacherTypeId,@Param("schoolId")Integer schoolId);
	
	/**
	 * 教师登录
	 * @param loginName
	 * @param loginPassword
	 * @param schoolId
	 * @return
	 */
	public Teacher selectTeacherByLogin(@Param("teacherName")String loginName,@Param("loginPassword")String loginPassword,@Param("schoolId")Integer schoolId);
	/**
	 * 根据教师主键查询教师信息
	 * @param teacherId
	 * @return
	 */
	public Teacher selectTeacherByTeacherId(@Param("teacherId")Integer teacherId);
	
	/**
	 * 添加教师-查询新插入数据的id
	 * @param teacher
	 * @return
	 */
	public Teacher selectTeachers(Teacher teacher);
	
	/**
	 * 根据教师名称查询教师是否存在
	 * @param teacherName
	 * @return
	 */
	public Teacher selecTeacherByTeacherName(@Param("teacherName")String teacherName);
}
