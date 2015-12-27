package com.kdyzm.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kdyzm.domain.Student;

public class MybatisDemo {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 第一个例子是根据id查询User对象 这里的password属性和数据库中的字段如果不一致，所以查询出来的结果是NULL
	 */
	@Test
	public void test1() {
		SqlSession session = sqlSessionFactory.openSession();
		Student student = session.selectOne("com.kdyzm.domain.Student.selectUserById", "1");
		System.out.println(student);
	}

	/**
	 * 第二个例子是查询所有User对象，最后以集合(List)的方式返回回来
	 */
	@Test
	public void selectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Collection<Student> students = sqlSession.selectList("com.kdyzm.domain.Student.selectAllStudent");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	/**
	 * 根据id查询User对象，返回值是Map对象
	 */
	@Test
	public void selectOneReturnMap() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.selectStudentByIdReturnMap";
		Map<Serializable, Serializable> student = session.selectOne(statement, 1);
		System.out.println(student);
	}

	/**
	 * 查询所有的User对象，返回值是List类型的对象，但是元素是Map类型的对象
	 */
	@Test
	public void selectAllStudentReturnListMap() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.selectAllStudentsReturnListMap";
		List<Map<Serializable, Serializable>> list = session.selectList(statement);
		for (Map<Serializable, Serializable> map : list) {
			System.out.println(map);
		}
	}

	/**
	 * 测试插入
	 */
	@Test
	public void testInsert() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.insertIntoStudent";
		Student student = new Student();
		student.setId(7);
		student.setName("张三");
		student.setAge(13);
		student.setPassword("xiaozhang");
		int result = session.insert(statement, student);
		session.commit();
		System.out.println(result);
	}

	/**************************************************************************/
	/**
	 * 测试删除方法
	 */
	@Test
	public void deleteById() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.deleteUserById";
		int result = session.delete(statement, 10);
		session.commit();
		System.out.println(result);
	}

	/**
	 * 测试根据Student对象更新的方法
	 */
	@Test
	public void updateStudentByStudentObject() {
		SqlSession session = sqlSessionFactory.openSession();
		String selectStatement = "com.kdyzm.domain.Student.selectUserById";
		Student student = session.selectOne(selectStatement, "1");
		student.setName("测试更新");
		String statement = "com.kdyzm.domain.Student.updateStudentByStudentObject";
		int result = session.update(statement, student);
		session.commit();
		System.out.println(result);
	}

	/**
	 * 测试update方法，但是传入的参数是Map对象
	 */
	@Test
	public void updateStudentByStudentMap() {
		SqlSession session = sqlSessionFactory.openSession();
		String selectStatement = "com.kdyzm.domain.Student.selectStudentByIdReturnMap";
		Map<Serializable, Serializable> student = session.selectOne(selectStatement, "1");
		System.out.println(student);
		student.put("name", "测试更新2");
		String statement = "com.kdyzm.domain.Student.updateStudentByStudentMap";
		int result = session.update(statement, student);
		session.commit();
		System.out.println(result);
	}

	/**************************** 下面是动态sql的测试 ***************************************************/
	/**
	 * 多条件查询在这里的使用方法
	 */
	@Test
	public void selectAllByCondition() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.selectAllByCondition";
		Student student = new Student();
		 student.setId(1);
		//		student.setAge(13);
		List<Student> list = session.selectList(statement, student);
		for (Student stu : list) {
			System.out.println(stu);
		}
	}

	/******************************
	 * 别名的使用方法，略
	 ******************************************/

	/*
	 * 动态sql的使用方法
	 */
	@Test
	public void updateStudentByCandition() {
		SqlSession session=sqlSessionFactory.openSession();
		Student student=new Student();
		student.setName("测试修改sjk");
		student.setId(1);
		int result=session.update("com.kdyzm.domain.Student.updateStudentByCandition", student);
		session.commit();
		System.out.println(result);
	}
}
