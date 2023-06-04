package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		return "boardDetailView";
	}

}
