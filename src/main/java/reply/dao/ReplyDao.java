package reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisUtil;
import reply.model.ReplyVO;

public class ReplyDao implements ReplyDaoI {

	@Override
	public int insertReply(ReplyVO rv) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("reply.insertReply", rv);
		} catch (Exception e) {
			
		}
		
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		
		return cnt;
	}

	@Override
	public List<ReplyVO> getAllReply(int board_no) {
		SqlSession session = MybatisUtil.getSession();
		
		List<ReplyVO> list = session.selectList("reply.getAllReply", board_no);
		
		session.close();
		
		return list;
	}

	@Override
	public int deleteReply(int reply_no) {
		SqlSession session = MybatisUtil.getSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("reply.deleteReply",reply_no);
		} catch (Exception e) {

		}
		
		if(cnt == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		
		return cnt;
	}

}
