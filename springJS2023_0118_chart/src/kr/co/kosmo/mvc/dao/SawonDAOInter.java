package kr.co.kosmo.mvc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

public interface SawonDAOInter {

	// deptlist => getDeptList
	public DeptVO getDeptList(int num);
	// sawonPhone =>  getSawonPhoneList
	public List<SawonVO> getSawonPhoneList();
	
	// ����Ŭ ���ν���
	
	public List<HashMap> procedureList(int num);
	public void procedureAdd(SawonVO vo);
}
