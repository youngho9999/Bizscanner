package store.bizscanner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Population {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "population_id")
    private Long id;

    private String yearCode;
    private String quarterCode;
    private String careaTypeCode;
    private String careaTypeName;
    private String careaCode;
    private String careaName;

    private Integer totalPopulation;
    private Integer malePopulation;
    private Integer femalePopulation;
    private Integer teensPopulation;
    private Integer twentiesPopulation;
    private Integer thirtiesPopulation;
    private Integer fortiesPopulation;
    private Integer fiftiesPopulation;
    private Integer sixtiesPopulation;

    @Column(name = "time_1_population")
    private Integer time1Population;
    @Column(name = "time_2_population")
    private Integer time2Population;
    @Column(name = "time_3_population")
    private Integer time3Population;
    @Column(name = "time_4_population")
    private Integer time4Population;
    @Column(name = "time_5_population")
    private Integer time5Population;
    @Column(name = "time_6_population")
    private Integer time6Population;

    private Integer mondayPopulation;
    private Integer tuesdayPopulation;
    private Integer wednesdayPopulation;
    private Integer thursdayPopulation;
    private Integer fridayPopulation;
    private Integer saturdayPopulation;
    private Integer sundayPopulation;

    private Integer maleTeensPopulation;
    private Integer femaleTeensPopulation;
    private Integer maleTwentiesPopulation;
    private Integer femaleTwentiesPopulation;
    private Integer maleThirtiesPopulation;
    private Integer femaleThirtiesPopulation;
    private Integer maleFortiesPopulation;
    private Integer femaleFortiesPopulation;
    private Integer maleFiftiesPopulation;
    private Integer femaleFiftiesPopulation;
    private Integer maleOversixtiesPopulation;
    private Integer femaleOversixtiesPopulation;

    public Population(String yearCode, String quarterCode, String careaTypeCode, String careaTypeName, String careaCode, String careaName, Integer totalPopulation, Integer malePopulation, Integer femalePopulation, Integer teensPopulation, Integer twentiesPopulation, Integer thirtiesPopulation, Integer fortiesPopulation, Integer fiftiesPopulation, Integer sixtiesPopulation, Integer time1Population, Integer time2Population, Integer time3Population, Integer time4Population, Integer time5Population, Integer time6Population, Integer mondayPopulation, Integer tuesdayPopulation, Integer wednesdayPopulation, Integer thursdayPopulation, Integer fridayPopulation, Integer saturdayPopulation, Integer sundayPopulation, Integer maleTeensPopulation, Integer femaleTeensPopulation, Integer maleTwentiesPopulation, Integer femaleTwentiesPopulation, Integer maleThirtiesPopulation, Integer femaleThirtiesPopulation, Integer maleFortiesPopulation, Integer femaleFortiesPopulation, Integer maleFiftiesPopulation, Integer femaleFiftiesPopulation, Integer maleOversixtiesPopulation, Integer femaleOversixtiesPopulation) {
        this.yearCode = yearCode;
        this.quarterCode = quarterCode;
        this.careaTypeCode = careaTypeCode;
        this.careaTypeName = careaTypeName;
        this.careaCode = careaCode;
        this.careaName = careaName;
        this.totalPopulation = totalPopulation;
        this.malePopulation = malePopulation;
        this.femalePopulation = femalePopulation;
        this.teensPopulation = teensPopulation;
        this.twentiesPopulation = twentiesPopulation;
        this.thirtiesPopulation = thirtiesPopulation;
        this.fortiesPopulation = fortiesPopulation;
        this.fiftiesPopulation = fiftiesPopulation;
        this.sixtiesPopulation = sixtiesPopulation;
        this.time1Population = time1Population;
        this.time2Population = time2Population;
        this.time3Population = time3Population;
        this.time4Population = time4Population;
        this.time5Population = time5Population;
        this.time6Population = time6Population;
        this.mondayPopulation = mondayPopulation;
        this.tuesdayPopulation = tuesdayPopulation;
        this.wednesdayPopulation = wednesdayPopulation;
        this.thursdayPopulation = thursdayPopulation;
        this.fridayPopulation = fridayPopulation;
        this.saturdayPopulation = saturdayPopulation;
        this.sundayPopulation = sundayPopulation;
        this.maleTeensPopulation = maleTeensPopulation;
        this.femaleTeensPopulation = femaleTeensPopulation;
        this.maleTwentiesPopulation = maleTwentiesPopulation;
        this.femaleTwentiesPopulation = femaleTwentiesPopulation;
        this.maleThirtiesPopulation = maleThirtiesPopulation;
        this.femaleThirtiesPopulation = femaleThirtiesPopulation;
        this.maleFortiesPopulation = maleFortiesPopulation;
        this.femaleFortiesPopulation = femaleFortiesPopulation;
        this.maleFiftiesPopulation = maleFiftiesPopulation;
        this.femaleFiftiesPopulation = femaleFiftiesPopulation;
        this.maleOversixtiesPopulation = maleOversixtiesPopulation;
        this.femaleOversixtiesPopulation = femaleOversixtiesPopulation;
    }
}
