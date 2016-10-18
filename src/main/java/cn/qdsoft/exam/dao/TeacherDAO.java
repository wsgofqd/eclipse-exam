package cn.qdsoft.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.qdsoft.exam.model.Teacher;

public interface TeacherDAO {

	Teacher findById(Long id);

	Teacher findByEmail(String email);

	List<Teacher> findAll();

	void save(Teacher teacher);

	void update(Teacher teacher);

	void updatePassword(@Param("id") Long id, @Param("password") String password);

}
