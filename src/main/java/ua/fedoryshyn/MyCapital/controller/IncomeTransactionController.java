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
import ua.fedoryshyn.MyCapital.dto.IncomeTransactionDto;
import ua.fedoryshyn.MyCapital.mapper.IncomeTransactionMapper;
import ua.fedoryshyn.MyCapital.service.IncomeTransactionService;

@RestController
@RequestMapping("/income-transactions")
public class IncomeTransactionController {

    private final IncomeTransactionService incomeTransactionService;
    private final IncomeTransactionMapper incomeTransactionMapper;

    @Autowired
    public IncomeTransactionController(IncomeTransactionService incomeTransactionService,
                                       IncomeTransactionMapper incomeTransactionMapper) {
        this.incomeTransactionService = incomeTransactionService;
        this.incomeTransactionMapper = incomeTransactionMapper;
    }

    @PostMapping
    public IncomeTransactionDto create(@RequestBody IncomeTransactionDto dto) {
        return incomeTransactionMapper.toDto(incomeTransactionService.save(incomeTransactionMapper.toEntity(dto)));
    }

    @GetMapping
    public List<IncomeTransactionDto> findAll() {
        return incomeTransactionService.findAll()
                .stream()
                .map(incomeTransactionMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public IncomeTransactionDto findById(@PathVariable UUID id) {
        return incomeTransactionMapper.toDto(incomeTransactionService.findById(id));
    }

    @PutMapping("/{id}")
    public IncomeTransactionDto update(@PathVariable UUID id, @RequestBody IncomeTransactionDto dto) {
        dto.setId(id);
        return incomeTransactionMapper.toDto(incomeTransactionService.save(incomeTransactionMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        incomeTransactionService.delete(id);
    }
}






