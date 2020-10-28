package files.dao;

import java.util.List;

import files.model.FilesVO;

public interface FilesDaoI {
	int insertFiles(FilesVO fv);
	
	List<FilesVO> getAllFiles(int board_no);
	
	int deleteFiles(int files_no);
}
