package com.epam.brest.courses.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by mentee-42 on 14.11.14.
 */
public class RestClientTest {

    static private final String HOST = "http://host";

    private RestClient client;

    private MockRestServiceServer mockServer;

    @Before
    public void setUp() {
        client = new RestClient(HOST);
        mockServer = MockRestServiceServer.createServer(client.getRestTemplate());
    }

    @After
    public void check() {
        mockServer.verify();
    }

    @Test
    public void version() {
        mockServer.expect(requestTo(HOST + "/version"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("123", MediaType.APPLICATION_JSON));

        String version = client.getRestVesrsion();
        assertEquals("123", version);
    }

}
