/*package com.mastercard.billingrequestreport;


import com.mastercard.billingrequestreport.model.OfflineRequestDTO;
import com.mastercard.billingrequestreport.model.SearchCriteria;
import com.mastercard.billingrequestreport.repository.BillingReportRepository;
import com.mastercard.billingrequestreport.service.BillingReportRequestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mastercard.billingrequestreport.model.OfflineRequestDTO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BillingRequestReportApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BillingRequestReportApplication.class

)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")

public class BillingReportControllerTest {/*

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    BillingReportRequestService billingReportRequestService;

    @Mock
    BillingReportRepository billingReportRepository;


    // public OfflineRequestDTO(@NotNull String feederType, @NotNull String reportType, SearchCriteria searchCriteria, String requestId, String userId,
    // String createdIimestamp, String lastUpdatedTimestamp, String status, String path, String isDeleted) {
    *//*
    * {
    "feederType": "AUTH",
    "reportType": "Summary",
    "searchCriteria": null,
    "requestId": "1",
    "userId": "SN20098787",
    "createdIimestamp": null,
    "lastUpdatedTimestamp": "12-09-2019 13:14:49",
    "status": "INITIATED",
    "path": "http://www.google.com",
    "isDeleted": null
}
    *
    * *//*

    @Mock
    SearchCriteria searchCriteria;
    @Mock
   *//* private OfflineRequestDTO OfflineRequestDTO = new OfflineRequestDTO("AUTH","Summary",searchCriteria,
            "1","SN20098787","","12-09-2019 13:14:49","INITIATED","http://www.google.com","");
*//*
    private OfflineRequestDTO OfflineRequestDTO ;



    @Test
    public void BillingReportGetTestSuccess() throws Exception {

        Mockito.when(billingReportRequestService.getReportRequestDetailsById("1")).thenReturn(new OfflineRequestDTO("AUTH","Summary",searchCriteria,
                "1","SN20098787","","12-09-2019 13:14:49","INITIATED","http://www.google.com",""));

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/billing/requests/1")
        ).andReturn();

        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
       *//* mockMvc.perform(MockMvcRequestBuilders.get("/billing/requests/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
                /*.andExpect(jsonPath("$.[0].feederType").exists())
                .andExpect(jsonPath("$.[0].reportType").exists())
                .andExpect(jsonPath("$.[0].requestId").exists())
                .andExpect(jsonPath("$.[0].userId").exists())
                .andExpect(jsonPath("$.[0].createdIimestamp").exists())
                .andExpect(jsonPath("$.[0].lastUpdatedTimestamp").exists())
                .andExpect(jsonPath("$.[0].status").exists())
                .andExpect(jsonPath("$.[0].path").exists())
                .andExpect(jsonPath("$.[0].isDeleted").exists())*//*


        System.out.println("mvcResult="+mvcResult.getResponse().getContentAsString());

       Mockito.verify(billingReportRequestService).getReportRequestDetailsById("1");
    }


    @Test
    public void BillingReportGetTestSuccess_withValues() throws Exception {

        Mockito.when(billingReportRequestService.getReportRequestDetailsById("1")).thenReturn(new OfflineRequestDTO());

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/billing/requests/1")
        ).andReturn();

        System.out.println("mvcResult="+mvcResult.getResponse().getContentAsString());

        Assert.assertEquals(200, mvcResult.getResponse().getStatus());


      // Mockito.verify(billingReportRequestService).getReportRequestDetailsById("1");
    }

    *//*private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyBillingReportPostTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/billing/requests")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                                "\t\"invoiceDate\":\"27-08-2019\",\n" +
                                "\t\"feederType\":\"AUTH\",\n" +
                                "\t\"reportType\":\"Summary\",\n" +
                                "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].feederType").exists())
                .andExpect(jsonPath("$.[0].reportType").exists())
                .andExpect(jsonPath("$.[0].requestId").exists())
                .andExpect(jsonPath("$.[0].userId").exists())
                .andExpect(jsonPath("$.[0].createdIimestamp").exists())
                .andExpect(jsonPath("$.[0].lastUpdatedTimestamp").exists())
                .andExpect(jsonPath("$.[0].status").exists())
                .andExpect(jsonPath("$.[0].path").exists())
                .andExpect(jsonPath("$.[0].isDeleted").exists())
                .andDo(print());
    }

    @Test
    public void GetBillingReportRequestDetails_When_ValidRequest() throws Exception {
        *//**//* setup mock *//**//*

        mockMvc.perform(MockMvcRequestBuilders.get("/billing/requests/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].feederType").exists())
                .andExpect(jsonPath("$.[0].reportType").exists())
                .andExpect(jsonPath("$.[0].requestId").exists())
                .andExpect(jsonPath("$.[0].userId").exists())
                .andExpect(jsonPath("$.[0].createdIimestamp").exists())
                .andExpect(jsonPath("$.[0].lastUpdatedTimestamp").exists())
                .andExpect(jsonPath("$.[0].status").exists())
                .andExpect(jsonPath("$.[0].path").exists())
                .andExpect(jsonPath("$.[0].isDeleted").exists())
                .andDo(print());
               *//**//*mockMvc.perform(get("/billing/requests/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.accountId").value(12345))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"))
                .andExpect(jsonPath("$.balance").value(5000.0));*//**//*
    }


*//**//*
    @LocalServerPort
    int randomServerPort;

    @InjectMocks
    BillingReportRequestService billingReportRequestService;

    @Test
    public void testGetEmployeeListSuccess() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:"+randomServerPort+"/billing/requests/1";
        URI uri = new URI(baseUrl);

        ResponseEntity<OfflineRequestDTO> result = restTemplate.getForEntity(uri, OfflineRequestDTO.class);

        When(billingReportRequestService.getReportRequestDetailsById)thenRe

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        //Assert.assertEquals(true, result.getBody().contains("offlineRequestDTO"));
    }
}*/
