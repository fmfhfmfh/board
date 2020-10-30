package board.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardVO;
import common.model.PageVO;

public class BoardServiceTest {
	
	BoardServiceI boardService;
	
	@Before
	public void setUp(){
		boardService = new BoardService();
	}
	
	@Test
	public void getBoardtest() {
		/***Given***/
		int board_no = 35;
		
		/***When***/
		BoardVO bv = boardService.getboard(board_no);
		
		/***Then***/
		assertEquals("테스트", bv.getBoard_title());
	}

	@Test
	public void selectAllBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVO> list = boardService.selectAllBoard();
		
		/***Then***/
		assertEquals(60, list.size());
		
	}
	
	@Test
	public void selectBoardPageList() {
		/***Given***/
		PageVO pv = new PageVO(1, 10, 1);
		
		/***When***/
		Map<String, Object> map = boardService.selectBoardPageList(pv);
		List<BoardVO> list = (List<BoardVO>) map.get("boardList");
		
		int pages = (int)map.get("pages");
		
		/***Then***/
		assertEquals(list.size(), 10);
		assertEquals(pages, 5);
	}
	
	
	
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVO bv = new BoardVO();
		String board_title = "테스트코드";
		String board_content = "테스트입니다"; 
		String board_del_check = "0";
		String user_id = "park";
		int board_type_no = 2;
		/***When***/
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		bv.setBoard_del_check(board_del_check);
		bv.setUser_id(user_id);
		bv.setBoard_type_no(board_type_no);
		
//		int cnt = boardService.insertBoard(bv);
		/***Then***/
		
//		assertEquals(cnt, 88);
	}
	
	@Test
	public void insertGBoardTest() {
		/***Given***/
		BoardVO bv = new BoardVO();
		String board_title = "G테스트코드";
		String board_content = "G테스트입니다"; 
		String board_del_check = "0";
		String user_id = "park";
		int board_group_no = 50;
		int board_type_no = 2;
		/***When***/
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		bv.setBoard_del_check(board_del_check);
		bv.setBoard_group_no(board_group_no);
		bv.setUser_id(user_id);
		bv.setBoard_type_no(board_type_no);
		
//		int cnt = boardService.insertGBoard(bv);
		/***Then***/
		
//		assertEquals(cnt, 88);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO bv = new BoardVO();
		int board_no = 88;
		bv = boardService.getboard(board_no);
		
		String board_title = "테스트코드수정";
		String board_content = "테스트입니다수정"; 
		
		/***When***/
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		
		
//		int cnt = boardService.updateBoard(bv);
//		
//		/***Then***/
//		
//		assertEquals(cnt, 1);
	}
	
	@Test
	public void deleteBoardTest() {
		/***Given***/
//		int board_no = 88;
	
		/***When***/
//		int cnt = boardService.deleteBoard(board_no);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
	}

}
