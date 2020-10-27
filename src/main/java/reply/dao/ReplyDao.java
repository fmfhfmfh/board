package reply.dao;

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

}
