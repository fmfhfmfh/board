package board.controller;

import java.io.IOException;
import java.util.List;
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

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
    private BoardServiceI boardService;
    private FilesServiceI filesService;
    BoardVO bv;
    
    @Override
	public void init() throws ServletException {
    	boardService = new BoardService();
    	filesService = new FilesService();
    	bv = new BoardVO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		bv = boardService.getboard(board_no);
		List<FilesVO> list = filesService.getAllFiles(board_no);
		
		request.setAttribute("bv", bv);
		request.setAttribute("fv", list);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		logger.debug("board_title : {}, board_content : {}", board_title, board_content);
		
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		
		logger.debug("bv : {}", bv);
		
		int cnt = boardService.updateBoard(bv);
		
		int del_count = Integer.parseInt(request.getParameter("del_count"));
		
		for (int i = 1; i <= del_count; i++) {
			int del_files = Integer.parseInt(request.getParameter("del_files"+i));
			logger.debug("del_files : {}", del_files);
			filesService.deleteFiles(del_files);
		}
		
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
				fv.setBoard_no(board_no);
				filesService.insertFiles(fv);
			}
			
		}
		
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/board?board_no=" + bv.getBoard_no());
		}else {
			doGet(request, response);
		}
		
		
	}

}
