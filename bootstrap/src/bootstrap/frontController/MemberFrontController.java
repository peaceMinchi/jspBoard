package bootstrap.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bootstrap.controller.Controller;

@WebServlet("*.do") // 확장자가 .do로 끝나는 모든 요청을 여기로 받게끔.
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1) 클라이언트가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI();
		//System.out.println(url);
		
		// 컨텍스트 패스만 가지고 오기. MVC04
		String ctx = request.getContextPath();
		//System.out.println(ctx);
		
		// MVC04 빼고 뒤에 주소만 가지고 오기. 컨텍스트패스 길이를 빼서 가지고 오기
		String command = url.substring(ctx.length());
		System.out.println(command);
		
		// 요청에 따른 분기 작업. 여기서 요청한걸 찾아서 작업한다. 
		Controller controller = null;
		String nextPage = null;
		
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(request, response); // 여기서 POJO불러옴.
			
		// forward, redirect 구별
		if(nextPage!=null) {
			if(nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
	}
}
