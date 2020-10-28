package reply.service;

import java.util.List;

import reply.dao.ReplyDao;
import reply.dao.ReplyDaoI;
import reply.model.ReplyVO;

public class ReplyService implements ReplyServiceI {
	
	private ReplyDaoI replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	
	@Override
	public int insertReply(ReplyVO rv) {
		return replyDao.insertReply(rv);
	}

	@Override
	public List<ReplyVO> getAllReply(int board_no) {
		return replyDao.getAllReply(board_no);
	}

	@Override
	public int deleteReply(int reply_no) {
		return replyDao.deleteReply(reply_no);
	}

}
