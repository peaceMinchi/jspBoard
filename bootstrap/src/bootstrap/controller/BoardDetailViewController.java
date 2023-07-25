package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bootstrap.model.BoardDAO;
import bootstrap.model.BoardVO;

public class BoardDetailViewController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO dao = new BoardDAO();
		dao.boardCount(board_num); // 조회수 +1해주는 메서드
		
		BoardVO vo = dao.baordDetailView(board_num); // 기존에 보드출력 메서드
		request.setAttribute("vo", vo);
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");
		// 본인 작성한 게시물만 수정, 삭제 
		if(vo.getId() != null && sessionId != null && vo.getId().equals(sessionId)) {
			request.setAttribute("isMyBoard", "T");
		}
		
		return "boardDetailView";
	}

}
