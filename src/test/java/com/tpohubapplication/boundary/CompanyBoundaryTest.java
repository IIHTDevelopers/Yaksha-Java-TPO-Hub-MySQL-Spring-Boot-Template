package com.tpohubapplication.boundary;

import static com.tpohubapplication.utils.TestUtils.boundaryTestFile;
import static com.tpohubapplication.utils.TestUtils.currentTest;
import static com.tpohubapplication.utils.TestUtils.testReport;
import static com.tpohubapplication.utils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tpohubapplication.dto.CompanyDTO;

public class CompanyBoundaryTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCompanyNameNotBlank() throws IOException {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyName(null);
		Set<ConstraintViolation<CompanyDTO>> violations = validator.validate(companyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStreamNotBlank() throws IOException {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setStream(null);
		Set<ConstraintViolation<CompanyDTO>> violations = validator.validate(companyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testMinimumQualificationNotBlank() throws IOException {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setMinimumQualification(null);
		Set<ConstraintViolation<CompanyDTO>> violations = validator.validate(companyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testMustToHaveNotBlank() throws IOException {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setMustToHave(null);
		Set<ConstraintViolation<CompanyDTO>> violations = validator.validate(companyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testGoodToHaveNotBlank() throws IOException {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setGoodToHave(null);
		Set<ConstraintViolation<CompanyDTO>> violations = validator.validate(companyDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}
}
