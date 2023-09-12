package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.bizscanner.dto.response.store.BestJcategory;
import store.bizscanner.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public BestJcategory bestJcategory(String careaCode) {
        Object maxStoreObject = storeRepository.findMaxStoreCount(careaCode, "2023");
        Object[] maxStoreObjectArr = (Object[]) maxStoreObject;
        String bestStoreCountJcategory = (String) maxStoreObjectArr[0];


    }

}
