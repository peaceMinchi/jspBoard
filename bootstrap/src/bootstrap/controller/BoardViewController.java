package bootstrap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.model.BoardDAO;
import bootstrap.model.BoardVO;
import bootstrap.model.PageVO;
public class BoardViewController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// POJO가 해야할 일의 범위.
		// 1. Model 연동
		// 2. 객체바인딩
		// 3. 다음페이지정보 (view)
		String searchKey = request.getParameter("searchKey"); // 검색어
		String keyword = request.getParameter("keyword"); // 검색(제목, 내용, 작성자)
		
		int currentPage = 1; // = pageNum (페이지 접속 했을때 기본을 1로 설정)
		if (request.getParameter("p") != null) {
			currentPage = Integer.parseInt(request.getParameter("p"));
		}

		BoardDAO dao = new BoardDAO();
		PageVO pageVO = new PageVO();
		pageVO.setSearchKey(searchKey);
		pageVO.setKeyword(keyword);
		
		int totalCount = dao.boardListTotalCount(pageVO);
		pageVO.setPageNum(currentPage);
		pageVO.setTotalCount(totalCount);
		pageVO.setPageVO();
		
		List<BoardVO> list = dao.boardList(pageVO);
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageVO", pageVO);
		
		return "home";
	}

}
  