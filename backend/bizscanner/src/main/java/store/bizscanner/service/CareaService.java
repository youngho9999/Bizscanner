package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.repository.CareaRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CareaService {
    private final CareaRepository careaRepository;
}
