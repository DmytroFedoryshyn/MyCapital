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
import ua.fedoryshyn.MyCapital.dto.ExpenseTransactionDto;
import ua.fedoryshyn.MyCapital.mapper.ExpenseTransactionMapper;
import ua.fedoryshyn.MyCapital.service.ExpenseTransactionService;

@RestController
@RequestMapping("/expense-transactions")
public class ExpenseTransactionController {

    private final ExpenseTransactionService expenseTransactionService;
    private final ExpenseTransactionMapper expenseTransactionMapper;

    @Autowired
    public ExpenseTransactionController(ExpenseTransactionService expenseTransactionService,
                                        ExpenseTransactionMapper expenseTransactionMapper) {
        this.expenseTransactionService = expenseTransactionService;
        this.expenseTransactionMapper = expenseTransactionMapper;
    }

    @PostMapping
    public ExpenseTransactionDto create(@RequestBody ExpenseTransactionDto dto) {
        return expenseTransactionMapper.toDto(expenseTransactionService.save(expenseTransactionMapper.toEntity(dto)));
    }

    @GetMapping
    public List<ExpenseTransactionDto> findAll() {
        return expenseTransactionService.findAll()
                .stream()
                .map(expenseTransactionMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ExpenseTransactionDto findById(@PathVariable UUID id) {
        return expenseTransactionMapper.toDto(expenseTransactionService.findById(id));
    }

    @PutMapping("/{id}")
    public ExpenseTransactionDto update(@PathVariable UUID id, @RequestBody ExpenseTransactionDto dto) {
        dto.setId(id);
        return expenseTransactionMapper.toDto(expenseTransactionService.save(expenseTransactionMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        expenseTransactionService.delete(id);
    }
}






