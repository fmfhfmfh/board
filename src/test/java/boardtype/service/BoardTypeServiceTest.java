package boardtype.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import board_type.model.Board_TypeVO;
import board_type.service.BoardTypeService;
import board_type.service.BoardTypeServiceI;

public class BoardTypeServiceTest {

	BoardTypeServiceI boardService = new BoardTypeService();
	
	@Test
	public void boardTypeInsertTest() {
		/***Given***/
		Board_TypeVO btv = new Board_TypeVO();
		String board_name = "테스트게시판";
		String board_use_check = "0";
		
		/***When***/
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
//		int cnt = boardService.boardTypeInsert(btv);
//
//		/***Then***/
//		assertEquals(cnt, 1);
	}
	
	@Test
	public void getBoardTypeListTest() {
		/***Given***/
		
		/***When***/
		List<Board_TypeVO> btvList = boardService.getBoardTypeList();
		
		/***Then***/
		assertEquals(btvList.size(), 19);
	}
	
	@Test
	public void boardTypeUpdateTest() {
		/***Given***/
		int board_type_no = 141;
		Board_TypeVO btv = boardService.selectBoardType(board_type_no);
		
		String board_name = "테스트게시판수정";
		String board_use_check = "1";
		
		/***When***/
		
		btv.setBoard_name(board_name);
		btv.setBoard_use_check(board_use_check);
		
		int cnt = boardService.boardTypeUpdate(btv);
		
		/***Then***/
		assertEquals(cnt, 1);
	}

}
