package reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyInsertServlet
 */
@WebServlet("/replyInsert")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyServiceI replySerivce;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyInsertServlet.class);
	
	@Override
	public void init() throws ServletException {
		replySerivce = new ReplyService();
	}
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String reply_content = request.getParameter("reply_content");
		String user_id = request.getParameter("user_id");
	
		ReplyVO rv = new ReplyVO();
		
		rv.setBoard_no(board_no);
		rv.setReply_content(reply_content);
		rv.setUser_id(user_id);
		
		int cnt = replySerivce.insertReply(rv);
		
		request.setAttribute("rv", rv);
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/board?board_no="+board_no);
		}else {
			doGet(request, response);
		}
	}
}
