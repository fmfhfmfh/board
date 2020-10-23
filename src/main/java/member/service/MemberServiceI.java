package member.service;

import java.util.List;
import java.util.Map;

import common.model.PageVO;
import member.model.MemberVO;

public interface MemberServiceI {
	MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	Map<String, Object> selectMemberPageList(PageVO pv);
	
	int insertMember(MemberVO mv);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO mv);
}
