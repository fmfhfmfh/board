package board.service;

import java.util.List;
import java.util.Map;

import board.model.BoardVO;
import common.model.PageVO;

public interface BoardServiceI {
	BoardVO getboard(int board_no);
	
	List<BoardVO> selectAllBoard();
	
	Map<String, Object> selectBoardPageList(PageVO pv);
	
	int insertBoard(BoardVO bv);
	
	int insertGBoard(BoardVO bv);
	
	int updateBoard(BoardVO bv);
	
	int deleteBoard(int board_no);
}
