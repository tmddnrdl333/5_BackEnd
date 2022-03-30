package model.dto;

public class Notice {

	private int noticeNo;
	private String memberId;
	private String memberNickname;
	private String noticeTitle;
	private String noticeBody;
	private String noticeImg;
	private String noticeDate;

	public Notice() {
		super();
	}

	public Notice(int noticeNo, String memberId, String memberNickname, String noticeTitle, String noticeBody, String noticeImg, String noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.noticeTitle = noticeTitle;
		this.noticeBody = noticeBody;
		this.noticeImg = noticeImg;
		this.noticeDate = noticeDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeBody() {
		return noticeBody;
	}

	public void setNoticeBody(String noticeBody) {
		this.noticeBody = noticeBody;
	}

	public String getNoticeImg() {
		return noticeImg;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	
	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memberId=" + memberId + ", memberNickname=" + memberNickname
				+ ", noticeTitle=" + noticeTitle + ", noticeBody=" + noticeBody + ", noticeImg=" + noticeImg
				+ ", noticeDate=" + noticeDate + "]";
	}
}
