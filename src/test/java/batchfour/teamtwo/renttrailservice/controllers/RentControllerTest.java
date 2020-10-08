package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.*;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
import batchfour.teamtwo.renttrailservice.services.UserService;
import batchfour.teamtwo.renttrailservice.services.VarietyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EnumType;
import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class RentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VarietyService varietyService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;


    @Test
    public void shouldHaveRentById() throws Exception {
        mvc.perform(get("/rents/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.totalPrice", is(120000)));
    }

//    @Test
//    public void shouldHaveAddRent() throws Exception {
//        Item item = itemService.findById(2);
//        User user = userService.finById(2);
//
//        mvc.perform(post("/rents")
//        .content(asJsonString(new Rent(12000, LocalDate.of(2020,5,20),
//                LocalDate.of(2020,5,25), item,user, StatusRent.fromValue("BOOKED"))))
//        .contentType(MediaType.APPLICATION_JSON)
//        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.totalPrice").exists())
//                .andExpect(jsonPath("$.data.dateStart").exists())
//                .andExpect(jsonPath("$.data.dateEnd").exists())
//                .andExpect(jsonPath("$.data.item").exists())
//                .andExpect(jsonPath("$.data.user").exists())
//                .andExpect(jsonPath("$.data.status").exists());
//
//    }
//
//    @Test
//    public void shouldHaveEditRent() throws Exception {
//        Item item = itemService.findById(2);
//        User user = userService.finById(2);
//
//        mvc.perform(put("/rents/1")
//                .content(asJsonString(new Rent(12000, LocalDate.of(2020,5,20),
//                        LocalDate.of(2020,5,25), item,user, StatusRent.fromValue("DONE"))))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.totalPrice").value("Bag"))
//                .andExpect(jsonPath("$.data.dateStart").value(65000))
//                .andExpect(jsonPath("$.data.dateEnd").value("Consina"))
//                .andExpect(jsonPath("$.data.item").value(item))
//                .andExpect(jsonPath("$.data.user").value(user))
//                .andExpect(jsonPath("$.data.status").value("DONE"));
//    }
//
//    @Test
//    public void shouldHaveListItem() throws Exception {
//        mvc.perform(get("/items")
//        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.list").exists())
//                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
//    }

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

