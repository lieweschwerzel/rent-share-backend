package com.rentshare.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentshare.model.Advert;
import com.rentshare.repository.AdvertRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertResourceTest {

    private MockMvc mockMvc;

    @Mock
    AdvertRepository advertRepository;

    @InjectMocks
    private AdvertResource advertResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(advertResource)
                .build();
    }

    @Test
    public void persistResource() throws Exception {
        Advert advert = new Advert();
        advert.setTitle("Book");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(advert);

        mockMvc.perform(post("/advert/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.title", Matchers.is("Book")))
                .andReturn();
    }

    //krijg OK terug
    @Test
    public void getAll() throws Exception {

        mockMvc.perform(get("/advert/all"))
                .andExpect(status().isOk());
    }

    //delete alle adverts als admin, krijg 200 terug en string "all ads deleted"
    @Test
    public void deleteAll() throws Exception {
        mockMvc.perform(get("/advert/admin/delete"))
                .andExpect(status().isOk())
                .andExpect(content().string("all ads deleted"));

    }

    @Test
    public void updateResource() throws Exception {
    }

    @Test
    public void search() {
    }
}