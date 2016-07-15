package org.audgns.myapp.service;

import javax.inject.Inject;

import org.audgns.myapp.domain.MemberVO;
import org.audgns.myapp.persistence.MemberDao;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDao memberDao;

	@Override
	public String getNow() {
		memberDao.getTime();
		return null;
	}

	@Override
	public void registMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}

	@Override
	public MemberVO loadMember(String userid) throws Exception {
		return memberDao.readMember(userid);
	}

	@Override
	public MemberVO loadWithPW(String userid, String userpw) throws Exception {
		return memberDao.readWithPW(userid, userpw);
	}
}
