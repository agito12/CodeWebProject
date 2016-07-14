package org.audgns.myapp;

import javax.inject.Inject;

import org.audgns.myapp.domain.MemberVO;
import org.audgns.myapp.persistence.MemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberDaoTest {
	@Inject
	private MemberDao memberDao;
	
	@Test
	public void testGetTime() {
		System.out.println("현재 DB시간 : " + memberDao.getTime());
	}
	
	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("1111");
		vo.setUsername("테스트");
		vo.setEmail("user00@aaa.com");
		
		memberDao.insertMember(vo);
	}
	
	@Test
	public void testReadMember() {
		try {
			MemberVO vo = memberDao.readMember("user00");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadWithPW() {
		try {
			MemberVO vo = memberDao.readWithPW("user00", "1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
