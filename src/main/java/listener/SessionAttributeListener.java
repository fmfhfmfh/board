package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import member.model.MemberVO;


public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	//			userId  MemberVO
	private Map<String, MemberVO> userMap = new HashMap<String, MemberVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
//			HttpSession session = event.getSession();
//			MemberVO mv = (MemberVO) session.getAttribute("S_MEMBER");
			
			MemberVO mv = (MemberVO) event.getValue();
			logger.debug("사용자 로그인 : {}", mv.getUser_id());
			
			userMap.put(mv.getUser_id(), mv);
			
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved : {}", event.getName());
		if("S_MEMBER".equals(event.getName())) {
			MemberVO mv = (MemberVO) event.getValue();
			userMap.remove(mv.getUser_id());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}
}
