package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board_type.model.Board_TypeVO;
import board_type.service.BoardTypeService;
import board_type.service.BoardTypeServiceI;
import member.model.MemberVO;
import member.service.MemberService;
import member.service.MemberServiceI;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private MemberServiceI memberService;
	private BoardTypeServiceI boardTypeService;

	
	@Override
	public void init() throws ServletException {
		// service 객체 생성
		memberService = new MemberService();
		boardTypeService = new BoardTypeService(); 
		
	}
	
	
	
	// login 화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet doGet");
		logger.debug("UNT_CD parameter : {}", request.getParameter("UNT_CD"));
		request.getRequestDispatcher("/home/login.jsp").forward(request, response);
	}

	// login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		List<Board_TypeVO> btvList = boardTypeService.getBoardTypeList();
		
		logger.debug("userId : {}, password : {}", user_id, password);
		
		MemberVO memberVo = memberService.getMember(user_id);
		
		// db에 등록된 회원이 없거나 비밀번호가 틀린 경우(login page)
		if(memberVo == null || !memberVo.getPassword().equals(password)) {
			request.getRequestDispatcher("/home/login.jsp").forward(request, response);
		}
		// 비밀번호가 일치하는 경우(main page)
		else if(memberVo.getPassword().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memberVo);
			request.getSession().setAttribute("btvList", btvList);
		
			request.getRequestDispatcher("/home/main.jsp").forward(request, response);
		}
		
		
		
//		//쿠키 정보
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			logger.debug("name : {}, value : {}", cookie.getName(), cookie.getValue());
//			
//		}
//		
//		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
//		cookie.setMaxAge(60*60*24);
//		
//		response.addCookie(cookie);
	}
}


