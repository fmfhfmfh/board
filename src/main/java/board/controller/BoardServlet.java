package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceI;
import files.model.FilesVO;
import files.service.FilesService;
import files.service.FilesServiceI;
import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceI;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;
	private ReplyServiceI replyService;
	private FilesServiceI filesService;
	
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		replyService = new ReplyService();
		filesService = new FilesService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardVO bv = boardService.getboard(board_no);
		List<ReplyVO> rv = replyService.getAllReply(board_no);
		List<FilesVO> fv = filesService.getAllFiles(board_no);
		
		request.setAttribute("bv", bv);
		request.setAttribute("rv", rv);
		request.setAttribute("fv", fv);
		
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

}
