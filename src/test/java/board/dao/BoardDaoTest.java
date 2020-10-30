package board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import board.model.BoardVO;
import common.model.PageVO;
import db.MybatisUtil;

public class BoardDaoTest {
	
	
	BoardDaoI boardDao = new BoardDao();
	
//	@Before
//	public void setUp() {
//		BoardDaoI boardDao = new BoardDao();
//		int board_no = 35;
//		
//		boardDao.deleteBoard(board_no);
//	}
	
	
	
	
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
		assertEquals(60, list.size());
		
	}
	
	@Test
	public void selectBoardPageListTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSession();
		
		PageVO pv = new PageVO(1, 10, 1);
		// int page = 1;

		/***When***/
		List<BoardVO> list = boardDao.selectBoardPageList(sqlSession, pv);
		
		/***Then***/
		assertEquals(list.size(), 7);
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSession();
		int board_type_no = 1;
		
		/***When***/
		int cnt = boardDao.selectBoardTotalCnt(sqlSession, board_type_no);
		
		/***Then***/
		assertEquals(cnt, 44);
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
		
//		int cnt = boardDao.insertBoard(bv);
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
		
//		int cnt = boardDao.insertGBoard(bv);
		/***Then***/
		
//		assertEquals(cnt, 88);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO bv = new BoardVO();
		int board_no = 88;
		bv = boardDao.getboard(board_no);
		
		String board_title = "테스트코드수정";
		String board_content = "테스트입니다수정"; 
		
		/***When***/
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		
		
//		int cnt = boardDao.updateBoard(bv);
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
//		int cnt = boardDao.deleteBoard(board_no);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
	}

}
