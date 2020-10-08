package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.services.AccountService;
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
public class PartnerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AccountService accountService;

    @Test
    public void shouldHavePartnerById() throws Exception {
        mvc.perform(get("/partners/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.owner", is("Jl. Jalan No. 7")));
    }

    @Test
    public void shouldHaveAddPartner() throws Exception {

        Account account = accountService.findById((long) 4);

        mvc.perform(post("/partners")
                .content(asJsonString(new Partner("Gorilla","Jl. Jalan No. 7","Bayu","021329432","",account)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.outlet").exists())
                .andExpect(jsonPath("$.data.owner").exists())
                .andExpect(jsonPath("$.data.telp").exists())
                .andExpect(jsonPath("$.data.address").exists())
                .andExpect(jsonPath("$.data.picture").exists());
    }

    @Test
    public void shouldHaveEditPartner() throws Exception {

        Account account = accountService.findById((long) 4);

        mvc.perform(put("/partners/1")
                .content(asJsonString(new Partner("Hambali","Jl. Jalan No. 7","Bayu","021329432","",account)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.outlet").value("Hambali"))
                .andExpect(jsonPath("$.data.owner").value("Jl. Jalan No. 7"))
                .andExpect(jsonPath("$.data.telp").value("Bayu"))
                .andExpect(jsonPath("$.data.address").value("021329432"))
                .andExpect(jsonPath("$.data.picture").value(""));
    }

    @Test
    public void shouldHaveListPartner() throws Exception {
        mvc.perform(get("/partners")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").exists())
                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
    }

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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
