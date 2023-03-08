package kr.co.kosmo.mvc.controller.sawon;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.SawonDAOInter;
import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

@Controller
public class KSawonController {

	@Autowired
	private SawonDAOInter sawonDao;
	
	@GetMapping(value = "/sPhoneList")
	public String sawonPhonelist(Model m) {
		List<SawonVO> list = sawonDao.getSawonPhoneList();
		m.addAttribute("splist", list);
		return "SawonPhoneList";
	}
	@GetMapping(value = "/deptForm")
	public String deptchooseForm() {
		return "deptchooseform";
		
	}
	@PostMapping(value = "/deptlist")
	public ModelAndView deptlist(int deptno) {
		ModelAndView mav = new ModelAndView("deptList");
		DeptVO list = sawonDao.getDeptList(deptno);
		mav.addObject("dlist", list);
		return mav;
	}
	@GetMapping(value = "/testProcedure")
	public String testProcedure(Model m) {
		List<HashMap> list = sawonDao.procedureList(10);
		m.addAttribute("list", list);
		return "testProcedure";
	}
	
	
	@GetMapping(value = "/testProcedure2")
	public void testProcedure2() {
		SawonVO v = new SawonVO();
		v.setSaname("테스형");
		v.setDeptno(10);
		v.setSajob("부장");
		v.setSapay(3000);
		v.setGender("남자");
		sawonDao.procedureAdd(v);
	}
}
