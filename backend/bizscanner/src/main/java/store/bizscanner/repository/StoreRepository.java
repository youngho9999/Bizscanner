package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import store.bizscanner.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT s.jcategoryName, MAX(s.storeCount) FROM Store s WHERE s.careaCode = :careaCode AND s.yearCode = :yearCode")
    Object findMaxStoreCount(@Param("careaCode") String careaCode, @Param("yearCode") String yearCode);

    @Query("SELECT s.jcategoryName, MAX(s.openStoreCount) FROM Store s WHERE s.careaCode = :careaCode AND s.yearCode = :yearCode")
    Object findMaxOpenStoreCount(@Param("careaCode") String careaCode, @Param("yearCode") String yearCode);


}
