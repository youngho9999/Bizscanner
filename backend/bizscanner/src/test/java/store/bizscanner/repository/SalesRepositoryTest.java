package store.bizscanner.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import store.bizscanner.entity.Sales;

import java.util.List;


@SpringBootTest
class SalesRepositoryTest {

    @Autowired
    SalesRepository salesRepository;

    private static String careaCode = "1001491";
    private static String jcategoryCode = "CS100007";

    @Test
    public void getBestSalesGender() {


        String bestSalesGender = salesRepository.findBestSalesGender(careaCode);

        Assertions.assertThat(bestSalesGender).isEqualTo("male");


    }

    @Test
    public void getBestSalesAge() {

        String bestSalesAge = salesRepository.findBestSalesAge(careaCode);
        Assertions.assertThat(bestSalesAge).isEqualTo("thirty");
    }

    @Test
    public void getBestSalesDay() {
        String bestSalesDay = salesRepository.findBestSalesDay(careaCode);
        Assertions.assertThat(bestSalesDay).isEqualTo("saturday");
    }

    @Test
    public void getBestSalesTime() {
        String bestSalesTime = salesRepository.findBestSalesTime(careaCode);
        Assertions.assertThat(bestSalesTime).isEqualTo("time_5");
    }

    @Test
    public void getBestJcategory() {
        String bestJcategory = salesRepository.findTopByCareaCodeOrderByQuarterSalesAmountDesc(careaCode).getJcategoryName();
        Assertions.assertThat(bestJcategory).isEqualTo("양식음식점");
    }

    @Test
    public void getQuarterSalesCount() {
        List<Sales> result = salesRepository.findByCareaCodeAndJcategoryCodeOrderByYearCodeAscQuarterCodeAsc(careaCode, jcategoryCode);

        for (int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i).getQuarterSalesCount());
        }
    }



}