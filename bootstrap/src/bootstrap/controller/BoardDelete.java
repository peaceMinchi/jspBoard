package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.model.BoardDAO;

public class BoardDelete implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardDelete(board_num);
		
		String nextPage = null;
		if(cnt>0) {
			nextPage = "redirect:/bootstrap/board.do";
		}else {
			throw new ServletException("not delete");
		}
		return nextPage;
	}

}
