package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UpBoardDTO;
// upBoardDAO => byName, alias 설정으로 byName 하기

@Repository("upBoardList")
public class UpBoardDAO implements UpBoardDAOInter {

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addUpBoard(UpBoardDTO vo) {
		ss.insert("upboard.add", vo);
		
	}

	@Override
	public int getCnt() {
		int cnt = ss.selectOne("upboard.totalCount");
		return cnt;
	}

	@Override
	public List<UpBoardDTO> getList(Map<String, Integer> map) {
		List<UpBoardDTO> list = ss.selectList( "upboard.listpage", map);
		return list;
	}

	@Override
	public UpBoardDTO getDetail(int num) {
		UpBoardDTO vo = ss.selectOne("upboard.detail", num);
		return vo;
	}

	@Override
	public void upUpBoard(UpBoardDTO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDelete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCnt(PageSearchDTO vo) {
		return ss.selectOne("upboard.totalCount", vo);
	}

	@Override
	public List<UpBoardDTO> getList(PageSearchDTO vo) {
		return ss.selectList("upboard.listpage", vo);
	}

}
