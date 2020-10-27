package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceI;

@WebServlet("/boardInsert")
@MultipartConfig
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardInsertServlet.class);
	private BoardServiceI boardService;
	BoardVO bv;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int board_type_no = Integer.parseInt(request.getParameter("board"));
		
		logger.debug("no : {}" , board_type_no);
		
		request.setAttribute("board_type_no", board_type_no);
		
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_del_check = request.getParameter("board_del_check");
		String user_id =request.getParameter("user_id");
		int board_type_no = Integer.parseInt(request.getParameter("board_type_no"));
		
		bv = new BoardVO();
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		bv.setUser_id(user_id);
		bv.setBoard_del_check(board_del_check);
		bv.setBoard_type_no(board_type_no);
		
		logger.debug("bv : {}", bv);
		
		int cnt = boardService.insertBoard(bv);
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardList?board="+board_type_no);
		}else {
			doGet(request, response);
		}
		
	
		
	}
}
