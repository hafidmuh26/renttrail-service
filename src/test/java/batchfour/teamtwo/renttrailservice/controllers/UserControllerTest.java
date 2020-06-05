
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.entities.User;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldHaveUserById() throws Exception {
        mvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name", is("Bagus")));
    }

//    @Test
//    public void shouldHaveAddUser() throws Exception {
//
//        mvc.perform(post("/users")
//                .content(asJsonString(new User("Bambang","3330000123495000","090760980","Jl. Kenangan","Male","uri", )))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").exists())
//                .andExpect(jsonPath("$.data.nik").exists())
//                .andExpect(jsonPath("$.data.noHp").exists())
//                .andExpect(jsonPath("$.data.address").exists())
//                .andExpect(jsonPath("$.data.gender").exists())
//                .andExpect(jsonPath("$.data.picture").exists());
//    }

//    @Test
//    public void shouldHaveEditUser() throws Exception {
//
//        mvc.perform(put("/users/1")
//                .content(asJsonString(new User("Bambang","3330000123495000","090760980","Jl. Kenangan","Male","http://localhost:8080/users/1/imagespp.jfif")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.name").value("Bambang"))
//                .andExpect(jsonPath("$.data.nik").value("3330000123495000"))
//                .andExpect(jsonPath("$.data.noHp").value("090760980"))
//                .andExpect(jsonPath("$.data.address").value("Jl. Kenangan"))
//                .andExpect(jsonPath("$.data.gender").value("Male"))
//                .andExpect(jsonPath("$.data.picture").value("http://localhost:8080/users/1/imagespp.jfif"));
//    }

    @Test
    public void shouldHaveListUser() throws Exception {
        mvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").exists())
                .andExpect(jsonPath("$.data.list[*].id").isNotEmpty());
    }

    @Test
    public void shouldHaveDeleteUser() throws Exception {
        mvc.perform(delete("/users/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Bambang"))
                .andExpect(jsonPath("$.data.nik").value("3330000123495"))
                .andExpect(jsonPath("$.data.noHp").value("0823145"))
                .andExpect(jsonPath("$.data.address").value("Jl. Merbabu No.769"))
                .andExpect(jsonPath("$.data.gender").value("Female"))
                .andExpect(jsonPath("$.data.picture").value("\"http://localhost:8080/users/2/imagesWhatsApp%20Image%202020-03-09%20at%2017.51.05.jpeg"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

