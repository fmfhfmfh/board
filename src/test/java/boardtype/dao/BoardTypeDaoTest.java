package boardtype.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import board_type.dao.BoardTypeDao;
import board_type.dao.BoardTypeDaoI;
import board_type.model.Board_TypeVO;

public class BoardTypeDaoTest {

	BoardTypeDaoI boardTypeDao = new BoardTypeDao();
	
	@Test
	public void boardTypeInsertTest() {
		/***Given***/
		Board_TypeVO btv = new Board_TypeVO();
		String board_name = "테스트게시판";
		String board_use_check = "0";
		
		/***When***/
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
//		int cnt = boardTypeDao.boardTypeInsert(btv);
//
//		/***Then***/
//		assertEquals(cnt, 1);
	}
	
	@Test
	public void getBoardTypeListTest() {
		/***Given***/
		
		/***When***/
		List<Board_TypeVO> btvList = boardTypeDao.getBoardTypeList();
		
		/***Then***/
		assertEquals(btvList.size(), 19);
	}
	
	@Test
	public void boardTypeUpdateTest() {
		/***Given***/
		int board_type_no = 141;
		Board_TypeVO btv = boardTypeDao.selectBoardType(board_type_no);
		
		String board_name = "테스트게시판수정";
		String board_use_check = "1";
		
		/***When***/
		
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
		int cnt = boardTypeDao.boardTypeUpdate(btv);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	
	
	
}
