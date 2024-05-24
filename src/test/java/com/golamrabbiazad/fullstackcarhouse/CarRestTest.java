package com.golamrabbiazad.fullstackcarhouse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test Authentication using JWT")
    public void testAuthentication() throws Exception {
       this.mockMvc.perform(post("/api/v1/login").content(
               """
               {
               "username": "subscriber59",
               "password": "123456"
               }
              """)
               .header(HttpHeaders.CONTENT_TYPE, "application/json"))
               .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verify Authentication using JWT")
    public void verifyAuthentication() throws Exception {
        this.mockMvc.perform(get("/api/v1/cars")
                        .header(HttpHeaders.AUTHORIZATION, "abcd")
                        .header(HttpHeaders.CONTENT_TYPE, "application/json"))
                .andDo(print()).andExpect(status().isOk());
    }
}
