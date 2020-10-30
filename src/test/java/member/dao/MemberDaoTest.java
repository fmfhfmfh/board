package member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import member.model.MemberVO;

public class MemberDaoTest {
	
	MemberDaoI memberDao = new MemberDao();
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String user_id = "park";
		
		/***When***/
		MemberVO mv = memberDao.getMember(user_id);

		/***Then***/
		assertEquals(mv.getUser_name(), "박경호");
	}

}
