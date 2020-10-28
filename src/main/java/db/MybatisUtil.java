package db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 블럭을 통해 클래스가 로딩이 될때 mybatis 환경을 구성한다
	// ==> sqlSessionFactory
	static {
		String resource = "db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// sqlSessionFactory 객체를 통해 sqlSession 객체를 얻어내는 메서드
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
}
