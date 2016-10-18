package cn.qdsoft.exam.dao;

import org.junit.Test;

import cn.qdsoft.exam.model.Question;

public class QuestionDAOTest extends BaseTest {

	@Test
	public void findById() {

		QuestionDAO dao = session.getMapper(QuestionDAO.class);

		Question q = dao.findById(1L);

		System.out.println(q.getTitle());

	}

	@Test
	public void findAll() {
		QuestionDAO dao = session.getMapper(QuestionDAO.class);
		dao.findAll().stream().forEach(q -> {
			System.out.println(q.getId() + ":" + q.getTitle() + ":" + q.getSubject().getId());
		});
	}
}
