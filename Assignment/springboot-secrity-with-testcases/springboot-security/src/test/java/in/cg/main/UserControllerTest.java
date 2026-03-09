package in.cg.main;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.cg.main.config.SecurityConfig;
import in.cg.main.controllers.UserController;
import in.cg.main.dto.UserDto;
import in.cg.main.services.UserService;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void testRegisterUser() throws Exception {

        UserDto dto = new UserDto();
        dto.setUserName("Madhav");
        dto.setPassword("12345");
        dto.setRole("USER");

        Mockito.when(userService.registerUser(Mockito.any()))
               .thenReturn("User Registered Successfully");

        mockMvc.perform(post("/register")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("User Registered Successfully"));
    }
    
    
    
    @Test
    void testUserProfileUnauthorized() throws Exception{
    	mockMvc.perform(get("/user/profile"))
    	.andExpect(status().isFound())
    	.andExpect(redirectedUrlPattern("**/login"));
    }
    
    
    @Test
    @WithMockUser(roles="ADMIN")
    void testAdminDashboard() throws Exception{
    	mockMvc.perform(get("/admin/dashboard"))
    	.andExpect(status().isOk())
    	.andExpect(content().string("Welcome to the Dashboard"));
    }
    
    
    
    
    
    
}