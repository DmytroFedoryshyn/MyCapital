package ua.fedoryshyn.MyCapital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.CategoryDto;
import ua.fedoryshyn.MyCapital.entity.Category;
import ua.fedoryshyn.MyCapital.entity.OperationType;
import ua.fedoryshyn.MyCapital.mapper.CategoryMapper;
import ua.fedoryshyn.MyCapital.service.CategoryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CategoryMapper categoryMapper;

    @Test
    void createCategory() throws Exception {
        UUID userId = UUID.randomUUID();

        CategoryDto request = new CategoryDto();
        request.setName("Food");
        request.setOperationType(OperationType.EXPENSE);
        request.setUserId(userId);
        request.setActive(true);

        Category entity = new Category();

        CategoryDto response = new CategoryDto();
        response.setId(UUID.randomUUID());
        response.setName("Food");
        response.setOperationType(OperationType.EXPENSE);
        response.setUserId(userId);
        response.setActive(true);

        when(categoryMapper.toEntity(any(CategoryDto.class)))
            .thenReturn(entity);
        when(categoryService.save(entity))
            .thenReturn(entity);
        when(categoryMapper.toDto(entity))
            .thenReturn(response);

        mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Food"))
            .andExpect(jsonPath("$.operationType").value("EXPENSE"));
    }

    @Test
    void getAllCategories() throws Exception {
        Category entity = new Category();

        CategoryDto dto = new CategoryDto();
        dto.setId(UUID.randomUUID());
        dto.setName("Utilities");
        dto.setOperationType(OperationType.EXPENSE);
        dto.setUserId(UUID.randomUUID());
        dto.setActive(true);

        when(categoryService.findAll()).thenReturn(List.of(entity));
        when(categoryMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/categories"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Utilities"));
    }
}
