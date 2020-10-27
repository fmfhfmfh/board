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

@WebServlet("/boardTypeList")
public class BoardTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(BoardTypeListServlet.class);
	BoardTypeService boardTypeService;	
	
	
	@Override
	public void init() throws ServletException {
		boardTypeService = new BoardTypeService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board_TypeVO> btvList = boardTypeService.getBoardTypeList();
		
		request.getSession().setAttribute("btvList", btvList);
		
		request.getRequestDispatcher("").forward(request, response);
	}
}
