package util;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class 텍스트필드제한 extends PlainDocument {
	 private int 입력가능개수;
	   public 텍스트필드제한(int 입력가능개수) {
	      super();
	      this.입력가능개수 = 입력가능개수;
	   }

	 @Override
	   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	      if (str == null) {
	         return;
	      }
	      if ( (getLength() + str.length()) <= 입력가능개수) {

	         super.insertString(offset, str, attr);
	      }
	   }
}
