package store.bizscanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "carea_recommend_normalized")
@IdClass(CareaRecommendNormalizedId.class)
@Getter
@NoArgsConstructor
public class CareaRecommendNormalized {

    @Id
    private String jcategoryCode;
    @Id
    private String careaCode;
    private Long monthlySalesAmount;
    private Integer rentAmount;
    private Long firstInvestmentAmount;
    private Double salesAmountRate;
    private Double salesAmountRateNormalized;
    private Double populationNormalized;
    private Double careaChangeNormalized;
}
