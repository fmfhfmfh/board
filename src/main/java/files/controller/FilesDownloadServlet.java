package files.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import files.model.FilesVO;
import files.service.FilesService;
import files.service.FilesServiceI;

@WebServlet("/fileDownload")
public class FilesDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilesServiceI filesService;
	private static final Logger logger = LoggerFactory.getLogger(FilesDownloadServlet.class);
	
	@Override
	public void init() throws ServletException {
		filesService = new FilesService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileInputStream fis;
		ServletOutputStream sos;
		// 사용자 아이디 파라미터 확인하고
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int files_no = Integer.parseInt(request.getParameter("files_no"));
		
		// db에서 사용자 filename 확인
		List<FilesVO> list = filesService.getAllFiles(board_no);
		
		for (int i = 0; i < list.size(); i++) {
			if(files_no == list.get(i).getFiles_no()) {
				// response context-type 설정
				response.setHeader("Content-Disposition", "attachment; filename=\""+list.get(i).getReal_files_name()+"\"");
				response.setContentType("application/octet-stream");
				
				// 경로 확인 후 파일 입출력을 통해 응답생성
				// 파일 읽기
				// 응답 생성
				// 파일 경로
				fis = new FileInputStream(list.get(i).getFiles_name());
				sos = response.getOutputStream();
				
				byte[] buffer = new byte[512];
				
				while(fis.read(buffer) != -1) {
					sos.write(buffer);
				}
				fis.close();
				sos.flush();
				sos.close();
			}
		}
	}
}
