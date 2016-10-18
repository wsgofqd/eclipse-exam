package cn.qdsoft.exam.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qdsoft.exam.ExamException;
import cn.qdsoft.exam.MyBatisUtil;
import cn.qdsoft.exam.dao.TeacherDAO;
import cn.qdsoft.exam.model.Teacher;
import cn.qdsoft.exam.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	@Override
	public void updatePassword(Long id, String oldPassword, String newPassword) {

		try (SqlSession session = MyBatisUtil.open()) {
			TeacherDAO dao = session.getMapper(TeacherDAO.class);
			Teacher t = dao.findById(id);
			if (oldPassword.equals(t.getPassword())) {
				dao.updatePassword(id, newPassword);
			} else {
				throw new ExamException("原密码错误，不能修改");
			}
		}

	}

	@Override
	public void add(Teacher t) {
		try (SqlSession session = MyBatisUtil.open()) {
			TeacherDAO dao = session.getMapper(TeacherDAO.class);
			Teacher temp = dao.findByEmail(t.getEmail());
			if (temp != null) {
				throw new ExamException("电子邮件地址已存在");
			}
			dao.save(t);
			session.commit();
		}

	}

	@Override
	public void update(Teacher t) {
		try (SqlSession session = MyBatisUtil.open()) {
			TeacherDAO dao = session.getMapper(TeacherDAO.class);
			Teacher temp = dao.findByEmail(t.getEmail());
			if (temp == null || temp.getId() == t.getId()) {
				dao.update(t);
			} else {
				throw new ExamException("电子邮件地址已存在");
			}
			session.commit();
		}
	}

	@Override
	public List<Teacher> list() {
		try (SqlSession session = MyBatisUtil.open()) {
			TeacherDAO dao = session.getMapper(TeacherDAO.class);
			return dao.findAll();
		}
	}

}
