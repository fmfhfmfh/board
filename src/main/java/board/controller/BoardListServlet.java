package board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceI;
import common.model.PageVO;


@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// page
				String page_str = request.getParameter("page");
				
				int page = page_str == null ? 1 : Integer.parseInt(page_str);
				
				request.setAttribute("page", page);
				
				// pageSize
				String pageSize_str = request.getParameter("pageSize");
				
				int pageSize = pageSize_str == null ? 10 : Integer.parseInt(pageSize_str);
				
				request.setAttribute("pageSize", pageSize);
				 
				int board_type_no = Integer.parseInt(request.getParameter("board"));
				
				request.setAttribute("board_type_no", board_type_no);
				
				// PageVO : page, pageSize
				PageVO pv = new PageVO(page, pageSize, board_type_no);
				
				// req.setAttribute("list", memberService.selectAllList());
				// memberService.selectMemberPageList(page) ==> List<MemberVO> ==> Map<String, Object>
				Map<String, Object> map = boardService.selectBoardPageList(pv);
				request.setAttribute("boardList", map.get("boardList"));
				request.setAttribute("pages", map.get("pages"));
				
				request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
