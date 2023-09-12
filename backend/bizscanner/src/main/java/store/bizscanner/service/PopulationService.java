package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.response.BestPopulationResponse;
import store.bizscanner.entity.Population;
import store.bizscanner.entity.enums.Age;
import store.bizscanner.entity.enums.Day;
import store.bizscanner.entity.enums.Gender;
import store.bizscanner.entity.enums.Time;
import store.bizscanner.repository.PopulationRepository;

import java.util.PriorityQueue;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PopulationService {

    private final PopulationRepository populationRepository;

    public BestPopulationResponse bestPopulation(String careaCode) {
        Population population = populationRepository.findTopByCareaCodeOrderByYearCodeDescQuarterCodeDesc(careaCode);

        return new BestPopulationResponse(
                (Gender) getBestGender(population),
                (Age) getBestAge(population),
                (Day) getBestDay(population),
                (Time) getBestTime(population)
        );
    }

    public static class Best implements Comparable<Best> {
        Integer value;
        Object object;

        public Best (Integer value, Object object) {
            this.value = value;
            this.object = object;
        }
        @Override
        public int compareTo(Best o) {
            return o.value - this.value;
        }
    }

    public Object getBestGender(Population population) {
        PriorityQueue<Best> pq = new PriorityQueue<>();

        pq.add(new Best(population.getMalePopulation(), Gender.MALE));
        pq.add(new Best(population.getFemalePopulation(), Gender.FEMALE));

        return pq.poll().object;
    }

    public Object getBestAge(Population population) {
        PriorityQueue<Best> pq = new PriorityQueue<>();

        pq.add(new Best(population.getTeensPopulation(), Age.TEENS));
        pq.add(new Best(population.getTwentiesPopulation(), Age.TWENTIES));
        pq.add(new Best(population.getThirtiesPopulation(), Age.THIRTIES));
        pq.add(new Best(population.getFortiesPopulation(), Age.FORTIES));
        pq.add(new Best(population.getFiftiesPopulation(), Age.FIFTIES));
        pq.add(new Best(population.getSixtiesPopulation(), Age.SIXTIES));

        return pq.poll().object;
    }

    public Object getBestDay(Population population) {
        PriorityQueue<Best> pq = new PriorityQueue<>();

        pq.add(new Best(population.getMondayPopulation(), Day.MONDAY));
        pq.add(new Best(population.getTuesdayPopulation(), Day.TUESDAY));
        pq.add(new Best(population.getWednesdayPopulation(), Day.WEDNESDAY));
        pq.add(new Best(population.getThursdayPopulation(), Day.THURSDAY));
        pq.add(new Best(population.getFridayPopulation(), Day.FRIDAY));
        pq.add(new Best(population.getSaturdayPopulation(), Day.SATURDAY));
        pq.add(new Best(population.getSundayPopulation(), Day.SUNDAY));

        return pq.poll().object;
    }

    public Object getBestTime(Population population) {
        PriorityQueue<Best> pq = new PriorityQueue<>();

        pq.add(new Best(population.getTime1Population(), Time.TIME1));
        pq.add(new Best(population.getTime2Population(), Time.TIME2));
        pq.add(new Best(population.getTime3Population(), Time.TIME3));
        pq.add(new Best(population.getTime4Population(), Time.TIME4));
        pq.add(new Best(population.getTime5Population(), Time.TIME5));
        pq.add(new Best(population.getTime6Population(), Time.TIME6));

        return pq.poll().object;
    }
}
