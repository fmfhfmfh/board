package files.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import files.controller.FilesUploadUtil;
import files.model.FilesVO;

public class FilesServiceTest {
	
	FilesServiceI filesService = new FilesService();
	
	@Test
	public void insertFilesTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"5.png\"";
		
		String real_files_name = FilesUploadUtil.getFileName(contentDisposition);
		String ext = FilesUploadUtil.getExtension(real_files_name);
		String fileName = UUID.randomUUID().toString();
		
		String filePath = "D:\\profile\\" + fileName + "." + ext;
		/***When***/
		FilesVO fv = new FilesVO();
		
		fv.setFiles_name(filePath);
		fv.setReal_files_name(real_files_name);
		fv.setBoard_no(67);
//		int cnt = filesService.insertFiles(fv);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
		
	}
	
	@Test
	public void getAllFilesTest() {
		/***Given***/
		int board_no = 67;
		
		/***When***/
		List<FilesVO> list = filesService.getAllFiles(board_no);
		
		/***Then***/
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void deleteFilesTest() {
		/***Given***/
//		int files_no = 21;
		
		/***When***/
//		int cnt = filesService.deleteFiles(files_no);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
	}


}
