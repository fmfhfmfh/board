package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.dao.BoardDao;
import board.dao.BoardDaoI;
import board.model.BoardVO;
import common.model.PageVO;
import db.MybatisUtil;

public class BoardService implements BoardServiceI{

	private BoardDaoI boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	@Override
	public BoardVO getboard(int board_no) {
		return boardDao.getboard(board_no);
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	@Override
	public Map<String, Object> selectBoardPageList(PageVO pv) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardDao.selectBoardPageList(sqlSession, pv));
		
		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		int cnt = boardDao.selectBoardTotalCnt(sqlSession, pv.getBoard_type_no());
		
		int pages =(int) Math.ceil((double)cnt/10);
		
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return boardDao.insertBoard(bv);
	}
	@Override
	public int insertGBoard(BoardVO bv) {
		return boardDao.insertGBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deleteBoard(int board_no) {
		return boardDao.deleteBoard(board_no);
	}
}
