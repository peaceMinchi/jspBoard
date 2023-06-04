package bootstrap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.model.BoardDAO;
import bootstrap.model.BoardVO;

public class BoardViewController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// POJO가 해야할 일의 범위.
		// 1. Model 연동
		// 2. 객체바인딩
		// 3. 다음페이지정보 (view)
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.boardList();
//		int boardTotal = dao.boardTotal();
		request.setAttribute("list", list);

		
		return "home";
	}

}
  