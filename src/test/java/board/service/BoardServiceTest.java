package board.service;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import board.model.BoardVO;
import db.MybatisUtil;

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

}
