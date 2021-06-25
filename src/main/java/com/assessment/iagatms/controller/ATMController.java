package com.assessment.iagatms.controller;

import com.assessment.iagatms.dto.ATM;
import com.assessment.iagatms.dto.ATMSBulkAddPayload;
import com.assessment.iagatms.dto.reponses.BulkAdditionResponse;
import com.assessment.iagatms.dto.reponses.GetAllATMResponse;
import com.assessment.iagatms.dto.reponses.UpdateATMResponse;
import com.assessment.iagatms.repository.ATMRepository;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class ATMController {

    @Autowired
    ATMRepository atmRepository;
    @PostMapping("/atms")
    public BulkAdditionResponse addATMList(@RequestBody ATMSBulkAddPayload atmsBulkAddPayload) {
        final List<ATM> successfulATMList =  new ArrayList<>();
        final List<ATM> duplicateATMList = new ArrayList<>();
        final List<ATM> errorATMList =new ArrayList<>();
        atmsBulkAddPayload.getAtmList().parallelStream().forEach((atm) -> {
            try {
                final ATM savedAtm = atmRepository.save(atm);
                successfulATMList.add(savedAtm);
            } catch (DuplicateKeyException e) {
                log.error("Trying to insertDuplicate record {}", atm);
                duplicateATMList.add(atm);
            } catch (Exception e) {
                log.error("Exception while inserting record: {}", e.getMessage());
                errorATMList.add(atm);
            }
        });
        return BulkAdditionResponse.builder()
                .successfulCount(successfulATMList.size())
                .successfulATMList(successfulATMList)
                .duplicatesCount(duplicateATMList.size())
                .duplicateATMList(duplicateATMList)
                .errorsCount(errorATMList.size())
                .errorATMList(errorATMList)
                .build();
    }

    @PutMapping("/atms")
    public UpdateATMResponse updateATMList(@RequestBody ATMSBulkAddPayload atmsBulkAddPayload) {
        System.out.println(atmsBulkAddPayload);
       AtomicLong  totalModifiedCount = new AtomicLong();
        AtomicLong totalMatchedCount = new AtomicLong();
        atmsBulkAddPayload.getAtmList().parallelStream().forEach((atm) -> {
            final UpdateResult updateResult = atmRepository.update(atm);
            totalMatchedCount.set(totalMatchedCount.get() + updateResult.getMatchedCount());
            totalModifiedCount.set(totalModifiedCount.get() + updateResult.getModifiedCount());
        });
        return UpdateATMResponse.builder()
                .totalCount(atmsBulkAddPayload.getAtmList().size())
                .totalMatched(totalMatchedCount.get())
                .totalModified(totalModifiedCount.get())
                .build();
    }
    @GetMapping("/atms")
    public GetAllATMResponse getATMList() {
        final List<ATM> atmList = atmRepository.findAll();
        return GetAllATMResponse.builder()
                .count(atmList.size())
                .atmList(atmList)
                .build();
    }
}
