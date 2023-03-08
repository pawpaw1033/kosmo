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
	// Map���� ��ȯ�ؼ� �ʿ��� �͸� ����Ѵ�. 
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetailJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		// key, val => Map
		Map<String, Integer> map = new HashedMap();
		for (SurveyContentVO e : vo.getSubvey()) {
			// �� �ɴϴ� : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		
		return map;
	}
	// Map���� ��ȯ��  json�����Ϳ� title�� �Բ� ������.....

		@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
		public String surveyDetailTitleJson(int num) {
			SurveyVO vo = surveyService.adminDetail(num);
			String subject = vo.getSub();
			// key, val => Map
			Map<String, Integer> map = new HashedMap();
			for (SurveyContentVO e : vo.getSubvey()) {
				// �� �ɴϴ� : 500
				map.put(e.getSurveytitle(), e.getSurveycnt());
			}
			// json����� ���ڿ��� ��ȯ
			String result = null;
			// Objcet Mapper ��ü�� ������ ��ȯ�� �� �� �ִ٤�.
			ObjectMapper mapper = new ObjectMapper();
			try {
				// map => {"�𸨴ϴ�":666, ......"�� �ɴϴ�" : 501}
				result = mapper.writeValueAsString(map);
				// [{"sub :" ���� ������ ����?}, map]
				result = "[{\"sub\":\""+vo.getSub()+"\" }," +result+" ]";
				System.out.println(result);
			} catch (JsonProcessingException e1) {
				
				e1.printStackTrace();
			}
			return result;
		}
}
