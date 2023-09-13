package store.bizscanner.dto.response.population;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PopulationResponse {
    private List<QuarterlyPopulationResponse> quarterlyPopulation;
    private Integer[] dayPopulation;
    private Integer[] timePopulation;
    private Integer[] genderPopulation;
    private Integer[] agePopulation;
    private Integer[] maleAgePopulation;
    private Integer[] femaleAgePopulation;
}
