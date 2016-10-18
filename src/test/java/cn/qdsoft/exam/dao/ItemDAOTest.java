package cn.qdsoft.exam.dao;

import org.junit.Test;

public class ItemDAOTest extends BaseTest {

	@Test
	public void findByQuestionId() {
		ItemDAO dao = session.getMapper(ItemDAO.class);

		dao.findByQuestionId(1L).stream().forEach(m -> System.out.println(m.getTitle()));
	}

}
