package store.bizscanner.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CareaRecommendServiceTest {

    @Autowired
    private CareaRecommendService careaRecommendService;

    @Test
    public void checkFind() {

        String cs200006 = careaRecommendService.findCareaRecommend("CS200029", 100000000000L, 60L);
        System.out.println(cs200006);
    }
}