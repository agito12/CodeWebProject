package org.audgns.myapp.service;

import org.audgns.myapp.domain.MemberVO;

public interface MemberService {
	public String getNow();
	public void registMember(MemberVO vo);
	public MemberVO loadMember(String userid) throws Exception;
	public MemberVO loadWithPW(String userid, String userpw) throws Exception;
}
