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
import ua.fedoryshyn.MyCapital.dto.CurrencyDto;
import ua.fedoryshyn.MyCapital.mapper.CurrencyMapper;
import ua.fedoryshyn.MyCapital.service.CurrencyService;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public CurrencyController(CurrencyService currencyService,
                              CurrencyMapper currencyMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
    }

    @PostMapping
    public CurrencyDto create(@RequestBody CurrencyDto dto) {
        return currencyMapper.toDto(currencyService.save(currencyMapper.toEntity(dto)));
    }

    @GetMapping
    public List<CurrencyDto> findAll() {
        return currencyService.findAll()
                .stream()
                .map(currencyMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CurrencyDto findById(@PathVariable UUID id) {
        return currencyMapper.toDto(currencyService.findById(id));
    }

    @PutMapping("/{id}")
    public CurrencyDto update(@PathVariable UUID id, @RequestBody CurrencyDto dto) {
        dto.setId(id);
        return currencyMapper.toDto(currencyService.save(currencyMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        currencyService.delete(id);
    }
}





