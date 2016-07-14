package org.audgns.myapp.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.audgns.myapp.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.audgns.mappers.memberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime"); 
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		MemberVO vo = sqlSession.selectOne(NAMESPACE + ".readMember", userid);
		return vo;
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		MemberVO vo = sqlSession.selectOne(NAMESPACE + ".readWithPW", paramMap);
		return vo;
	}
}
