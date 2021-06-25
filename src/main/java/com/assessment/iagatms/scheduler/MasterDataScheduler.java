package com.assessment.iagatms.scheduler;

import com.assessment.iagatms.service.MasterDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
public class MasterDataScheduler {

    @Autowired
    private MasterDataService masterDataService;

    @Scheduled(cron = "0 0 * * *")
    public void cronJobSch() {
        log.info("Scheduler is running");
        masterDataService.updateMasterData();
    }
}
