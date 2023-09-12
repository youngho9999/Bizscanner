package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import store.bizscanner.entity.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT s.jcategoryName FROM Store s " +
            "WHERE s.careaCode = :careaCode AND s.yearCode = :yearCode " +
            "AND s.storeCount = (SELECT MAX(s2.storeCount) FROM Store s2 " +
            "WHERE s2.careaCode = :careaCode AND s2.yearCode = :yearCode)")
    List<String> findMaxStoreCount(@Param("careaCode") String careaCode, @Param("yearCode") String yearCode);

    @Query("SELECT s.jcategoryName, MAX(s.openStoreCount) FROM Store s WHERE s.careaCode = :careaCode AND s.yearCode = :yearCode")
    Object findMaxOpenStoreCount(@Param("careaCode") String careaCode, @Param("yearCode") String yearCode);

    @Query("SELECT s.jcategoryName, MAX(s.closeStoreCount) FROM Store s WHERE s.careaCode = :careaCode AND s.yearCode = :yearCode")
    Object findMaxCloseStoreCount(@Param("careaCode") String careaCode, @Param("yearCode") String yearCode);
}
