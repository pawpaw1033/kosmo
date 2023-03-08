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
@Component : 일반 빈을 만들 때 
@Controller : Controller에 의해서 요청되는 모델관련 빈을 만들 때
@Repository : 자원 관련 빈을 만들 때 
 @Service : 요청 -> Filter -> DispathcerServlet(Controller) -> 
  ->@Controller(model) -> HandlerMapping (요청분석) -> 모델이 실행 -> 
  -> @Service(트랜젝션 처리) -> @Repository(Dao) -> Database처리 (SqlSessionFactoryBean)
 @RestController : RestFulAPI : json을 서비스 하기 위해서 많이 사용함.
 @ControllerAdvice : AOP에서 공통관심사항을 Advice라 했다. Controller단에서 Advice를 적용하고 싶을
 때 사용 한다. 예) 예외처리에 주로 사용함.
*/
@Service
public class SurveyService {
  //dao를 단위 처리하기 위한 서비스
	@Autowired
	private SurveyDAO surveyDao;
	// 모델에서 받아온 각 데이터를 dao에 각각 전달해서 단위처리를 하기 위한 메서드
	// @Transactional 처리를 하기 위해서
	// 공통빈에서 설정 <tx:annotation-driven/> DataSourceTransactionManger di
	@Transactional
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		// 단위처리
		surveyDao.addSurvey(vo); // 따로 따로 commit
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
