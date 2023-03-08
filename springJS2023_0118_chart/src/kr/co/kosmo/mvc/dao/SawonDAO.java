package kr.co.kosmo.mvc.dao;

import java.util.HashMap;
import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

@Repository
public class SawonDAO implements SawonDAOInter {

	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public DeptVO getDeptList(int num) {
		
		return ss.selectOne("ksawon.deptList",num);
	}

	@Override
	public List<SawonVO> getSawonPhoneList() {
		
		return ss.selectList("ksawon.sawonList");
	}

	@Override
	public List<HashMap> procedureList(int num) {
		HashMap map = new HashMap();
		map.put("deptno", num);
		ss.selectList("ksawon.procedure1", map);
		// result, mode=OUT Ŀ���� ���� �ʿ� �������ش�.
		// Ű������ ã�Ƽ� ��� �غ���.
		System.out.println(map.get("result"));
		return (List<HashMap>) map.get("result");
	}

	@Override
	public void procedureAdd(SawonVO vo) {
		ss.insert("ksawon.procedure2", vo);
		
	}

}