
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
public class TestWiremock {


    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static WireMockServer server = new WireMockServer(PORT);

    @BeforeClass
    public static void setup(){
        server.start();
        ResponseDefinitionBuilder mockResponse =  new ResponseDefinitionBuilder ();
        mockResponse.withBodyFile("first.json");
        WireMock.configureFor(HOST,PORT); // localhost:8080
        WireMock.stubFor(WireMock.get("test").willReturn(mockResponse));
    }

    @AfterClass
    public static void tearDown(){
        server.stop();
    }

    @Test
    public void test() throws URISyntaxException {
        RestAssured.get(new URI("https://localhost:8080"));
        RestAssured.get(new URI("https://localhost:8080"));

    }
}

