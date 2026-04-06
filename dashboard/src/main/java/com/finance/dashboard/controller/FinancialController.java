package com.finance.dashboard.controller;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.service.FinancialService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialController {

    private final FinancialService service;

    public FinancialController(FinancialService service){
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord r){
        return service.create(r);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping
    public List<FinancialRecord> getAll(){
        return service.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Deleted";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id,
                                  @RequestBody FinancialRecord record) {
        return service.update(id, record);
    }
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/summary")
    public Object summary(){
        return service.getSummary();
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/category/{c}")
    public List<FinancialRecord> byCat(@PathVariable String c){
        return service.getByCategory(c);
    }
}