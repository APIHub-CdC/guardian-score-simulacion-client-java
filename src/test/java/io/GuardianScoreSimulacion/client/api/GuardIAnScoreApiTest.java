package io.GuardianScoreSimulacion.client.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.GuardianScoreSimulacion.client.ApiClient;
import io.GuardianScoreSimulacion.client.model.CreditReport;
import io.GuardianScoreSimulacion.client.model.RequestBody;
import io.GuardianScoreSimulacion.client.model.ResponseBody;
import okhttp3.OkHttpClient;

public class GuardIAnScoreApiTest {
    private final GuardIAnScoreApi api = new GuardIAnScoreApi();
    
    private Logger logger = LoggerFactory.getLogger(GuardIAnScoreApiTest.class.getName());

    private ApiClient apiClient;
    private String xApiKey = "your_api_key";
    private String url = "the_url";
    
    @Before()
    public void setUp() {
    	 
		this.apiClient = api.getApiClient();
        this.apiClient.setBasePath(url);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
               .readTimeout(30, TimeUnit.SECONDS)
               .build();
        apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void creditreportTest() throws Exception {
        CreditReport report = new CreditReport();
        RequestBody body = new RequestBody();
        
        report.setIdFolioConsultaReporte("folio_consulta");
        report.setFolioOtorgante("folio_otorgante");
        
        body.setCreditReport(report);
        
        ResponseBody response = api.creditreport(this.xApiKey, body);
        System.out.println(response.toString());
        logger.info("Report: "+response.toString());
        
        Assert.assertTrue(response.getFolioConsulta() != null);
    }

}
