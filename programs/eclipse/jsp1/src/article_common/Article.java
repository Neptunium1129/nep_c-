package article_common;

import java.util.Date;

public class Article {

	String title;
	String contents;
	Date date;
	String writer;
	int readedCount;
	int no;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadedCount() {
		return readedCount;
	}
	public void setReadedCount(int readedCount) {
		this.readedCount = readedCount;
	}

	
	
	
}
