package mx.getweb.gstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class GstoreApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void isAlive() {
        try {
            mvc
                    .perform(get("/ventas/alive"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.valor").value("alivee"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
