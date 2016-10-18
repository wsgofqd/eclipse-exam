package cn.qdsoft.exam.dao;

import java.util.List;

import cn.qdsoft.exam.model.Question;

public interface QuestionDAO {
	Question findById(Long id);

	List<Question> findAll();

	void save(Question q);
}
