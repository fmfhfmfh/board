package member.service;

import member.model.MemberVO;

public interface MemberServiceI {
	MemberVO getMember(String user_id);
	
}
