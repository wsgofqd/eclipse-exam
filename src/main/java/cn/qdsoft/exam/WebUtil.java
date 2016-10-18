package cn.qdsoft.exam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static Long getLong(HttpServletRequest req, String name) {
		String str = req.getParameter(name);
		return Long.valueOf(str);
	}

	public static String getString(HttpServletRequest req, String name) {
		return req.getParameter(name);
	}

	public static void populate(HttpServletRequest req, Object bean) throws IOException {
		try {
			BeanUtils.populate(bean, req.getParameterMap());
		} catch (Exception e) {

			e.printStackTrace();
			throw new IOException(e.getCause());
		}
	}

	public static void redirect(HttpServletRequest req, HttpServletResponse resp, String url) throws IOException {
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath + url);

	}

}
