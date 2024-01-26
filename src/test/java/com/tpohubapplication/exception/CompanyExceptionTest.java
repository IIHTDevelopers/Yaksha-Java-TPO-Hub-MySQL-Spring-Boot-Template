package com.tpohubapplication.exception;

import static com.tpohubapplication.utils.MasterData.getCompanyDTO;
import static com.tpohubapplication.utils.TestUtils.currentTest;
import static com.tpohubapplication.utils.TestUtils.exceptionTestFile;
import static com.tpohubapplication.utils.TestUtils.testReport;
import static com.tpohubapplication.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tpohubapplication.controller.CompanyController;
import com.tpohubapplication.dto.CompanyDTO;
import com.tpohubapplication.service.CompanyService;
import com.tpohubapplication.utils.MasterData;

@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc
public class CompanyExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateCompanyInvalidDataException() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		companyDTO.setCompanyName(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/companies")
				.content(MasterData.asJsonString(companyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testUpdateCompanyInvalidDataException() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		companyDTO.setCompanyName(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/companies/" + companyDTO.getId())
				.content(MasterData.asJsonString(companyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

	@Test
	public void testGetCompanyByIdResourceNotFoundException() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Company not found");

		when(this.companyService.getCompanyById(companyDTO.getId()))
				.thenThrow(new ResourceNotFoundException("Company not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/companies/" + companyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}
	
	@Test
	public void testDeleteCompanyByIdResourceNotFoundException() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		ErrorResponse exResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Company not found");

		when(this.companyService.deleteCompany(companyDTO.getId()))
				.thenThrow(new ResourceNotFoundException("Company not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/companies/" + companyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
	}
}