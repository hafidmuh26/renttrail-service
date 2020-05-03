//package batchfour.teamtwo.renttrailservice.controllers;
//
//import batchfour.teamtwo.renttrailservice.entities.Brand;
//import batchfour.teamtwo.renttrailservice.entities.Partner;
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
//public class PartnerControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void shouldHavePartnerById() throws Exception {
//        mvc.perform(get("/partners/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("Gorilla")));
//    }
//
//    @Test
//    public void shouldHaveAddPartner() throws Exception {
//
//        mvc.perform(post("/partners")
//                .content(asJsonString(new Partner("Kingkong","0989075","Jl Kenangan", "http://localhost:8080/outlet/2/imagesarei.png")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").exists())
//                .andExpect(jsonPath("$.data.telp").exists())
//                .andExpect(jsonPath("$.data.address").exists())
//                .andExpect(jsonPath("$.data.picture").exists());
//    }
//
//    @Test
//    public void shouldHaveEditPartner() throws Exception {
//
//        mvc.perform(put("/partners/1")
//                .content(asJsonString(new Partner("Kingkong","0989075","Jl Kenangan", "http://localhost:8080/outlet/1/imagesGorilla.jpg")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").value("Kingkong"))
//                .andExpect(jsonPath("$.data.telp").value("0989075"))
//                .andExpect(jsonPath("$.data.address").value("Jl Kenangan"))
//                .andExpect(jsonPath("$.data.picture").value("http://localhost:8080/outlet/1/imagesGorilla.jpg"));
//    }
//
//    @Test
//    public void shouldHaveListPartner() throws Exception {
//        mvc.perform(get("/partners")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.list").exists())
//                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
//    }
//
//    @Test
//    public void shouldHaveDeleteVariety() throws Exception {
//        mvc.perform(delete("/partners/3"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("Eiger")))
//                .andExpect(jsonPath("$.data.telp", is("0821200346")))
//                .andExpect(jsonPath("$.data.address", is("Jl. Jalan Sama Pacar")))
//                .andExpect(jsonPath("$.data.picture", is("http://localhost:8080/outlet/2/imagesarei.png")));
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
