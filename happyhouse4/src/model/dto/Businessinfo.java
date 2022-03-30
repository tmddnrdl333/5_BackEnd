package model.dto;

public class Businessinfo {

	private int businessNo;
	private String businessName;
	private String businessCode;
	private String businessCodeName;
	private String dongCode;
	private String businessLandLot;
	private String businessRoadName;
	private String businessLat;
	private String businessLng;

	public Businessinfo(int businessNo, String businessName, String businessCode, String businessCodeName,
			String dongCode, String businessLandLot, String businessRoadName, String businessLat, String businessLng) {
		super();
		this.businessNo = businessNo;
		this.businessName = businessName;
		this.businessCode = businessCode;
		this.businessCodeName = businessCodeName;
		this.dongCode = dongCode;
		this.businessLandLot = businessLandLot;
		this.businessRoadName = businessRoadName;
		this.businessLat = businessLat;
		this.businessLng = businessLng;
	}

	public int getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(int businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessCodeName() {
		return businessCodeName;
	}

	public void setBusinessCodeName(String businessCodeName) {
		this.businessCodeName = businessCodeName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getBusinessLandLot() {
		return businessLandLot;
	}

	public void setBusinessLandLot(String businessLandLot) {
		this.businessLandLot = businessLandLot;
	}

	public String getBusinessRoadName() {
		return businessRoadName;
	}

	public void setBusinessRoadName(String businessRoadName) {
		this.businessRoadName = businessRoadName;
	}

	public String getBusinessLat() {
		return businessLat;
	}

	public void setBusinessLat(String businessLat) {
		this.businessLat = businessLat;
	}

	public String getBusinessLng() {
		return businessLng;
	}

	public void setBusinessLng(String businessLng) {
		this.businessLng = businessLng;
	}

	@Override
	public String toString() {
		return "Businessinfo [businessNo=" + businessNo + ", businessName=" + businessName + ", businessCode="
				+ businessCode + ", businessCodeName=" + businessCodeName + ", dongCode=" + dongCode
				+ ", businessLandLot=" + businessLandLot + ", businessRoadName=" + businessRoadName + ", businessLat="
				+ businessLat + ", businessLng=" + businessLng + "]";
	}

}
