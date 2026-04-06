package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinancialService {

    private final FinancialRecordRepository repo;

    public FinancialService(FinancialRecordRepository repo) {
        this.repo = repo;
    }
    public FinancialRecord update(Long id, FinancialRecord updated) {

        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(updated.getAmount());
        record.setCategory(updated.getCategory());
        record.setType(updated.getType());
        record.setDescription(updated.getDescription());
        record.setDate(updated.getDate());

        return repo.save(record);
    }

    public FinancialRecord create(FinancialRecord r){ return repo.save(r); }

    public List<FinancialRecord> getAll(){ return repo.findAll(); }

    public void delete(Long id){ repo.deleteById(id); }

    public List<FinancialRecord> getByCategory(String c){
        return repo.findByCategory(c);
    }

    public Map<String,Object> getSummary(){
        List<FinancialRecord> list = repo.findAll();

        double income=0, expense=0;
        Map<String,Double> cat=new HashMap<>();

        for(FinancialRecord r:list){
            if(r.getType()== RecordType.INCOME) income+=r.getAmount();
            else expense+=r.getAmount();

            cat.put(r.getCategory(),
                    cat.getOrDefault(r.getCategory(),0.0)+r.getAmount());
        }

        Map<String,Object> res=new HashMap<>();
        res.put("totalIncome",income);
        res.put("totalExpense",expense);
        res.put("netBalance",income-expense);
        res.put("categoryWise",cat);

        return res;
    }
}