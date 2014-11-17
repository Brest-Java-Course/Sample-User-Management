package com.epam.brest.courses.web;

import com.epam.brest.courses.client.RestClient;
import com.epam.brest.courses.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.Assert.*;

/**
 * Created by xalf on 11/14/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:spring-context.xml")
public class WebIntegrationTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    WebApplicationContext context;

    @Test
    public void myTest() throws Exception {

      LOGGER.debug("Request REST version.");

      RestClient restClient = new RestClient("http://localhost:8080");
      String version = restClient.getRestVesrsion();
      LOGGER.debug("REST version is: " + version);
      isTrue(version.equals("1.0"));
    }
}
