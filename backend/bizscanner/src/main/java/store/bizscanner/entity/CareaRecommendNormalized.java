package store.bizscanner.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "carea_recommend_normalized")
@IdClass(CareaRecommendNormalizedId.class)
public class CareaRecommendNormalized {

    @Id
    private String jcategoryCode;
    @Id
    private String careaCode;
    private Long monthlySalesAmount;
    private Integer rentAmount;
    private Double salesAmountRate;
    private Double salesAmountRateNormalized;
    private Double populationNormalized;
    private Double careaChangeNormalized;
}
