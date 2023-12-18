package com.tpohubapplication.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tpohubapplication.dto.CompanyDTO;

public class MasterData {

	public static CompanyDTO getCompanyDTO() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setId(1L);
		companyDTO.setCompanyName("ABC Corporation");
		companyDTO.setStream("Technology");
		companyDTO.setMinimumQualification("Bachelor's Degree");
		companyDTO.setMinimumPassingPercentage(60.0);
		companyDTO.setMustToHave("Programming skills");
		companyDTO.setGoodToHave("Teamwork experience");

		return companyDTO;
	}

	public static List<CompanyDTO> getCompanyDTOList() {
		List<CompanyDTO> companyDTOList = new ArrayList<>();

		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setId(1L);
		companyDTO.setCompanyName("ABC Corporation");
		companyDTO.setStream("Technology");
		companyDTO.setMinimumQualification("Bachelor's Degree");
		companyDTO.setMinimumPassingPercentage(60.0);
		companyDTO.setMustToHave("Programming skills");
		companyDTO.setGoodToHave("Teamwork experience");

		companyDTOList.add(companyDTO);

		return companyDTOList;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String randomStringWithSize(int size) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < size; i++) {
			s.append("A");
		}
		return s.toString();
	}
}
