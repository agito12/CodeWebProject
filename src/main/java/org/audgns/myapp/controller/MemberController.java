package org.audgns.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.audgns.myapp.domain.MemberVO;
import org.audgns.myapp.service.MemberService;
import org.audgns.myapp.util.MemberValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	public String memberLoginPost(@Valid MemberVO vo, BindingResult result, HttpServletRequest req) {
//		logger.info("login : " + vo.getUserid() + ", " + vo.getUserpw());
//		logger.info("result.hasErrors : " + result.hasErrors());
		if (result.hasErrors()) {
			return "/member/login";
		}

		try {
			vo = memberService.loadWithPW(vo.getUserid(), vo.getUserpw());
			WebUtils.setSessionAttribute(req, "USER_KEY", vo);
		} catch (Exception e) {
			logger.error("memberLoginPost : " + e);
			result.reject("login");
			return "/member/login";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
//		logger.info("initBinder's called");
		binder.setValidator(new MemberValidation());
	}
}
