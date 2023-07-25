package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.model.BoardDAO;
import bootstrap.model.BoardVO;

public class BoardUpdateView implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		int view_cnt = Integer.parseInt(request.getParameter("view_cnt"));
//		int rownum = Integer.parseInt(request.getParameter("rownum"));
		
		BoardVO vo = new BoardVO(board_num, title, content, id, date, view_cnt);
		request.setAttribute("vo", vo);
		
		return "boardUpdate";
	}

}
