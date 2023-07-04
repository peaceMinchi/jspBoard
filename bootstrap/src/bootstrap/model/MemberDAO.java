package bootstrap.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	// 초기화 블럭 - 프로그램 실행시 딱 한번만 실행되는 코드영역 을 static block이라고 한다.
	static {
		try {
				String resource = "bootstrap/mybatis/config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource); // 읽어오기
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // ConnectionPool만들기
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	// 회원가입 (insert)
	public int memberInsert(MemberVO vo) {
		SqlSession session=sqlSessionFactory.openSession();
		int cnt=session.insert("memberInsert", vo);
		   session.commit();
		   session.close();//반납
		   return cnt;
	}

	public String memberLogin(MemberVO vo) {
		SqlSession session=sqlSessionFactory.openSession();
		String name = session.selectOne("memberLogin", vo);
		session.close();
		return name;
	}
	
	
	
}
