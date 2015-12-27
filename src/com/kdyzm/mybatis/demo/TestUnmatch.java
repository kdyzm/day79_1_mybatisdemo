package com.kdyzm.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kdyzm.domain.Person;

/**
 * 当数据库中的表的字段和类中的字段名称不匹配的时候的解决方案
 * @author kdyzm
 *
 */
public class TestUnmatch {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 第一种解决方案，那就是修改sql语句，给字段起别名
	 */
	@Test
	public void testFirst(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.kdyzm.domain.Person.selectAllPerson";
		List<Person> list=session.selectList(statement);
		for(Person person:list){
			System.out.println(person);
		}
	}
	
	/**
	 * 测试第二种解决方案，修改配置文件，使用的方式和在hibernate中使用的方式差不多
	 */
	@Test
	public void testTwo(){
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.kdyzm.domain.Person.selectAllPerson2";
		List<Person> list=session.selectList(statement);
		for(Person person:list){
			System.out.println(person);
		}
	}
}
