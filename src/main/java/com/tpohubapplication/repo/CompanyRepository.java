package com.tpohubapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpohubapplication.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	// write your logic here
}
