package cn.qdsoft.exam.dao;

import java.util.List;

import cn.qdsoft.exam.model.Subject;

public interface SubjectDAO {

	List<Subject> findAll();

	Subject findById(Long id);
}
