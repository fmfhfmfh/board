package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVO;
import common.model.PageVO;
import db.MybatisUtil;
import member.model.MemberVO;

public class BoardDao implements BoardDaoI{

	@Override
	public BoardVO getboard(int board_no) {
		SqlSession session = MybatisUtil.getSession();
		
		BoardVO bv = session.selectOne("board.getBoard", board_no);
		
		session.close();
		
		return bv;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		SqlSession session = MybatisUtil.getSession();
		
		List<BoardVO> list = session.selectList("board.selectAllBoard");
		
		session.close();
		
		return list;
	}
	
	@Override
	public List<MemberVO> selectBoardPageList(SqlSession sqlSession, PageVO pv) {
		
		return sqlSession.selectList("board.selectBoardPageList", pv);
	}

	@Override
	public int selectBoardTotalCnt(SqlSession sqlSession, int board_type_no) {
		
		return sqlSession.selectOne("board.selectBoardTotalCnt", board_type_no);
	}

	@Override
	public int insertBoard(BoardVO bv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("board.insertBoard", bv);
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
	public int insertGBoard(BoardVO bv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("board.insertGBoard", bv);
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
	public int updateBoard(BoardVO bv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("board.updateBoard", bv);
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
	public int deleteBoard(int board_no) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("board.board_del_check", board_no);
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
