package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store.bizscanner.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT \n" +
            "  CASE WHEN SUM(s.maleSalesAmount) > SUM(s.femaleSalesAmount) THEN 'male'\n" +
            "       WHEN SUM(s.maleSalesAmount) < SUM(s.femaleSalesAmount) THEN 'female'\n" +
            "       ELSE 'equal' END AS higherSalesGender\n" +
            "FROM Sales s\n" +
            "WHERE s.careaCode = :careaCode")
    String findBestSalesGender(@Param("careaCode") String careaCode);

    @Query("SELECT " +
            "CASE " +
            "WHEN sum(s.teensSalesAmount) >= GREATEST(sum(s.twentiesSalesAmount), sum(s.thirtiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.sixtiesSalesAmount)) THEN 'teen' " +
            "WHEN sum(s.twentiesSalesAmount) >= GREATEST(sum(s.teensSalesAmount), sum(s.thirtiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.sixtiesSalesAmount)) THEN 'twenty' " +
            "WHEN sum(s.thirtiesSalesAmount) >= GREATEST(sum(s.teensSalesAmount), sum(s.twentiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.sixtiesSalesAmount)) THEN 'thirty' " +
            "WHEN sum(s.fortiesSalesAmount) >= GREATEST(sum(s.teensSalesAmount), sum(s.twentiesSalesAmount), sum(s.thirtiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.sixtiesSalesAmount)) THEN 'forty' " +
            "WHEN sum(s.fiftiesSalesAmount) >= GREATEST(sum(s.teensSalesAmount), sum(s.twentiesSalesAmount), sum(s.thirtiesSalesAmount), sum(s.fortiesSalesAmount), sum(s.sixtiesSalesAmount)) THEN 'fifty' " +
            "ELSE 'sixty' " +
            "END AS highestSalesAgeGroup " +
            "FROM Sales s " +
            "WHERE s.careaCode = :careaCode")
    String findBestSalesAge(@Param("careaCode") String careaCode);

    @Query("SELECT CASE " +
            "WHEN SUM(s.mondaySalesAmount) >= GREATEST(" +
            "SUM(s.tuesdaySalesAmount), " +
            "SUM(s.wednesdaySalesAmount), " +
            "SUM(s.thursdaySalesAmount), " +
            "SUM(s.fridaySalesAmount), " +
            "SUM(s.saturdaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'monday' " +
            "WHEN SUM(s.tuesdaySalesAmount) >= GREATEST(" +
            "SUM(s.mondaySalesAmount), " +
            "SUM(s.wednesdaySalesAmount), " +
            "SUM(s.thursdaySalesAmount), " +
            "SUM(s.fridaySalesAmount), " +
            "SUM(s.saturdaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'tuesday' " +
            "WHEN SUM(s.wednesdaySalesAmount) >= GREATEST(" +
            "SUM(s.mondaySalesAmount), " +
            "SUM(s.tuesdaySalesAmount), " +
            "SUM(s.thursdaySalesAmount), " +
            "SUM(s.fridaySalesAmount), " +
            "SUM(s.saturdaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'wednesday' " +
            "WHEN SUM(s.thursdaySalesAmount) >= GREATEST(" +
            "SUM(s.mondaySalesAmount), " +
            "SUM(s.tuesdaySalesAmount), " +
            "SUM(s.wednesdaySalesAmount), " +
            "SUM(s.fridaySalesAmount), " +
            "SUM(s.saturdaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'thursday' " +
            "WHEN SUM(s.fridaySalesAmount) >= GREATEST(" +
            "SUM(s.mondaySalesAmount), " +
            "SUM(s.tuesdaySalesAmount), " +
            "SUM(s.wednesdaySalesAmount), " +
            "SUM(s.thursdaySalesAmount), " +
            "SUM(s.saturdaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'friday' " +
            "WHEN SUM(s.saturdaySalesAmount) >= GREATEST(" +
            "SUM(s.mondaySalesAmount), " +
            "SUM(s.tuesdaySalesAmount), " +
            "SUM(s.wednesdaySalesAmount), " +
            "SUM(s.thursdaySalesAmount), " +
            "SUM(s.fridaySalesAmount), " +
            "SUM(s.sundaySalesAmount)) THEN 'saturday' " +
            "ELSE 'Sunday' " +
            "END AS highest_sales_day " +
            "FROM Sales s " +
            "WHERE s.careaCode = :careaCode")
    String findBestSalesDay(String careaCode);


    @Query("SELECT CASE " +
            "WHEN SUM(s.time1SalesAmount) >= GREATEST(" +
            "SUM(s.time2SalesAmount), " +
            "SUM(s.time3SalesAmount), " +
            "SUM(s.time4SalesAmount), " +
            "SUM(s.time5SalesAmount), " +
            "SUM(s.time6SalesAmount)) THEN 'time_1' " +
            "WHEN SUM(s.time2SalesAmount) >= GREATEST(" +
            "SUM(s.time1SalesAmount), " +
            "SUM(s.time3SalesAmount), " +
            "SUM(s.time4SalesAmount), " +
            "SUM(s.time5SalesAmount), " +
            "SUM(s.time6SalesAmount)) THEN 'time_2' " +
            "WHEN SUM(s.time3SalesAmount) >= GREATEST(" +
            "SUM(s.time1SalesAmount), " +
            "SUM(s.time2SalesAmount), " +
            "SUM(s.time4SalesAmount), " +
            "SUM(s.time5SalesAmount), " +
            "SUM(s.time6SalesAmount)) THEN 'time_3' " +
            "WHEN SUM(s.time4SalesAmount) >= GREATEST(" +
            "SUM(s.time1SalesAmount), " +
            "SUM(s.time2SalesAmount), " +
            "SUM(s.time3SalesAmount), " +
            "SUM(s.time5SalesAmount), " +
            "SUM(s.time6SalesAmount)) THEN 'time_4' " +
            "WHEN SUM(s.time5SalesAmount) >= GREATEST(" +
            "SUM(s.time1SalesAmount), " +
            "SUM(s.time2SalesAmount), " +
            "SUM(s.time3SalesAmount), " +
            "SUM(s.time4SalesAmount), " +
            "SUM(s.time6SalesAmount)) THEN 'time_5' " +
            "ELSE 'time_6' " +
            "END AS highestSalesTime " +
            "FROM Sales s " +
            "WHERE s.careaCode = :careaCode")
    String findBestSalesTime(String careaCode);


    Sales findTopByCareaCodeOrderByQuarterSalesAmountDesc(String careaCode);

}
