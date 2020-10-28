package board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import board.model.BoardVO;

public class BoardDaoTest {
	
	BoardDaoI boardDao = new BoardDao();
	
	
	@Test
	public void getBoardTest() {
		/***Given***/
		int board_no = 35;
		
		/***When***/
		BoardVO bv = boardDao.getboard(board_no);
		
		/***Then***/
		assertEquals("테스트", bv.getBoard_title());
	}
	
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVO> list = boardDao.selectAllBoard();
		
		/***Then***/
		assertNotNull(list);
	}

}
