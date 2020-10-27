package board_type.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board_type.model.Board_TypeVO;
import db.MybatisUtil;

public class BoardTypeDao implements BoardTypeDaoI {

	private static final Logger logger = LoggerFactory.getLogger(BoardTypeDao.class);
	@Override
	public int boardTypeInsert(Board_TypeVO btv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("board_type.board_type_insert", btv);
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
	public List<Board_TypeVO> getBoardTypeList() {
		SqlSession session = MybatisUtil.getSession();
		
		List<Board_TypeVO> list = session.selectList("board_type.get_board_type");
		
		session.close();
		
		return list;
	}
	@Override
	public Board_TypeVO selectBoardType(int board_type_no) {
		SqlSession session = MybatisUtil.getSession();
		
		Board_TypeVO btv = session.selectOne("board_type.select_board_type", board_type_no);
		
		session.close();
		
		return btv;
	}
	@Override
	public int boardTypeUpdate(Board_TypeVO btv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		try {
			cnt = session.update("board_type.board_type_update", btv);
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
