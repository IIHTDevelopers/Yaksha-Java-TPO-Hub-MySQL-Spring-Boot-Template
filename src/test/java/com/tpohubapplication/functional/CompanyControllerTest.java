package com.tpohubapplication.functional;

import static com.tpohubapplication.utils.MasterData.asJsonString;
import static com.tpohubapplication.utils.MasterData.getCompanyDTO;
import static com.tpohubapplication.utils.MasterData.getCompanyDTOList;
import static com.tpohubapplication.utils.TestUtils.businessTestFile;
import static com.tpohubapplication.utils.TestUtils.currentTest;
import static com.tpohubapplication.utils.TestUtils.testReport;
import static com.tpohubapplication.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tpohubapplication.controller.CompanyController;
import com.tpohubapplication.dto.CompanyDTO;
import com.tpohubapplication.service.CompanyService;

@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc
public class CompanyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAllCompanies() throws Exception {
		List<CompanyDTO> companyDTOs = getCompanyDTOList();

		when(this.companyService.getAllCompanies()).thenReturn(companyDTOs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/companies")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(companyDTOs)) ? "true" : "false"),
				businessTestFile);
	}

	// ... (Previous test methods)

	@Test
	public void testGetCompanyById() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		when(this.companyService.getCompanyById(companyDTO.getId())).thenReturn(companyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/companies/" + companyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(companyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testCreateCompany() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		when(this.companyService.createCompany(any())).thenReturn(companyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/companies").content(asJsonString(companyDTO))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(companyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testUpdateCompany() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		when(this.companyService.updateCompany(eq(companyDTO.getId()), any())).thenReturn(companyDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/companies/" + companyDTO.getId())
				.content(asJsonString(companyDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(companyDTO)) ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testDeleteCompany() throws Exception {
		CompanyDTO companyDTO = getCompanyDTO();
		when(this.companyService.deleteCompany(companyDTO.getId())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/companies/" + companyDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contentEquals("") ? "true" : "false"),
				businessTestFile);
	}

	@Test
	public void testGetCompaniesByStream() throws Exception {
		String stream = "Technology";
		List<CompanyDTO> companyDTOList = getCompanyDTOList();

		when(this.companyService.findByStream(stream)).thenReturn(companyDTOList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/companies/stream/" + stream)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(asJsonString(companyDTOList)) ? "true"
						: "false"),
				businessTestFile);
	}

}
