package bootstrap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bootstrap.model.MemberDAO;
import bootstrap.model.MemberVO;

public class MemberLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx=request.getContextPath(); // 컨텍스트 값. 
		
		// 넘어오는 아이디 패스워드 받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		
		MemberDAO dao = new MemberDAO();
		String name = dao.memberLogin(vo);
		// name에 값이 있으면 인증에 성공한 것이고, name에 값이 없으면 회원인증이 실패한 것.
		
		if(name != null && !"".equals(name)) {
//			request.getSession().setAttribute("userId", user_id);
//			request.getSession().setAttribute("userName", user_name);
			
			// 위에 있는 걸 이런식으로도 사용이 가능
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
//			session.setAttribute("msg", "환영합니다!");
		}else {
			//실패
			request.getSession().setAttribute("id", "");
			request.getSession().setAttribute("name", "");
			request.getSession().setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
		return "redirect:"+ctx+"/board.do";
	}

}
