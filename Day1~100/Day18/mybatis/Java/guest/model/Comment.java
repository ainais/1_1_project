package mybatis.guest.model;

public class Comment { // 직렬화 : 통신을 함에 있어서 객체를 통과시키는 개념

	private int commentNo; // INT 10 AUTO INCREMENT, PRIMARY KEY
	private String userId; // VARCHAR 30
	private String commentContent; // VARCHAR 500
	private String regDate; // DATE
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
