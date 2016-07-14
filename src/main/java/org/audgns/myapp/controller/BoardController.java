package org.audgns.myapp.controller;

import javax.inject.Inject;

import org.audgns.myapp.domain.BoardVO;
import org.audgns.myapp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registGet() {
		return "/board/register";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registPost(BoardVO vo, RedirectAttributes rttr) {
		try {
			boardService.regist(vo);
			rttr.addFlashAttribute("msg", "SUCCESS");
		} catch (Exception e) {
			logger.error("registPost : " + e);
		}
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listAll(Model model) {
		logger.info("show all list...");
		try {
			model.addAttribute("list", boardService.listAll());
		} catch (Exception e) {
			logger.error("listAll : " + e);
		}
		return "/board/listAll";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(@RequestParam("bno") int bno, Model model){
		logger.info("read No." + bno);
		try {
			model.addAttribute("boardVO", boardService.read(bno));
		} catch (Exception e) {
			logger.error("read : " + e);
		}
		return "/board/read";
	}
}
