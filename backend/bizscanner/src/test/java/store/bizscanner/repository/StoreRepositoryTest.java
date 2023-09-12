package store.bizscanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.entity.Store;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
}