package member.service;

import member.dao.MemberDao;
import member.dao.MemberDaoI;
import member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
	

	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String user_id) {

		return memberDao.getMember(user_id);
	}

	

//	@Override
//	public Map<String, Object> selectMemberPageList(PageVO pv) {
//		
//		SqlSession sqlSession = MybatisUtil.getSession();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("memberList", memberDao.selectMemberPageList(sqlSession, pv));
//		
//		// 15건, 페이지사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
//		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
//		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
//		
//		int pages =(int) Math.ceil((double)cnt/7);
//		
//		map.put("pages", pages);
//		
//		sqlSession.close();
//		return map;
//	}

	
}
