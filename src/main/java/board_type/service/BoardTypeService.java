package board_type.service;

import java.util.List;
import java.util.Map;

import board_type.dao.BoardTypeDao;
import board_type.dao.BoardTypeDaoI;
import board_type.model.Board_TypeVO;

public class BoardTypeService implements BoardTypeServiceI{

	private BoardTypeDaoI boardTypeDao;
	
	public BoardTypeService() {
		boardTypeDao = new BoardTypeDao();
	}
	
	@Override
	public int boardTypeInsert(Board_TypeVO btv) {
		return boardTypeDao.boardTypeInsert(btv);
	}

	@Override
	public List<Board_TypeVO> getBoardTypeList() {
		return boardTypeDao.getBoardTypeList();
	}

	@Override
	public Board_TypeVO selectBoardType(int board_type_no) {
		return boardTypeDao.selectBoardType(board_type_no);
	}

	@Override
	public int boardTypeUpdate(Board_TypeVO btv) {
		return boardTypeDao.boardTypeUpdate(btv);
	}
	
}
