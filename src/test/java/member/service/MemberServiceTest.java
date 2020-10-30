package member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import member.model.MemberVO;

public class MemberServiceTest {
	
	MemberServiceI memberService = new MemberService();

	@Test
	public void getMemberTest() {
		/***Given***/
		String user_id = "park";
		
		/***When***/
		MemberVO mv = memberService.getMember(user_id);

		/***Then***/
		assertEquals(mv.getUser_name(), "박경호");
	}

}
