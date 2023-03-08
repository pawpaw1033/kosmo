package kr.co.kosmo.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BoardDemoVO;
//1. boardForm

// 2.boardIn
/*
 * ModelAndView mav = new ModelAndView("redirect:boardlist");
 * sout("reip:"+vo.getReip()); sout("title:"+vo.getTitle());
 * sout("content:"+vo.getContent());
 * 
 * 
 * 3. boardList List<boardVO> list = new ArrayList<boardVo>(); 임시데이터 만들어서 보내기
 */
@Controller
public class BoardController {
// 1. BoardForm
	@GetMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}

	// 2. boardIn
	@PostMapping(value = "/boardIn")
	public ModelAndView addBoard(BoardDemoVO vo) {
		System.out.println("reip : " + vo.getReip());
		System.out.println("title : " + vo.getTitle());
		System.out.println("content : " + vo.getContent());
		ModelAndView mav = new ModelAndView("board/boardList");
		mav.addObject("vo", vo);
		return mav;
	}

	// 3. boardList
	@GetMapping(value = "/boardList")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView("board/boardList");
		List<BoardDemoVO> list = new ArrayList<BoardDemoVO>();
		for (int i = 0; i < 2; i++) {
			BoardDemoVO vo = new  BoardDemoVO();
			vo.setNum(i + 1);
			vo.setTitle("오늘은 ㅠㅠㅠㅠ" + i);
			vo.setWriter("빈츠");
			vo.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			list.add(vo);
		}
		
		mav.addObject("list", list);
		return mav;
	}

}
