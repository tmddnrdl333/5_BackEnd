package model.dto;

public class Guguncode {

	private String gugunCode;
	private String gugunName;
	
	public Guguncode(String gugunCode, String gugunName) {
		super();
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "Guguncode [gugunCode=" + gugunCode + ", gugunName=" + gugunName + "]";
	}
}
