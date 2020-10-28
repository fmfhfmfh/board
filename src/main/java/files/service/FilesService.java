package files.service;

import java.util.List;

import files.dao.FilesDao;
import files.dao.FilesDaoI;
import files.model.FilesVO;

public class FilesService implements FilesServiceI {

	private FilesDaoI filesDao;
	
	public FilesService() {
		filesDao = new FilesDao();
	}
	
	@Override
	public int insertFiles(FilesVO fv) {
		return filesDao.insertFiles(fv);
	}

	@Override
	public List<FilesVO> getAllFiles(int board_no) {
		return filesDao.getAllFiles(board_no);
	}

	@Override
	public int deleteFiles(int files_no) {
		return filesDao.deleteFiles(files_no);
	}

}
