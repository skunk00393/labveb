package mk.finki.ukim.mk.lab;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LabApplicationTests {

    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    BalloonService balloonService;


    private static User u1;
    private static Balloon b1;
    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        initData();
    }

    private void initData() {
        if (!dataInitialized) {

            b1 = balloonService.add("b1", "b1",1L);
            balloonService.add("b2", "b2", 1L);

            String user = "user";
            String admin = "admin";

            userService.createNew(user, user, user,admin, Role.ROLE_USER);
            userService.createNew(admin, admin, admin,admin, Role.ROLE_ADMIN);
            dataInitialized = true;
        }
    }


    @Test
    public void testGetBalloons() throws Exception {
        MockHttpServletRequestBuilder productRequest = MockMvcRequestBuilders.get("/balloons");
        this.mockMvc.perform(productRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("balloons"))
                .andExpect(MockMvcResultMatchers.view().name("listBalloons"));

    }

    @Test
    public void testDeleteBalloon() throws Exception {
        Balloon balloon = this.balloonService.add("test", "neshto", 1L);
        MockHttpServletRequestBuilder productDeleteRequest = MockMvcRequestBuilders
                .delete("/balloons/edit-form/" + balloon.getId());

        this.mockMvc.perform(productDeleteRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/balloons"));
    }



}
