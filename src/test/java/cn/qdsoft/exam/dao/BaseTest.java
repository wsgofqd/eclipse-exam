package cn.qdsoft.exam.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import cn.qdsoft.exam.MyBatisUtil;

public class BaseTest {

	protected SqlSession session;

	@Before
	public void before() {
		session = MyBatisUtil.open();
		System.out.println("before.....");
	}

	@After
	public void after() {
		session.close();
		System.out.println("after..");
	}

}
