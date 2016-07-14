package org.audgns.myapp.persistence;

import org.audgns.myapp.domain.MemberVO;

public interface MemberDao {
	public String getTime();
	public void insertMember(MemberVO vo);
	public MemberVO readMember(String userid) throws Exception;
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
