package model.dto;

public class Noticeinfo {

	private int noticeinfoCode;
	private int noticeNo;
	private String noticeMemberId;

	public Noticeinfo(int noticeinfoCode, int noticeNo, String noticeMemberId) {
		super();
		this.noticeinfoCode = noticeinfoCode;
		this.noticeNo = noticeNo;
		this.noticeMemberId = noticeMemberId;
	}

	public int getNoticeinfoCode() {
		return noticeinfoCode;
	}

	public void setNoticeinfoCode(int noticeinfoCode) {
		this.noticeinfoCode = noticeinfoCode;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeMemberId() {
		return noticeMemberId;
	}

	public void setNoticeMemberId(String noticeMemberId) {
		this.noticeMemberId = noticeMemberId;
	}

	@Override
	public String toString() {
		return "Noticeinfo [noticeinfoCode=" + noticeinfoCode + ", noticeNo=" + noticeNo + ", noticeMemberId="
				+ noticeMemberId + "]";
	}

}
