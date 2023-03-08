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
		// Pageó���� ���� �Ӽ�
			private int nowPage = 1; // ���� ������ �� -> �޴� �������� �����Ǵ� ����
			private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block�� 5��  �迭 ����
			private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
			private int numPerPage = 10; // �� �������� ������ �Խù� ��
			private int pagePerBlock = 5; // �� ���� ������ ������ ��
			private int totalPage;  // ��ü ������ �� => totalRecord/numPerPage
			private int totalBlock; // ��ü ����
			private int beginPerPage; // �� �������� ���� �Խù��� index��
			private int endPerPage; // �� �������� ������ �Խù��� index��
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
		
		// nowPage�� ������ SQL���� start��(#{begin})�� , #{end}����
		beginPerPage = (nowPage-1) * numPerPage +1;
		endPerPage = (beginPerPage -1) + numPerPage;
	
		// �ӽ÷� ������ �����غ���
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);
		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage, endPage �� ���ؼ�
		// view�� �����ؾ���.
		List<BoardDemoVO> list = myBoardDAOInter.listBoard(map);
		int startPage = (int)((nowPage - 1)/ pagePerBlock) * pagePerBlock +1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage �� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��. 
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = "+startPage);
		System.out.println("6. endPage = "+endPage);
		// view�� forward�� ������ ������
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
