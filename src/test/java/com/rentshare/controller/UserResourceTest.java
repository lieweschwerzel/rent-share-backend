package com.rentshare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentshare.model.DAOUser;
import com.rentshare.repository.UserDao;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserResourceTest {


    private MockMvc mockMvc;

    @Mock
    UserDao userDao;

    @InjectMocks
    private UserResource userResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userResource)
                .build();
    }

    @Test
    public void persistResource() throws Exception {
        DAOUser daoUser = new DAOUser();
        daoUser.setId(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(daoUser);

        mockMvc.perform(post("/user/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andReturn();
    }

    @Test
    public void getAll() throws Exception {

        mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAll() throws Exception {
        mockMvc.perform(get("/user/admin/delete"))
                .andExpect(status().isOk())
                .andExpect(content().string("all users deleted"));
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/user/delete/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/user/search/1"))
                .andExpect(status().isOk());
    }


}