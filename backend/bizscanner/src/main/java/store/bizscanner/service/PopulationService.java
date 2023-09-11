package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.repository.PopulationRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PopulationService {

    private final PopulationRepository populationRepository;
}
