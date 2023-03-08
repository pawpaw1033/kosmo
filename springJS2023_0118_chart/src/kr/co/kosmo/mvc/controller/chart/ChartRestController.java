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

//@Controller -> ������ �����̳ʰ� Model�� �����ؼ�
// ���� �ý��ۿ����� ViewResolver�� ���ؼ� ������
// View�� forward������� �̵��Ѵ�.
// �ȳ��ϼ���.jsp�� �Ѿ��.
//@RestController -> CustomView�� ����ؼ� ������ View ��, 
// JSP�� ������� �ʰ� �����͸� ������ �� �ֱ� ������
// �ַ� JSON���� reponse �� �� �ַ� ����� 
// jsp���Ͽ� �ȳ��ϼ��䰡 ���!!!!!
// @RestController: json�� ���� �����͸� �����ϱ� ���� ��Ʈ�ѷ��̴�. 
@RestController
public class ChartRestController {
// �ش� ��û�� ���� ���� View���ٰ� ��ȯ���� ���� �����ؼ� ���� ó���� ���ش�.
// produces = "text/html;charset=euc-kr" => Content -Type�� �����ϴ� �Ӽ�
	// text/html;charset=euc-kr : html���� �о���δ�.
	
	@Autowired
	private MemberDAOInter memberDaoInter;
	
	
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "�ȳ��ϼ���";
		
	}
	// Json Object Type  -> javascript Object
	// ex) {title : 'test', price: 1000}  =>> testVO, setter =>> MyBatis, DB
	// "application/json : json��� �ƴϸ� ����
	@RequestMapping(value = "/memberJsonView1", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		
		
		try {
			System.out.println("ID =>"+id);
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			return vo;
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			//vo.setName("����");
			vo.setId("����");
			return vo;
		}
		/*MemberDTO vo = new MemberDTO();
		vo.setName("������");
		vo.setNum(1);
		vo.setAge(34);
		vo.setGender("����");
		vo.setId("bhlove22");
		vo.setPwd("111");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	
		*/
		// ��� Ȯ��
		// {"num":1,"id":"bhlove22","pwd":"111","name":"������",
		// "age":34,"gender":"����","mdate":"2023-01-18"}
		
	}
	@RequestMapping(value = "memberListJsonView1", produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonMemberListDemo1(){
		List<MemberDTO> list = memberDaoInter.listMember();
		return list;

	} 
}
