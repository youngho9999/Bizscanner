package store.bizscanner.dto.response.salesResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuarterSalesCountResponse {

    private List<Integer> quarterSalesCount;
}
