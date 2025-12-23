package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.UserDto;
import ua.fedoryshyn.MyCapital.entity.User;
import ua.fedoryshyn.MyCapital.mapper.UserMapper;
import ua.fedoryshyn.MyCapital.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;


    @Test
    void createUser() throws Exception {
        UserDto request = new UserDto();
        request.setLogin("demo");

        User entity = new User();

        UserDto response = new UserDto();
        response.setId(UUID.randomUUID());
        response.setLogin("demo");

        when(userMapper.toEntity(any(UserDto.class))).thenReturn(entity);
        when(userService.save(entity)).thenReturn(entity);
        when(userMapper.toDto(entity)).thenReturn(response);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.login").value("demo"));
    }

    @Test
    void getAllUsers() throws Exception {
        User entity = new User();
        UserDto dto = new UserDto();
        dto.setId(UUID.randomUUID());
        dto.setLogin("user1");

        when(userService.findAll()).thenReturn(List.of(entity));
        when(userMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].login").value("user1"));
    }
}






