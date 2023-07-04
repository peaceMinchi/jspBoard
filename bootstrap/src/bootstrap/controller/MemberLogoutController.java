package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 현제 세션을 가져와서 세션을 제거 하면 됨.
		// 세션을 제거하는 방법
		// 1. 강제로 하는방
		request.getSession().invalidate();
		String ctx = request.getContextPath();
				
				// 2. 브라우저를 종료 하는 방법.
				
				// 3. 세션이 종료될때 까지 기다리는 방법.(세션타임아웃 : 30분 = 1800초)
				return "redirect:"+ctx+"/board.do";
	}

}
