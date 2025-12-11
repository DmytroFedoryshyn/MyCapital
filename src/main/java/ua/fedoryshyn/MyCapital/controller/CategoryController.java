package ua.fedoryshyn.MyCapital.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.fedoryshyn.MyCapital.dto.CategoryDto;
import ua.fedoryshyn.MyCapital.mapper.CategoryMapper;
import ua.fedoryshyn.MyCapital.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto dto) {
        return categoryMapper.toDto(categoryService.save(categoryMapper.toEntity(dto)));
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable UUID id) {
        return categoryMapper.toDto(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable UUID id, @RequestBody CategoryDto dto) {
        dto.setId(id);
        return categoryMapper.toDto(categoryService.save(categoryMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        categoryService.delete(id);
    }
}



