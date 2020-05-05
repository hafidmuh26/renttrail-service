//package batchfour.teamtwo.renttrailservice.controllers;
//
//import batchfour.teamtwo.renttrailservice.entities.Brand;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@AutoConfigureMockMvc
//@SpringBootTest
//public class VarietyControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void shouldHaveVarietyById() throws Exception {
//        mvc.perform(get("/varieties/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("50 l")));
//    }
//
//    @Test
//    public void shouldHaveAddVariety() throws Exception {
//
//        mvc.perform(post("/varieties")
//                .content(asJsonString(new Brand("50l")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").exists());
//    }
//
//    @Test
//    public void shouldHaveEditVariety() throws Exception {
//
//        mvc.perform(put("/varieties/2")
//                .content(asJsonString(new Brand("65l")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").value("65l"));
//    }
//
//    @Test
//    public void shouldHaveListVariety() throws Exception {
//        mvc.perform(get("/varieties")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.list").exists())
//                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
//    }
//
//    @Test
//    public void shouldHaveDeleteVariety() throws Exception {
//        mvc.perform(delete("/varieties/4"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("75 l")));
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
