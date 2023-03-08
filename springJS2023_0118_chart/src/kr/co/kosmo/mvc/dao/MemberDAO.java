package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
// Dao���� @Repository ��� -> DAO�� ������ ��� �����ش�.
// �̱����̴�. �⺻��!!
@Repository
public class MemberDAO implements MemberDAOInter {
    // kosmo-web.xml���� ������ bean byName
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addMember(MemberDTO dto) {
		
		ss.insert("member.add", dto);
		
	}

	@Override
	public int idCheck(String id) {
		
		return ss.selectOne("member.idchk", id);
	}

	@Override
	public MemberDTO loginCheck(MemberDTO vo) {
		MemberDTO mvo = ss.selectOne("member.login", vo);
		return mvo;
	}

	@Override
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("member.logger_in", vo);
		
	}

	@Override
	public MemberDTO jsonDemo(String id) {
		
		return ss.selectOne("member.jsonDemo", id);
	}

	@Override
	public List<MemberDTO> listMember() {
		List<MemberDTO> list = ss.selectList("member.jsonListDemo");
		return list;
	}

}
