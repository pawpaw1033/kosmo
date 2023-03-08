package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardDemoVO;

@Repository
public class MyBoardDAO implements MyBoardDAOInter {
   @Autowired
   private SqlSessionTemplate ss;
	
	@Override
	public void addBoard(BoardDemoVO vo) {
		ss.insert("myboard.add", vo);
		
	}


	@Override
	public BoardDemoVO detailBoard(int num) {
		BoardDemoVO vo = ss.selectOne("myboard.detail", num);
		
		return vo;
	}

	@Override
	public void delBoard(int num) {
		ss.delete("myboard.delete", num);
		
	}

	@Override
	public int getCnt() {
		int cnt = ss.selectOne("myboard.totalCount");
		return cnt;
	}

	@Override
	public List<BoardDemoVO> listBoard(Map<String, Integer> map) {
		List<BoardDemoVO> list = ss.selectList("myboard.listpage", map);
		return list;
	}

}
