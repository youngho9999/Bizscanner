package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.response.salesResponse.BestSalesResponse;
import store.bizscanner.dto.response.salesResponse.QuarterSalesCountResponse;
import store.bizscanner.entity.Sales;
import store.bizscanner.repository.SalesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;

    /**
     * Best 매출
     * @param careaCode
     * @return 해당 상권에서 Best 매출 관련 정보 반환 (성별, 나이, 요일, 시간, 업종)
     */
    public BestSalesResponse getBestSales(String careaCode) {
        String bestSalesGender = salesRepository.findBestSalesGender(careaCode);
        String bestSalesAge = salesRepository.findBestSalesAge(careaCode);
        String bestSalesDay = salesRepository.findBestSalesDay(careaCode);
        String bestSalesTime = salesRepository.findBestSalesTime(careaCode);
        String bestJcategoryName = salesRepository.findTopByCareaCodeOrderByQuarterSalesAmountDesc(careaCode).getJcategoryName();

        return new BestSalesResponse(bestSalesGender, bestSalesAge, bestSalesDay, bestSalesTime, bestJcategoryName);
    }

    public QuarterSalesCountResponse getQuarterSalesCount(String careaCode, String jcategoryCode) {
        List<Sales> quarterSalesCountList = salesRepository.findByCareaCodeAndJcategoryCodeOrderByYearCodeAscQuarterCodeAsc(careaCode, jcategoryCode);
        List<Long> result = new ArrayList<>();

        for (Sales quarterSalesCount: quarterSalesCountList) {
            result.add(quarterSalesCount.getQuarterSalesCount());
        }

        return new QuarterSalesCountResponse(result);
    }
}
