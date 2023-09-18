package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.response.jcategoryrecommend.JcategoryRecommendResponse;
import store.bizscanner.global.exception.CustomException;
import store.bizscanner.global.exception.ErrorCode;
import store.bizscanner.repository.JcategoryRecommendConstantRepository;
import store.bizscanner.repository.SalesRepository;
import store.bizscanner.repository.StoreRepository;
import store.bizscanner.repository.mapping.JcategoryRecommendMapping;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JcategoryRecommendConstantService {
    private final JcategoryRecommendConstantRepository jcategoryRecommendConstantRepository;
    private final SalesRepository salesRepository;
    private final StoreRepository storeRepository;

    /**
     * 업종 추천
     * @param careaCode
     * @return 업종 추천 결과 및 추천 근거
     */
    public JcategoryRecommendResponse getJcategoryRecommend(String careaCode){
        List<JcategoryRecommendMapping> recommendList = salesRepository.getJcategoryRecommend(careaCode);
        if(recommendList.isEmpty()){
            throw new CustomException(ErrorCode.REPORT_RESOURCE_NOT_FOUND);
        }

        return new JcategoryRecommendResponse(
                recommendList.get(0),
                jcategoryRecommendConstantRepository.findByCareaCode(careaCode)
                        .orElseThrow(()->new CustomException(ErrorCode.REPORT_RESOURCE_NOT_FOUND)),
                storeRepository.findTopByCareaCodeAndJcategoryCodeOrderByYearCodeDescQuarterCodeDesc(careaCode, recommendList.get(0).getJcategoryCode())
                        .orElseThrow(() -> new CustomException(ErrorCode.REPORT_RESOURCE_NOT_FOUND)).getCloseRate());
    }
}
