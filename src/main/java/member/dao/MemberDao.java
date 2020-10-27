package member.dao;

import org.apache.ibatis.session.SqlSession;

import db.MybatisUtil;
import member.model.MemberVO;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String user_id) {
		SqlSession session = MybatisUtil.getSession();
		
		MemberVO memberVo = session.selectOne("member.getMember", user_id);
		
		session.close();
		
		return memberVo;
	}
}
