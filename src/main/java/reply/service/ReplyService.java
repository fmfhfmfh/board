package reply.service;

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

}
