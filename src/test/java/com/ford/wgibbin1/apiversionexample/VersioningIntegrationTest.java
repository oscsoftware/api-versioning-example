package com.ford.wgibbin1.apiversionexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VersioningIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void badUrlNotMapped() throws Exception {
        mockMvc.perform(get("/example-controller/goodbye"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void notAnnotatedIsMappedWithoutVersionPath() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/example-controller/hello"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString().equals("World version unversioned"));
    }

    @Test
    public void v1MappedToV1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v1/example-controller/hello"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString().equals("World version 1"));
    }

    @Test
    public void v2MappedToV2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v2/example-controller/hello"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString().equals("World version 2"));
    }

    @Test
    public void vdateMappedToVdate() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v2/example-controller/hello"))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString().equals("World version 2"));
    }



}
