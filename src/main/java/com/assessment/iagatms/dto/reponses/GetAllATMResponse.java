package com.assessment.iagatms.dto.reponses;

import com.assessment.iagatms.dto.ATM;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllATMResponse {
    int count;
    List<ATM> atmList;
}
