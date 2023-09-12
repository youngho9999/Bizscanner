package store.bizscanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void bestStoreCountJcategory() {
        List<String> maxStoreCount = storeRepository.findMaxStoreCount("2130324", "2023");
        Assertions.assertThat(maxStoreCount.get(0)).isEqualTo("일반의류");
    }

    @Test
    public void bestOpenStoreCountJcategory() {
        Object result = storeRepository.findMaxOpenStoreCount("2110503", "2023");
        Object[] row = (Object[]) result;
        String jcategoryName = (String) row[0];
        Integer maxStoreCount = (Integer) row[1];
        Assertions.assertThat(jcategoryName).isEqualTo("전자상거래업");
        Assertions.assertThat(maxStoreCount).isEqualTo(3);
    }

    @Test
    public void bestCloseStoreCountJcategory() {
        Object result = storeRepository.findMaxCloseStoreCount("2110503", "2023");
        Object[] row = (Object[]) result;
        String jcategoryName = (String) row[0];
        Integer maxStoreCount = (Integer) row[1];
        Assertions.assertThat(jcategoryName).isEqualTo("전자상거래업");
        Assertions.assertThat(maxStoreCount).isEqualTo(4);
    }
}