package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.bizscanner.entity.CareaRecommendNormalized;
import store.bizscanner.global.exception.CustomException;
import store.bizscanner.global.exception.ErrorCode;
import store.bizscanner.repository.CareaRecommendNormalizedRepository;

import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;

@Service
@RequiredArgsConstructor
public class CareaRecommendService {

    private final CareaRecommendNormalizedRepository careaRecommendNormalizedRepository;

    /**
     * 업종과 초기 투자금, 면적을 입력받았을 때, 알고리즘을 이용해 최선의 상권을 찾는 메소드
     * @param jcategoryCode 업종 코드
     * @param firstInvestmentAmount 초기 투자금
     * @param storeArea 업장 면적
     */
    public String findCareaRecommend(String jcategoryCode, long firstInvestmentAmount, long storeArea) {
        //해당 업종이 있는 상권 중 초기 투자금을 만족하는 상권들을 모두 불러온다
        List<CareaRecommendNormalized> careaList = careaRecommendNormalizedRepository.
                findByJcategoryCodeAndFirstInvestmentAmountLessThan(jcategoryCode,firstInvestmentAmount);

        //해당 만족하는 조건의 상권이 없다면, Exception 처리를 해준다
        if(careaList.isEmpty()) {
            throw new CustomException(ErrorCode.RECOMMEND_CAREA_NOT_FOUND);
        }

        //순이익 정규화를 위해 순이익 min,max 를 구해준다.
        LongSummaryStatistics statistics = careaList.stream().
                mapToLong(x -> x.getProfit(storeArea)).summaryStatistics();
        long minProfit = statistics.getMax();
        long maxProfit = statistics.getMin();

        return careaList.stream().max(Comparator.comparingDouble(o -> o.getScore(minProfit, maxProfit, storeArea)))
                .get().getCareaCode();
    }
}
