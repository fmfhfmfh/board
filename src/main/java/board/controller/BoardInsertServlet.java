package board.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceI;
import files.controller.FilesUploadUtil;
import files.model.FilesVO;
import files.service.FilesService;
import files.service.FilesServiceI;

@WebServlet("/boardInsert")
@MultipartConfig
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardInsertServlet.class);
	private BoardServiceI boardService;
	private FilesServiceI filesService;
	BoardVO bv;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		filesService = new FilesService();
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
		
		int count = Integer.parseInt(request.getParameter("count"));
		
		for(int i = 1; i <= count; i++) {
			
			Part files = request.getPart("realfilename"+i);
			
			String real_files_name = FilesUploadUtil.getFileName(files.getHeader("Content-Disposition"));
			String ext = FilesUploadUtil.getExtension(real_files_name);
			String fileName = UUID.randomUUID().toString();
			String filePath = "";
			
			
			if (files.getSize() > 0) {
				filePath = "D:\\profile\\" + fileName + "." + ext;
				files.write(filePath);
				
				FilesVO fv = new FilesVO();
				
				fv.setFiles_name(filePath);
				fv.setReal_files_name(real_files_name);
				fv.setBoard_no(cnt);
				filesService.insertFiles(fv);
			}
			
		}
		if(cnt > 0) {
			response.sendRedirect(request.getContextPath() + "/boardList?board="+board_type_no);
		}else {
			doGet(request, response);
		}
		
	}
}
