package board_type.dao;

import java.util.List;

import board_type.model.Board_TypeVO;

public interface BoardTypeDaoI {
	int boardTypeInsert(Board_TypeVO btv);
	
	List<Board_TypeVO> getBoardTypeList();
	
	Board_TypeVO selectBoardType(int board_type_no);
	
	int boardTypeUpdate(Board_TypeVO btv);
}
