package store.bizscanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.entity.CareaRecommendNormalizedId;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CareaRecommendNormalizedRepositoryTest {

    @Autowired
    private CareaRecommendNormalizedRepository careaRecommendNormalizedRepository;

    @Test
    public void findTest() {
        CareaRecommendNormalizedId id = new CareaRecommendNormalizedId("CS100001", "1001491");
        Assertions.assertThat(careaRecommendNormalizedRepository.findById(id).get().getSalesAmountRate())
                .isEqualTo(0.7684227047528815);
    }
}