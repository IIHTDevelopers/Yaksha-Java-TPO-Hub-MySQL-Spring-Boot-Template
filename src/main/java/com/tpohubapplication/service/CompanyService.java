package com.tpohubapplication.service;

import java.util.List;

import com.tpohubapplication.dto.CompanyDTO;

public interface CompanyService {
	CompanyDTO createCompany(CompanyDTO companyDTO);

	CompanyDTO getCompanyById(Long id);

	List<CompanyDTO> getAllCompanies();

	CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);

	boolean deleteCompany(Long id);

	List<CompanyDTO> findByStream(String stream);

	List<CompanyDTO> findByMinimumPassingPercentageGreaterThan(double percentage);
}