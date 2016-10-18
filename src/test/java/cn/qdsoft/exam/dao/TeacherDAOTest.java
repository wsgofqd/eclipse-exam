package cn.qdsoft.exam.dao;

import org.junit.Test;

import cn.qdsoft.exam.model.Teacher;

public class TeacherDAOTest extends BaseTest {

	@Test
	public void findById() {
		TeacherDAO dao = session.getMapper(TeacherDAO.class);
		Teacher t = dao.findById(1L);

		System.out.println(t.getName());

	}

	@Test
	public void findByEmail() {

		TeacherDAO dao = session.getMapper(TeacherDAO.class);

		Teacher t = dao.findByEmail("admin@qdsoft.com");

		System.out.println(t.getName());
	}

	@Test
	public void findAll() {

		TeacherDAO dao = session.getMapper(TeacherDAO.class);
		System.out.println(dao.findAll().size());

	}

	@Test
	public void save() {
		Teacher t = new Teacher();
		t.setName("李四");
		t.setEmail("lisi@qdsoft.com");
		t.setPassword("111111");
		t.setPhone("13953211111");
		t.setDuty("讲师");
		t.setStatus(1);
		t.setAge(29);

		TeacherDAO dao = session.getMapper(TeacherDAO.class);
		dao.save(t);

		session.commit();
		System.out.println(t.getId());
	}

	@Test
	public void updatePassword() {
		TeacherDAO dao = session.getMapper(TeacherDAO.class);
		dao.updatePassword(1L, "abc123");
		session.commit();
	}
}
