package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;


public interface MemberDAOInter {
public void addMember(MemberDTO dto);
public int idCheck(String id);
// ���̵�� ����� vo�� �����ϰ� ��ȯ������ id, name���� ��ȯ
public MemberDTO loginCheck(MemberDTO vo); 
// AOP���� ����  login �α� ó���� ���� �޼���
public void addLoginLogging(MyLoginLoggerDTO vo);

// json
public MemberDTO jsonDemo(String id);

// memberListJson
public List<MemberDTO> listMember();
}
