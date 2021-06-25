package com.assessment.iagatms.dto.reponses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateATMResponse {
    private long totalCount;
    private long totalMatched;
    private long totalModified;
}
