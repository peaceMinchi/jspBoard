package bootstrap.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private static SqlSessionFactory sqlSessionFactory; // 여기 안에 COnnection들이 들어있음.
	
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
	// 게시판전체 리스트보기
	public List<BoardVO> boardList(PageVO pageVO){
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("boardList", pageVO);
		session.close();
		return list;
	}
	
	// 게시판 데이터 전부 가지고 오기
	public int boardListTotalCount() {
		SqlSession session = sqlSessionFactory.openSession();
		int totalCount = session.selectOne("boardListTotalCount");
		session.close();
		return totalCount;
	}

	// 게시판 글 작성(insert)
	public int boardInsert(BoardVO vo) {
		// Connection + Statement 기능을 합쳐둔게 SqlSession이라고 보면 됨.
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("boardInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	// 게시판 상세정보
	public BoardVO baordDetailView(int board_num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVO vo = session.selectOne("boardDetailView", board_num);
		session.close();
		return vo;
	}
	
	// 게시판 삭제
	public int boardDelete(int board_num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("boardDelete", board_num);
		session.commit();
		session.close();
		return cnt;
	}
	
	// 게시판 수정
	public int boardUpdate(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("boardUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	// 조회수 카운트
	public void boardCount(int board_num) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("boardCount", board_num);
		session.commit();
		session.close();
	}

//	public int boardTotal() {
//		SqlSession session = sqlSessionFactory.openSession();
//		int boardTotal = session.select("boardTotal");
//		return 0;
//	}

	
}
