package com.assessment.iagatms.dto.reponses;

import com.assessment.iagatms.dto.ATM;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BulkAdditionResponse {
    private int successfulCount;
    private List<ATM> successfulATMList;
    private int duplicatesCount;
    private List<ATM> duplicateATMList;
    private int errorsCount;
    private List<ATM> errorATMList;

}
