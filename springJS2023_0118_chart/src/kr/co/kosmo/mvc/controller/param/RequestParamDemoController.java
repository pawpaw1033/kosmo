package kr.co.kosmo.mvc.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamDemoController {
	// @RequestParam ���޵Ǿ� ���� �Ķ���͸� üũ�� �� ����Ѵ�.
	// �Ӽ� : value�� ������ id �� �Ķ���� �̸����� ���� �� �ִ�.
	// �ش� �Ķ���� ��ü�� ���� �� ���ܸ� �߻� ��Ų��.
	//MissingServletRequestParameterException
	@RequestMapping(value = "/reqparam1", method = RequestMethod.GET) 
	public ModelAndView paramDemo1(@RequestParam("id") String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		System.out.println("code =>"+code);
		return mav;
	}
	//  required = false : �Ķ���� ���� ���� ���ܸ� �߻����� �ʴ´�.
	// defaultVlaue = "" : �Ķ���� ���� ���� �� �⺻������ ���� 
	@RequestMapping(value = "/reqparam2", method = RequestMethod.GET) 
	public ModelAndView paramDemo2(@RequestParam(value ="id" , required = false) String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		System.out.println("code =>"+code);
		return mav;
	}
	
}