package com.assessment.iagatms.service;

import com.assessment.iagatms.dto.ATM;
import com.assessment.iagatms.repository.ATMRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Slf4j
public class MasterDataService {

    @Autowired
    private ATMRepository atmRepository;

    public void updateMasterData() {
        try {
            ResponseEntity<String> response = getMasterData();
            log.info("Master Data Response: {}", response);
            if(response.getBody() != null) {
                ObjectMapper mapper = new ObjectMapper();
                String responseJson = response.getBody().substring(6);
                final ATM[] atms = mapper.readValue(responseJson, ATM[].class);
                Arrays.asList(atms).parallelStream().forEach(atm -> {
                    try {
                        atmRepository.upsert(atm);
                    } catch (Exception e) {
                        log.error("Error while saving ATM: {} error: {}", atm, e.getMessage());
                    }
                });
            }
        } catch (RestClientException e) {
            log.error("Error while retrieving data from ING server: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error while processing retrieved Data; {}", e.getMessage());
        }
    }

    private ResponseEntity<String> getMasterData() throws RestClientException{
        String iagDataUrl
                = "https://www.ing.nl/api/locator/atms/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(
                iagDataUrl,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
    }
}
