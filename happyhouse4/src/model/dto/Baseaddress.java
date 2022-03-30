package model.dto;

public class Baseaddress {
	
	private int no;
	private String sidoName;
	private String guggunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;
	
	public Baseaddress(int no, String sidoName, String guggunName, String dongName, String dongCode, String lat,
			String lng) {
		super();
		this.no = no;
		this.sidoName = sidoName;
		this.guggunName = guggunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGuggunName() {
		return guggunName;
	}

	public void setGuggunName(String guggunName) {
		this.guggunName = guggunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Baseaddress [no=" + no + ", sidoName=" + sidoName + ", guggunName=" + guggunName + ", dongName="
				+ dongName + ", dongCode=" + dongCode + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
