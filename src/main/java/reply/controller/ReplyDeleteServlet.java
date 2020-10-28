package reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reply.service.ReplyService;
import reply.service.ReplyServiceI;

@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyServiceI replyService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyDeleteServlet.class);
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		int cnt = replyService.deleteReply(reply_no);
		
		logger.debug("cnt : {}", cnt);
		
		response.sendRedirect(request.getContextPath() + "/board?board_no="+board_no);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
