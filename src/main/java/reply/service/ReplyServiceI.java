package reply.service;

import java.util.List;

import reply.model.ReplyVO;

public interface ReplyServiceI {
	int insertReply(ReplyVO rv);
	
	List<ReplyVO> getAllReply(int board_no);
	
	int deleteReply(int reply_no);
}
