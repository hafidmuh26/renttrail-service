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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VarietyService varietyService;

    @Autowired
    private PartnerService partnerService;

    @Test
    public void shouldHaveItemById() throws Exception {
        mvc.perform(get("/items/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name", is("Tent")));
    }


    @Test
    public void shouldHaveAddItem() throws Exception {
        Partner partner = partnerService.findById(2);

        mvc.perform(post("/items")
        .content(asJsonString(new Item("Bag",65000,"Eiger", "70l","", partner)))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").exists())
                .andExpect(jsonPath("$.data.price").exists())
                .andExpect(jsonPath("$.data.brand").exists())
                .andExpect(jsonPath("$.data.variety").exists())
                .andExpect(jsonPath("$.data.picture").exists());

    }


    @Test
    public void shouldHaveEditItem() throws Exception {

        Partner partner = partnerService.findById(2);

        mvc.perform(put("/items/1")
                .content(asJsonString(new Item("Bag",65000,"Consina","80l","",partner)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("Bag"))
                .andExpect(jsonPath("$.data.price").value(65000))
                .andExpect(jsonPath("$.data.brand").value("Consina"))
                .andExpect(jsonPath("$.data.variety").value("80l"))
                .andExpect(jsonPath("$.data.picture").value(""));
    }

    @Test
    public void shouldHaveListItem() throws Exception {
        mvc.perform(get("/items")
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").exists())
                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
    }

//    @Test
//    public void shouldHaveDeleteItem() throws Exception {
//        mvc.perform(delete("/items/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.name", is("Bag")))
//                .andExpect(jsonPath("$.data.price", is(65000)))
//                .andExpect(jsonPath("$.data.brand", is("Consina")))
//                .andExpect(jsonPath("$.data.variety",is("80l")));
//    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

