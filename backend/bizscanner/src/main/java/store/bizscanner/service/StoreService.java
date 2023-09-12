package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.bizscanner.dto.response.store.BestJcategory;
import store.bizscanner.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private static final String yearCode = "2023";

    public BestJcategory bestJcategory(String careaCode) {

        //상권 내 가장 많은 점포수를 보유한 업종 정보
        Object maxStoreObject = storeRepository.findMaxStoreCount(careaCode, yearCode);
        Object[] maxStoreObjectArr = (Object[]) maxStoreObject;
        String bestStoreCountJcategory = (String) maxStoreObjectArr[0];

        //상권 내 가장 개업을 많이 한 업종 정보
        Object maxOpenStoreObject = storeRepository.findMaxOpenStoreCount(careaCode, yearCode);
        Object[] maxOpenStoreObjectArr = (Object[]) maxOpenStoreObject;
        String bestOpenStoreCountJcategory = (String) maxOpenStoreObjectArr[0];

        //상권 내 가장 폐업을 많이 한 업종 정보


    }

}
