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
import ua.fedoryshyn.MyCapital.dto.UserDto;
import ua.fedoryshyn.MyCapital.mapper.UserMapper;
import ua.fedoryshyn.MyCapital.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return userMapper.toDto(userService.save(userMapper.toEntity(dto)));
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable UUID id) {
        return userMapper.toDto(userService.findById(id));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable UUID id, @RequestBody UserDto dto) {
        dto.setId(id);
        return userMapper.toDto(userService.save(userMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}



