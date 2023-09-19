package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.bizscanner.entity.CareaRecommendNormalized;
import store.bizscanner.entity.CareaRecommendNormalizedId;

@Repository
public interface CareaRecommendNormalizedRepository extends JpaRepository<CareaRecommendNormalized, CareaRecommendNormalizedId> {

}
