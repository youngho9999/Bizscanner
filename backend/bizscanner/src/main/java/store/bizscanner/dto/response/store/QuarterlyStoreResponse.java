package store.bizscanner.dto.response.store;

import store.bizscanner.repository.mapping.TotalStoreMapping;

import java.util.List;

public class QuarterlyStoreResponse {
    private final Integer[] quarterlyStore;

    public QuarterlyStoreResponse(List<TotalStoreMapping> quarterlyStoreList) {
        quarterlyStore = quarterlyStoreList.stream().map(TotalStoreMapping::getStoreCount).toArray(Integer[]::new);
    }
}
