package org.audgns.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.audgns.myapp.domain.MemberVO;
import org.audgns.myapp.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String memberLoginGet() {
		return "/member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPost(String userid, String userpw, HttpServletRequest req) {
		// logger.info(userid + ", " + userpw);
		try {
			MemberVO vo = memberService.loadWithPW(userid, userpw);
			WebUtils.setSessionAttribute(req, "USER_KEY", vo);
		} catch (Exception e) {
			logger.error("memberLoginPost : " + e);
			return "/member/login";
		}
		return "redirect:/";
	}

	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}
}
