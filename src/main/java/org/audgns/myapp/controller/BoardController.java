package org.audgns.myapp.controller;

import javax.inject.Inject;

import org.audgns.myapp.domain.BoardVO;
import org.audgns.myapp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGet() {
		return "/board/register";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(BoardVO vo, RedirectAttributes rttr) throws Exception {
		boardService.regist(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		// logger.info("show all list...");
		model.addAttribute("list", boardService.listAll());
		return "/board/listAll";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		// logger.info("read No." + bno);
		model.addAttribute(boardService.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String updateGet(int bno, Model model) throws Exception {
		model.addAttribute(boardService.read(bno));
		return "/board/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updatePost(@ModelAttribute BoardVO vo, RedirectAttributes rttr) throws Exception {
		boardService.modify(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/remove", method=RequestMethod.POST)
	public String delete(int bno, RedirectAttributes rttr) throws Exception {
		boardService.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
}
