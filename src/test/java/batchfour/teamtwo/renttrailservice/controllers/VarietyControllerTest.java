package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.entities.Variety;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
import batchfour.teamtwo.renttrailservice.services.VarietyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class VarietyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldHaveVarietyById() throws Exception {
        mvc.perform(get("/varieties/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name", is("Tripel")));
    }


    @Test
    public void shouldHaveAddVariety() throws Exception {

        mvc.perform(post("/varieties")
        .content(asJsonString(new Variety("Double")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").exists());

    }


    @Test
    public void shouldHaveEditVariety() throws Exception {

        mvc.perform(put("/varieties/2")
                .content(asJsonString(new Variety("Tripel")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("Tripel"));
    }

    @Test
    public void shouldHaveListVariety() throws Exception {
        mvc.perform(get("/varieties")
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").exists())
                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
    }

//    @Test
//    public void shouldHaveDeleteVariety() throws Exception {
//        mvc.perform(delete("/varieties/9"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("Double")));
//    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

