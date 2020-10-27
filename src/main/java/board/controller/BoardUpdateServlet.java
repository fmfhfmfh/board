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

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
    private BoardServiceI boardService;
    BoardVO bv;
    
    @Override
	public void init() throws ServletException {
    	boardService = new BoardService();
    	bv = new BoardVO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		bv = boardService.getboard(board_no);
		
		request.setAttribute("bv", bv);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		logger.debug("board_title : {}, board_content : {}", board_title, board_content);
		
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		
		logger.debug("bv : {}", bv);
		
		int cnt = boardService.updateBoard(bv);
		
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/board?board_no=" + bv.getBoard_no());
		}else {
			doGet(request, response);
		}
		
		
	}

}
