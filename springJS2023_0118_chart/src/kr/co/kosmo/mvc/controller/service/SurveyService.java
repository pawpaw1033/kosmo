package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDAO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;
/*
<context:component-scan base-package="kr.co.kosmo.mvc"/>
@Component : �Ϲ� ���� ���� �� 
@Controller : Controller�� ���ؼ� ��û�Ǵ� �𵨰��� ���� ���� ��
@Repository : �ڿ� ���� ���� ���� �� 
 @Service : ��û -> Filter -> DispathcerServlet(Controller) -> 
  ->@Controller(model) -> HandlerMapping (��û�м�) -> ���� ���� -> 
  -> @Service(Ʈ������ ó��) -> @Repository(Dao) -> Databaseó�� (SqlSessionFactoryBean)
 @RestController : RestFulAPI : json�� ���� �ϱ� ���ؼ� ���� �����.
 @ControllerAdvice : AOP���� ������ɻ����� Advice�� �ߴ�. Controller�ܿ��� Advice�� �����ϰ� ����
 �� ��� �Ѵ�. ��) ����ó���� �ַ� �����.
*/
@Service
public class SurveyService {
  //dao�� ���� ó���ϱ� ���� ����
	@Autowired
	private SurveyDAO surveyDao;
	// �𵨿��� �޾ƿ� �� �����͸� dao�� ���� �����ؼ� ����ó���� �ϱ� ���� �޼���
	// @Transactional ó���� �ϱ� ���ؼ�
	// ����󿡼� ���� <tx:annotation-driven/> DataSourceTransactionManger di
	@Transactional
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		// ����ó��
		surveyDao.addSurvey(vo); // ���� ���� commit
		surveyDao.addSurveyContent(list);
	}
	public SurveyVO adminDetail(int num) {
		return surveyDao.adminDetail(num);
		
	}
	public void updateSurveyCnt(SurveyContentVO scvo) {
		surveyDao.updateSurveyCnt(scvo);
	}
	public List<SurveyVO> listSurvey(){
		return surveyDao.listSurvey();
		
	}
}
