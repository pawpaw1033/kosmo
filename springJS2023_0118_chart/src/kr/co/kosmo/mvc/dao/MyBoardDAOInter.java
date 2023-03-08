package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.BoardDemoVO;

public interface MyBoardDAOInter {

	public void addBoard(BoardDemoVO vo);
	public int getCnt();
	public List<BoardDemoVO> listBoard(Map<String, Integer> map);
	public BoardDemoVO detailBoard(int num);
	public void delBoard(int num);
}
