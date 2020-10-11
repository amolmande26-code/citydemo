package com.org.apitesting;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.org.controller.ApiController;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;

@SpringBootTest
@AutoConfigureMockMvc
class ApitestingApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void validateApiTest_RESPONSE_YES_GET() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/connected?origin=Boston&destination=New York", "1"))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseData = response.getContentAsString();
        assertNotNull(responseData);
    }

    @Test
    void validateApiTest_RESPONSE_NO_GET() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/connected?origin=Boston&destination=Washington", "1"))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseData = response.getContentAsString();
        assertNotNull(responseData);
    }
}
