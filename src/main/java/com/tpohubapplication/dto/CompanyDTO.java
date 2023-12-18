package com.tpohubapplication.dto;

public class CompanyDTO {

	private Long id;

	private String companyName;

	private String stream;

	private String minimumQualification;

	private Double minimumPassingPercentage;

	private String mustToHave;

	private String goodToHave;

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Long id, String companyName, String stream, String minimumQualification,
			Double minimumPassingPercentage, String mustToHave, String goodToHave) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stream = stream;
		this.minimumQualification = minimumQualification;
		this.minimumPassingPercentage = minimumPassingPercentage;
		this.mustToHave = mustToHave;
		this.goodToHave = goodToHave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getMinimumQualification() {
		return minimumQualification;
	}

	public void setMinimumQualification(String minimumQualification) {
		this.minimumQualification = minimumQualification;
	}

	public Double getMinimumPassingPercentage() {
		return minimumPassingPercentage;
	}

	public void setMinimumPassingPercentage(Double minimumPassingPercentage) {
		this.minimumPassingPercentage = minimumPassingPercentage;
	}

	public String getMustToHave() {
		return mustToHave;
	}

	public void setMustToHave(String mustToHave) {
		this.mustToHave = mustToHave;
	}

	public String getGoodToHave() {
		return goodToHave;
	}

	public void setGoodToHave(String goodToHave) {
		this.goodToHave = goodToHave;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", companyName=" + companyName + ", stream=" + stream
				+ ", minimumQualification=" + minimumQualification + ", minimumPassingPercentage="
				+ minimumPassingPercentage + ", mustToHave=" + mustToHave + ", goodToHave=" + goodToHave + "]";
	}
}