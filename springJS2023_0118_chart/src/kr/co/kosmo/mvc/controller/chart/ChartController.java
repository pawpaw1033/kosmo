package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mychart")
public class ChartController {
	
	@GetMapping(value = "/student")
	public ModelAndView student() {
		ModelAndView mav = new ModelAndView("chart/student");
		return mav;
		
	}
	@GetMapping(value = "/donut")
	public ModelAndView student2() {
		ModelAndView mav = new ModelAndView("chart/donut");
		return mav;
		
	}
	@GetMapping(value = "/memberJsonDemo")
	public String deptJson() {
		return "chart/memberJsonDemo";
		
	}
	@GetMapping(value = "/memberListJsonDemo")
	public String memberListJson() {
		return "chart/memberListJsonDemo";
		
	}
	@GetMapping(value = "/SurveyDonutChartAjax")
	public String chart3() {
		return "chart/SurveyDonutChartAjax";
	}
	@GetMapping(value = "/SurveyDonutChartAjaxTitle")
	public String chartTitle(Model model, int num){
		model.addAttribute("num", num);
		return "chart/SurveyDonutChartAjaxTitle";
	}
}
