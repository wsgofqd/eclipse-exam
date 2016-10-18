package cn.qdsoft.exam.dao;

import java.util.List;

import org.junit.Test;

import cn.qdsoft.exam.model.Subject;

public class SubjectDAOTest extends BaseTest {

	@Test
	public void findAll() {

		SubjectDAO subjectDAO = session.getMapper(SubjectDAO.class);
		// 查询出所有teacher
		List<Subject> subjects = subjectDAO.findAll();
		subjects.stream().forEach(s -> System.out.println(s.getName()));
	}

}
