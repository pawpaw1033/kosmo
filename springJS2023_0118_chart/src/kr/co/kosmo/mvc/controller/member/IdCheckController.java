package kr.co.kosmo.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDAOInter;

//@RestController => jso, 값을 커스텀 뷰로 전달하는 목적 

@RestController
public class IdCheckController {
	
	@Autowired
	private MemberDAOInter memberDaoInter;
	
	// 반드시 id란 파라미터가 있어야 한다.(체크 대상)
	@GetMapping(value = "/idcheck")
	public int idCheck(Model m, @RequestParam String id) {
		System.out.println("idAjax:"+id);
		int cnt = memberDaoInter.idCheck(id);
		m.addAttribute("msg", cnt);
		return cnt;
	}
}
