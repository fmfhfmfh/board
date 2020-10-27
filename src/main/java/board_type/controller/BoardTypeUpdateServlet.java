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

@WebServlet("/boardTypeUpdate")
public class BoardTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardTypeServiceI boardTypeService;
	@Override
	public void init() throws ServletException {
		boardTypeService = new BoardTypeService();
	}
       
	private static final Logger logger = LoggerFactory.getLogger(BoardTypeUpdateServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board_TypeVO> btvList = boardTypeService.getBoardTypeList();
		
		request.setAttribute("btvList", btvList);
		
		request.getRequestDispatcher("/board/boardTypeInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_name = request.getParameter("board_name");
		String board_use_check = request.getParameter("board_use_check");
		
		
		int board_type_no = Integer.parseInt(request.getParameter("board_type_no"));
		
		Board_TypeVO btv = boardTypeService.selectBoardType(board_type_no);
		
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
		logger.debug("board_name : {}, board_del_check : {}, board_type_no : {}" , btv.getBoard_name(), btv.getBoard_use_check(), btv.getBoard_type_no());
		
		int cnt = boardTypeService.boardTypeUpdate(btv);
		
		logger.debug("cnt : {}", cnt);
		
		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/boardTypeInsert");
		}else {
			doGet(request, response);
		}
			
	}

}
