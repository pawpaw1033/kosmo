package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

public interface UpBoardDAOInter {
public void addUpBoard(UpBoardDTO vo);
public int getCnt();

public int getCnt(PageSearchDTO vo);
public List<UpBoardDTO> getList(Map<String, Integer> map);
public List<UpBoardDTO> getList(PageSearchDTO vo);
public UpBoardDTO getDetail(int num);
public void upUpBoard(UpBoardDTO vo);
public void upDelete(int num);
}
