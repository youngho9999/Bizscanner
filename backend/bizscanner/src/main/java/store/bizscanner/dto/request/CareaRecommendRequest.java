package store.bizscanner.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CareaRecommendRequest {
    private String jcategoryCode;
    private Long firstInvestmentAmount;
    private Integer storeArea;
}
