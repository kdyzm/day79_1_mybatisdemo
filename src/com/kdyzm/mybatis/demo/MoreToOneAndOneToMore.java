package com.kdyzm.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kdyzm.domain.Clazz;
import com.kdyzm.domain.Student;

/**
 * 测试一对多和多对一的关系在这里的使用方法
 * 
 * @author kdyzm
 *
 */
public class MoreToOneAndOneToMore {
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
	 * 测试多对一的关系在这里的配置方法
	 */
	@Test
	public void testMoreToOne() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Student.selectUserById";
		Student student = session.selectOne(statement, "1");
		System.out.println(student.getClazz());
	}

	/**
	 * 测试一对多关系在这里的实现方法 TODO 一定要注意，数据库中各个表中的主键字段不要重名，都使用id这个名称会造成严重的后果
	 */
	@Test
	public void selectClazzById() {
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "com.kdyzm.domain.Clazz.selectClazzById";
		Clazz clazz = session.selectOne(statement, "1");
		System.out.println(clazz);
		System.out.println(clazz.getStudents().size());
		List<Student> students = clazz.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
