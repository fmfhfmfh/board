package board_type.controller;

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

@WebServlet("/boardTypeInsert")
public class BoardTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardTypeServiceI boardTypeService;
	@Override
	public void init() throws ServletException {
		boardTypeService = new BoardTypeService();
	}
       
	private static final Logger logger = LoggerFactory.getLogger(BoardTypeInsertServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board_TypeVO> btvList = boardTypeService.getBoardTypeList();
		
		request.getSession().setAttribute("btvList", btvList);
		
		request.getRequestDispatcher("/board/boardTypeInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_name = request.getParameter("board_name");
		String board_use_check = request.getParameter("board_use_check");
		
		Board_TypeVO btv = new Board_TypeVO();
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
		logger.debug("board_name : {}, board_del_check : {}", btv.getBoard_name(), btv.getBoard_use_check());
		
		int cnt = boardTypeService.boardTypeInsert(btv);
		
		logger.debug("cnt : {}", cnt);
		
		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardTypeInsert");
		}else {
			doGet(request, response);
		}
			
	}

}
