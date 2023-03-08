package kr.co.kosmo.mvc.vo;

public class BoardDemoVO {
	private int num;
private String reip,title, contents, writer,bdate,subject,content;

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getContents() {
	return contents;
}

public void setContents(String contents) {
	this.contents = contents;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getBdate() {
	return bdate;
}

public void setBdate(String bdate) {
	this.bdate = bdate;
}

public String getReip() {
	return reip;
}

public void setReip(String reip) {
	this.reip = reip;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}



}
