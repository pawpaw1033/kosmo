package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDAOInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping(value = "/login")
public class LoginCheckController {
    
	@Autowired
    private MemberDAOInter memberdaointer;
	
	@RequestMapping(value = "/loginForm")
	public String loginForm(){
		return "login/loginForm";
		
	}
	// ������ ���۵Ǿ� �� �Ķ������ ���� �������� �����ͺ��̽�����
	// ������ ȸ���̸� ������ ���� �����ϰ�, �ƴϸ� ���� �޼����� ������� ���� �ʳ�.
	// String userAgent : Aspect���� ���� �������̴�.
	@PostMapping("/loginProcess")
	public ModelAndView loginfProcess(HttpSession session,HttpServletRequest request, MemberDTO vo, 
			@RequestHeader("User-Agent") String userAgent) {
		System.out.println("User-Agent :" +userAgent);
		ModelAndView mav= new ModelAndView("redirect:/web/main");
		// test
		//String dbid =vo.getId();
		//String dbpwd =vo.getPwd();
		MemberDTO dto = memberdaointer.loginCheck(vo);
		if(dto == null) {
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "�α��� �����Դϴ�.");
		}else {
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionID", dto.getId());
		}
		return mav;
	}
	@GetMapping("/logout")
	public ModelAndView loginfoutProcess(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//session.invalidate();  ������ ���� ����!!!!!
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionID");
		mav.setViewName("redirect:/web/main");
		System.out.println("�α׾ƿ� ����! �� ���� ���� => Proceeding Call");
		return mav;
		
	}
}
