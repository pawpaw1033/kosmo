package kr.co.kosmo.mvc.controller.chart;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class SurveyRestController {
	
	@Autowired
 private SurveyService surveyService;
	
	
	
	@RequestMapping(value = "/surveyJsonObjDemo1")
	public SurveyVO surveyDetail(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		return vo;
	}
	// Map으로 반환해서 필요한 것만 출력한다. 
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetailJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		// key, val => Map
		Map<String, Integer> map = new HashedMap();
		for (SurveyContentVO e : vo.getSubvey()) {
			// 비가 옵니다 : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		
		return map;
	}
	// Map으로 반환한  json데이터와 title을 함께 보내기.....

		@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
		public String surveyDetailTitleJson(int num) {
			SurveyVO vo = surveyService.adminDetail(num);
			String subject = vo.getSub();
			// key, val => Map
			Map<String, Integer> map = new HashedMap();
			for (SurveyContentVO e : vo.getSubvey()) {
				// 비가 옵니다 : 500
				map.put(e.getSurveytitle(), e.getSurveycnt());
			}
			// json결과를 문자열로 반환
			String result = null;
			// Objcet Mapper 객체를 가지고 변환을 할 수 있다ㅏ.
			ObjectMapper mapper = new ObjectMapper();
			try {
				// map => {"모릅니다":666, ......"비가 옵니다" : 501}
				result = mapper.writeValueAsString(map);
				// [{"sub :" 내일 날씨는 어떨까요?}, map]
				result = "[{\"sub\":\""+vo.getSub()+"\" }," +result+" ]";
				System.out.println(result);
			} catch (JsonProcessingException e1) {
				
				e1.printStackTrace();
			}
			return result;
		}
}
