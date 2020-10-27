package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVO;
import common.model.PageVO;
import member.model.MemberVO;

public interface BoardDaoI {
	BoardVO getboard(int board_no);
	
	List<BoardVO> selectAllBoard();
	
	List<MemberVO> selectBoardPageList(SqlSession sqlSession, PageVO pv);
	
	int selectBoardTotalCnt(SqlSession sqlSession, int board_type_no);
	
	int insertBoard(BoardVO bv);
	
	int insertGBoard(BoardVO bv);
	
	int updateBoard(BoardVO bv);

	int deleteBoard(int board_no);
}
