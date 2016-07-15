package org.audgns.myapp.util;

import javax.inject.Inject;

import org.audgns.myapp.domain.MemberVO;
import org.audgns.myapp.persistence.MemberDao;
import org.audgns.myapp.persistence.MemberDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidation implements Validator{
	@Inject
	MemberDao memberDao = new MemberDaoImpl();
	
	private static final Logger logger = LoggerFactory.getLogger(MemberValidation.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
//		logger.info("MembersValidation.support : " + MemberVO.class.isAssignableFrom(clazz));
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
//		logger.info("MembersValidation.validate : called");
		MemberVO member = (MemberVO)obj;
		logger.info("Validation : " + member.getUserid() + ", " + member.getUserpw());
		
		if(member.getUserid() == null || member.getUserid().trim().isEmpty()) {
//			logger.info("MembersValidation.validate : userId error");
			error.rejectValue("userid", "required");
		}
		if(member.getUserpw() == null || member.getUserpw().trim().isEmpty()) {
//			logger.info("MembersValidation.validate : userpw error");
			error.rejectValue("userpw", "required");
		}
		
		try{
			logger.info("dao : " + memberDao);
//			MemberVO vo = memberDao.readWithPW(member.getUserid(), member.getUserpw());
		} catch(Exception e) {
			e.printStackTrace();
			error.reject("login");
		}
	}
}
