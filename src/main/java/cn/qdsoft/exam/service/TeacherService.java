package cn.qdsoft.exam.service;

import java.util.List;

import cn.qdsoft.exam.model.Teacher;

public interface TeacherService {

	void updatePassword(Long id, String oldPassword, String newPassword);

	void add(Teacher t);

	void update(Teacher t);

	List<Teacher> list();
}
