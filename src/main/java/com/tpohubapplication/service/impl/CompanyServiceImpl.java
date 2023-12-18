package com.tpohubapplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tpohubapplication.dto.CompanyDTO;
import com.tpohubapplication.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
		// write your logic here
		return null;
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {
		// write your logic here
		return null;
	}

	@Override
	public List<CompanyDTO> getAllCompanies() {
		// write your logic here
		return null;
	}

	@Override
	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
		// write your logic here
		return null;
	}

	@Override
	public boolean deleteCompany(Long id) {
		// write your logic here
		return false;
	}

	@Override
	public List<CompanyDTO> findByStream(String stream) {
		// write your logic here
		return null;
	}

	@Override
	public List<CompanyDTO> findByMinimumPassingPercentageGreaterThan(double percentage) {
		// write your logic here
		return null;
	}
}
