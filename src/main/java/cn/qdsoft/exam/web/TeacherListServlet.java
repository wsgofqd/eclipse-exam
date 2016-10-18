package cn.qdsoft.exam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import cn.qdsoft.exam.MyBatisUtil;
import cn.qdsoft.exam.dao.TeacherDAO;
import cn.qdsoft.exam.model.Teacher;

@SuppressWarnings("serial")
@WebServlet("/teacher/list.do")
public class TeacherListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (SqlSession ssn = MyBatisUtil.open()) {
			List<Teacher> teachers = null;
			TeacherDAO dao = ssn.getMapper(TeacherDAO.class);
			// 查询出所有teacher
			teachers = dao.findAll();
			req.setAttribute("teachers", teachers);
			System.out.println("aaaaaaaaaaaaaaaaaaa");
		}
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
