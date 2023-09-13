package store.bizscanner.dto.response.rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentResponse {
    Integer rentAmount;
    Double rentIncreaseRate;
    Integer depositAmount;
    Integer monthlyAmount;
    Integer maintenanceAmount;
    Integer firstInvestmentAmount;
}
