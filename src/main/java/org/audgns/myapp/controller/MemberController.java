package org.audgns.myapp.controller;

import javax.inject.Inject;

import org.audgns.myapp.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String memberLoginGet() {
		return "/member/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String memberLoginPost(String userid, String userpw) {
		logger.info(userid + ", " + userpw);
//		memberService.loadWithPW(userid, userpw);
		return "";
	}
}
