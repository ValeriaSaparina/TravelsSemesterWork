package com.example.semesterwork;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RoutesTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllRoutesTest() throws Exception {
        mockMvc.perform(get("/api/v1/routes/allRoutes").header("Authorization", "Bearer "))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id")))
                .andExpect(content().string(containsString("name")))
                .andExpect(content().string(containsString("places")));
    }

    @Test
    public void getRoutesByQueryTest() throws Exception {
        mockMvc.perform(get("/api/v1/routes/routes")
                        .param("query", "name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("id")))
                .andExpect(content().string(containsString("name")))
                .andExpect(content().string(containsString("places")));
    }


    @Test
    public void createRouteTest() throws Exception {
        mockMvc.perform(post("/api/v1/routes/createRoute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": -1, \"name\": \"test\",\n\"description\": \"test\"}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }


}
