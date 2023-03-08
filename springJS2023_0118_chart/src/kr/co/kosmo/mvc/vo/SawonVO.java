package kr.co.kosmo.mvc.vo;

public class SawonVO {
private int sabun;
private int deptno;
private String saname;
private String sajob;
private int sapay;
private String sahire;
private String gender;
private int samgr;

// hasone : 사원 한 명당 phone을 가지는 관계
// ResultMap의 Association 예제
private SawonPhoneVO sphone;


public int getSabun() {
	return sabun;
}
public void setSabun(int sabun) {
	this.sabun = sabun;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public String getSaname() {
	return saname;
}
public void setSaname(String saname) {
	this.saname = saname;
}
public String getSajob() {
	return sajob;
}
public void setSajob(String sajob) {
	this.sajob = sajob;
}
public int getSapay() {
	return sapay;
}
public void setSapay(int sapay) {
	this.sapay = sapay;
}
public String getSahire() {
	return sahire;
}
public void setSahire(String sahire) {
	this.sahire = sahire;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getSamgr() {
	return samgr;
}
public void setSamgr(int samgr) {
	this.samgr = samgr;
}
public SawonPhoneVO getSphone() {
	return sphone;
}
public void setSphone(SawonPhoneVO sphone) {
	this.sphone = sphone;
}
}

