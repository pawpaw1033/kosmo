package kr.co.kosmo.mvc.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MyBoardDAOInter;
import kr.co.kosmo.mvc.vo.BoardDemoVO;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Controller
@RequestMapping("/board")
public class MyBoardController {
    
	@Autowired 
	private MyBoardDAOInter myBoardDAOInter;
	
	// -----------------------------------------------
		// Page처리를 위한 속성
			private int nowPage = 1; // 현재 페이지 값 -> 메뉴 페이지와 연동되는 변수
			private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block당 5개  배열 생성
			private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
			private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
			private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
			private int totalPage;  // 전체 페이지 수 => totalRecord/numPerPage
			private int totalBlock; // 전체 블럭수
			private int beginPerPage; // 각 페이지별 시작 게시물의 index값
			private int endPerPage; // 각 페이지별 마지막 게시물의 index값
		// --------------------------------------------------
	
	@GetMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	@PostMapping(value = "/boardIn")
	public String boardIn(BoardDemoVO vo) {
		System.out.println("subject =>"+vo.getSubject());
		myBoardDAOInter.addBoard(vo);
		return "redirect:/web/board/boardList";
	}
	@RequestMapping("/boardList")
	public ModelAndView listBoard(String cPage) {
		
		totalRecord = myBoardDAOInter.getCnt();
		totalPage = (int) Math.ceil(totalRecord/ (double)numPerPage);
		totalBlock = (int) Math.ceil((double)totalPage/pagePerBlock);
		String s_page = cPage;
		if(s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		
		// nowPage의 값에서 SQL문의 start값(#{begin})과 , #{end}연산
		beginPerPage = (nowPage-1) * numPerPage +1;
		endPerPage = (beginPerPage -1) + numPerPage;
	
		// 임시로 데이터 전송해보기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);
		// 페이지 블록안에 페이지 반복 시키기 위한 startPage, endPage 를 구해서
		// view로 전달해야함.
		List<BoardDemoVO> list = myBoardDAOInter.listBoard(map);
		int startPage = (int)((nowPage - 1)/ pagePerBlock) * pagePerBlock +1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage 의 연산의 범위가 우리가 구한 totalPage값 미만이라면
		// totalPage의 값으로 대입시킨다. 
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = "+startPage);
		System.out.println("6. endPage = "+endPage);
		// view에 forward로 전송할 데이터
		ModelAndView mav = new ModelAndView("board/boardList");
		mav.addObject("list", list);
		mav.addObject("nowPage", nowPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("pagePerBlock", pagePerBlock);
		mav.addObject("totalPage", totalPage);
		return mav;	
	}
	@GetMapping(value = "/boardDetail")
	public ModelAndView detailBoard(int num) {
		ModelAndView mav = new ModelAndView("board/boardDetail");
	    BoardDemoVO vo = myBoardDAOInter.detailBoard(num);
	    mav.addObject("vo", vo); 
	    return mav;
	}
	@GetMapping(value = "/boardDelete")
	public String deleteBoard(int num) {
		myBoardDAOInter.delBoard(num);
		return "redirect:/web/board/boardList";
	}
	
}
