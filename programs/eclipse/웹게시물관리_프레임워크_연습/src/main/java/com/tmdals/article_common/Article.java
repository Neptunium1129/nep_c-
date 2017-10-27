package com.tmdals.article_common;

import java.util.Date;

import com.tmdals.member_common.Member;

public class Article {
	  int no;
	   String title;
	   String contents;
	   Date date;
	   Member member;
		int readedCount;
		
		
	   public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	   
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

   public int getReadedCount() {
      return readedCount;
   }
   public void setReadedCount(int readedCount) {
      this.readedCount = readedCount;
   }
}
 
   
