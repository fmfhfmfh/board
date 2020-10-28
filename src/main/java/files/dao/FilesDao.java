package files.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisUtil;
import files.model.FilesVO;

public class FilesDao implements FilesDaoI {

	@Override
	public int insertFiles(FilesVO fv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("files.insertFiles",fv);
		} catch (Exception e) {

		}
		
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		
		return cnt;
	}

	@Override
	public List<FilesVO> getAllFiles(int board_no) {
		SqlSession session = MybatisUtil.getSession();
		
		List<FilesVO> list = session.selectList("files.getAllFiles", board_no);
		
		session.close();
		
		return list;
	}

	@Override
	public int deleteFiles(int files_no) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("files.deleteFiles", files_no);
		} catch (Exception e) {

		}
		
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		
		return cnt;
		
	}
}
