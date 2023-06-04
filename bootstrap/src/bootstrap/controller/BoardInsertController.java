package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.model.BoardDAO;
import bootstrap.model.BoardVO;

public class BoardInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		BoardVO vo = new BoardVO(title, content, id);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardInsert(vo);
		
		String nextPage = null;
		if(cnt>0) {
			nextPage = "redirect:"+ctx+"/board.do";
		}else {
			throw new ServletException("not insert");	    
		}
		
		return nextPage;
	}

}
