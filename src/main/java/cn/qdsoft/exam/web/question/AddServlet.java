package cn.qdsoft.exam.web.question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import cn.qdsoft.exam.MyBatisUtil;
import cn.qdsoft.exam.WebUtil;
import cn.qdsoft.exam.dao.ItemDAO;
import cn.qdsoft.exam.dao.QuestionDAO;
import cn.qdsoft.exam.dao.SubjectDAO;
import cn.qdsoft.exam.model.Item;
import cn.qdsoft.exam.model.Question;
import cn.qdsoft.exam.model.Subject;
import cn.qdsoft.exam.model.Teacher;

@WebServlet("/question/add.do")
public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (SqlSession ssn = MyBatisUtil.open()) {

			SubjectDAO subjectDAO = ssn.getMapper(SubjectDAO.class);
			// 查询出所有teacher
			List<Subject> subjects = subjectDAO.findAll();

			req.setAttribute("subjects", subjects);

		}

		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Question q = new Question();
		q.setSubject(new Subject());
		q.setStatus(1);
		// todo: 换成真正登录用户
		Teacher t = new Teacher();
		t.setId(1L);
		q.setTeacher(t);
		q.getSubject().setId(WebUtil.getLong(req, "subject.id"));
		WebUtil.populate(req, q);
		for (int i = 1; i <= 4; i++) {
			Item m = new Item();
			m.setTitle(WebUtil.getString(req, "item" + i));
			m.setQuestion(q);//
			q.getItems().add(m);
		}
		String[] answers = req.getParameterValues("answer");
		for (int i = 0; i < answers.length; i++) {
			int answer = Integer.parseInt(answers[i]);
			q.getItems().get(answer - 1).setCorrect(true);
		}
		// System.out.println("id" + q.getId());
		// System.out.println("title:" + q.getTitle());
		// System.out.println("subject.id:" + q.getSubject().getId());
		// System.out.println("type:" + q.getType());
		// System.out.println("teacher:" + q.getTeacher().getId());
		// q.getItems().stream().forEach(m -> {
		// System.out.println(m.getId() + ":" + m.getTitle() + ":" +
		// m.isCorrect());
		// });
		try (SqlSession ssn = MyBatisUtil.open()) {

			QuestionDAO questionDAO = ssn.getMapper(QuestionDAO.class);
			ItemDAO itemDAO = ssn.getMapper(ItemDAO.class);
			questionDAO.save(q);
			q.getItems().forEach(itemDAO::save);

			ssn.commit();

		}
		WebUtil.redirect(req, resp, "/question/list.do");

	}
}
