package controller;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertThat;

import br.com.viniciust.controller.PersonController;
import br.com.viniciust.repository.PersonRepository;
import br.com.viniciust.services.PersonService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


@WebMvcTest // contexto web
public class UserControllerTest {
    @Autowired
    private PersonController personController;

    private PersonService personService = new PersonService();

    @Autowired
    PersonRepository repository;



    WireMockServer wm = new WireMockServer(options().port(2345));

    @Test
    public void statusMessage() {
        wm.stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withStatusMessage("Everything was just fine!")
                        .withHeader("Content-Type", "text/plain")));

    }

}
