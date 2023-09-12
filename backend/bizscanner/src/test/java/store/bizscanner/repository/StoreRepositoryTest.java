package store.bizscanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.entity.Store;

@Transactional
@SpringBootTest
class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;
    @Test
    public void repoTest1() {
        Store store = storeRepository.findById(1L).get();
        Assertions.assertThat(store.getJcategoryName()).isEqualTo("미용실");
    }

    @Test
    public void bestStoreCountJcategory() {
        Object result = storeRepository.findMaxStoreCount("2110503", "2023");
        Object[] row = (Object[]) result;
        String jcategoryName = (String) row[0];
        Integer maxStoreCount = (Integer) row[1];
        Assertions.assertThat(jcategoryName).isEqualTo("전자상거래업");
        Assertions.assertThat(maxStoreCount).isEqualTo(40);
    }
}