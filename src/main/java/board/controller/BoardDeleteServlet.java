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


@WebServlet("/boardDelete")
@MultipartConfig
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDeleteServlet.class);
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
		
		request.getRequestDispatcher("/board/boardDelete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int board_no = bv.getBoard_no();
		
		logger.debug("board_no : {}", board_no);
		
		int cnt = boardService.deleteBoard(board_no);
		
		logger.debug("cnt : {}", cnt);
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardList?board=" + bv.getBoard_type_no());
		}else {
			doGet(request, response);
		}
		
		
	}

}
