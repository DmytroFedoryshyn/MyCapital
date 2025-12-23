package ua.fedoryshyn.MyCapital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.fedoryshyn.MyCapital.dto.CurrencyClassifierDto;
import ua.fedoryshyn.MyCapital.mapper.CurrencyClassifierMapper;
import ua.fedoryshyn.MyCapital.service.CurrencyClassifierService;

@RestController
@RequestMapping("/currency-classifiers")
public class CurrencyClassifierController {

    private final CurrencyClassifierService classifierService;
    private final CurrencyClassifierMapper classifierMapper;

    @Autowired
    public CurrencyClassifierController(CurrencyClassifierService classifierService,
                                        CurrencyClassifierMapper classifierMapper) {
        this.classifierService = classifierService;
        this.classifierMapper = classifierMapper;
    }

    @PostMapping
    public CurrencyClassifierDto create(@RequestBody CurrencyClassifierDto dto) {
        return classifierMapper.toDto(classifierService.save(classifierMapper.toEntity(dto)));
    }

    @GetMapping
    public List<CurrencyClassifierDto> findAll() {
        return classifierService.findAll()
                .stream()
                .map(classifierMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CurrencyClassifierDto findById(@PathVariable String id) {
        return classifierMapper.toDto(classifierService.findById(id));
    }

    @PutMapping("/{id}")
    public CurrencyClassifierDto update(@PathVariable String id, @RequestBody CurrencyClassifierDto dto) {
        dto.setAlphaCode(id);
        return classifierMapper.toDto(classifierService.save(classifierMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        classifierService.delete(id);
    }
}






