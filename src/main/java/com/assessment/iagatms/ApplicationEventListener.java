package com.assessment.iagatms;

import com.assessment.iagatms.repository.ATMRepository;
import com.assessment.iagatms.service.MasterDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationEventListener {

    @Autowired
    private ATMRepository atmRepository;

    @Autowired
    private MasterDataService masterDataService;

    @EventListener(ApplicationReadyEvent.class)
    public void updateMasterData() {
       masterDataService.updateMasterData();
    }
}
