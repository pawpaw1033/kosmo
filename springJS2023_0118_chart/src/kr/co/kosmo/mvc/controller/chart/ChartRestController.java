package kr.co.kosmo.mvc.controller.chart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.SimpleDate;
import kr.co.kosmo.mvc.dao.MemberDAOInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

//@Controller -> 스프링 컨테이너가 Model로 선택해서
// 현재 시스템에서는 ViewResolver를 통해서 지정한
// View로 forward방식으로 이동한다.
// 안녕하세요.jsp로 넘어간다.
//@RestController -> CustomView를 사용해서 지정한 View 즉, 
// JSP를 사용하지 않고 데이터를 응답할 수 있기 때문에
// 주로 JSON으로 reponse 할 때 주로 사용함 
// jsp파일에 안녕하세요가 출력!!!!!
// @RestController: json과 같은 데이터를 서비스하기 위한 컨트롤러이다. 
@RestController
public class ChartRestController {
// 해당 요청이 오면 가상 View에다가 반환받은 값을 전달해서 응답 처리를 해준다.
// produces = "text/html;charset=euc-kr" => Content -Type을 지정하는 속성
	// text/html;charset=euc-kr : html으로 읽어들인다.
	
	@Autowired
	private MemberDAOInter memberDaoInter;
	
	
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "안녕하세요";
		
	}
	// Json Object Type  -> javascript Object
	// ex) {title : 'test', price: 1000}  =>> testVO, setter =>> MyBatis, DB
	// "application/json : json언어 아니면 말고
	@RequestMapping(value = "/memberJsonView1", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		
		
		try {
			System.out.println("ID =>"+id);
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			return vo;
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			//vo.setName("없음");
			vo.setId("없음");
			return vo;
		}
		/*MemberDTO vo = new MemberDTO();
		vo.setName("변백현");
		vo.setNum(1);
		vo.setAge(34);
		vo.setGender("남자");
		vo.setId("bhlove22");
		vo.setPwd("111");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	
		*/
		// 결과 확인
		// {"num":1,"id":"bhlove22","pwd":"111","name":"변백현",
		// "age":34,"gender":"남자","mdate":"2023-01-18"}
		
	}
	@RequestMapping(value = "memberListJsonView1", produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonMemberListDemo1(){
		List<MemberDTO> list = memberDaoInter.listMember();
		return list;

	} 
}
