package reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import reply.model.ReplyVO;

public class ReplyDaoTest {
	
	ReplyDaoI replyDao = new ReplyDao();
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		int board_no = 40;
		String reply_content = "테스트댓글";
		String user_id = "park";
		ReplyVO rv = new ReplyVO();
		/***When***/
		rv.setBoard_no(board_no);
		rv.setReply_content(reply_content);
		rv.setUser_id(user_id);
		
//		int cnt = replyDao.insertReply(rv);
//
//		/***Then***/
//		assertEquals(cnt, 1);
	}
	
	@Test
	public void getAllReplyTest() {
		/***Given***/
		int board_no = 40;
		
		/***When***/
		List<ReplyVO> list = replyDao.getAllReply(board_no);
		
		/***Then***/
		assertEquals(list.size(), 25);
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
//		int reply_no = 61;
		
		/***When***/
//		int cnt = replyDao.deleteReply(reply_no);
//		
//		/***Then***/
//		assertEquals(cnt, 1);
	}

}
