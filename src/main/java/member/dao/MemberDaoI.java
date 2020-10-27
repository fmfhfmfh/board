package member.dao;

import member.model.MemberVO;

public interface MemberDaoI {
	MemberVO getMember(String user_id);
}
