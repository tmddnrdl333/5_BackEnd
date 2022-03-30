package model.dto;

public class Comment {

	private int commentNo;
	private int noticeinfoCode;
	private String memberId;
	private String commentText;
	private String commentDate;

	public Comment(int commentNo, int noticeinfoCode, String memberId, String commentText, String commentDate) {
		super();
		this.commentNo = commentNo;
		this.noticeinfoCode = noticeinfoCode;
		this.memberId = memberId;
		this.commentText = commentText;
		this.commentDate = commentDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getNoticeinfoCode() {
		return noticeinfoCode;
	}

	public void setNoticeinfoCode(int noticeinfoCode) {
		this.noticeinfoCode = noticeinfoCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", noticeinfoCode=" + noticeinfoCode + ", memberId=" + memberId
				+ ", commentText=" + commentText + ", commentDate=" + commentDate + "]";
	}

}
