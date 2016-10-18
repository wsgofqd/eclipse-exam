package cn.qdsoft.exam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import cn.qdsoft.exam.MyBatisUtil;
import cn.qdsoft.exam.WebUtil;
import cn.qdsoft.exam.dao.TeacherDAO;
import cn.qdsoft.exam.model.Teacher;

@SuppressWarnings("serial")
@WebServlet("/teacher/update.do")
public class TeacherUpdateServlet extends HttpServlet {

	/**
	 * http://localhost/teacher/update.do?id=1
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = WebUtil.getLong(req, "id");
		try (SqlSession ssn = MyBatisUtil.open()) {
			TeacherDAO dao = ssn.getMapper(TeacherDAO.class);
			Teacher teacher = dao.findById(id);
			req.setAttribute("teacher", teacher);
		}
		req.getRequestDispatcher("edit.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接收表单数据
		try (SqlSession ssn = MyBatisUtil.open()) {
			TeacherDAO dao = ssn.getMapper(TeacherDAO.class);
			Teacher t = dao.findById(WebUtil.getLong(req, "id"));
			// t.setName(WebUtil.getString(req, "name"));
			// t.setPhone(WebUtil.getString(req, "phone"));
			// t.setEmail(WebUtil.getString(req, "email"));
			WebUtil.populate(req, t);
			dao.update(t);
			ssn.commit();

		}
		// post后转发的模式
		WebUtil.redirect(req, resp, "/teacher/list.do");

	}
}
