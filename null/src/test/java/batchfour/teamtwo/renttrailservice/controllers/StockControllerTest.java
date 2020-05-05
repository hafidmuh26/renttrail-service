//package batchfour.teamtwo.renttrailservice.controllers;
//
//import batchfour.teamtwo.renttrailservice.entities.Brand;
//import batchfour.teamtwo.renttrailservice.entities.Item;
//import batchfour.teamtwo.renttrailservice.entities.Stock;
//import batchfour.teamtwo.renttrailservice.services.ItemService;
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
//public class StockControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ItemService itemService;
//
////    @Test
////    public void shouldHaveStockById() throws Exception {
////        mvc.perform(get("/charges/1"))
////                .andExpect(status().isOk())
////                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$.data.name", is("Eiger")));
////    }
//
////    @Test
////    public void shouldHaveAddStock() throws Exception {
////
////        Item item = itemService.findById(1);
////
////        System.out.println(item);
////
////        mvc.perform(post("/stocks")
////                .content(asJsonString(new Stock(1, 2)))
////                .contentType(MediaType.APPLICATION_JSON)
////                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.data.itemId").exists())
////                .andExpect(jsonPath("$.data.quantity").exists());
////    }
//
//    @Test
//    public void shouldHaveEditBrand() throws Exception {
//
//        mvc.perform(put("/brands/1")
//                .content(asJsonString(new Brand("Nike")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").value("Nike"));
//    }
//
//    @Test
//    public void shouldHaveListBrand() throws Exception {
//        mvc.perform(get("/brands")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.list").exists())
//                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
//    }
//
////    @Test
////    public void shouldHaveDeleteBrand() throws Exception {
////        mvc.perform(delete("/brands/4"))
////                .andExpect(status().isOk())
////                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$.data.name", is("Nike")));
////    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
