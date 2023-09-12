package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.bizscanner.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {


}
