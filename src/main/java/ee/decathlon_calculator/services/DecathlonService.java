package ee.decathlon_calculator.services;

import ee.decathlon_calculator.repositories.DecathlonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DecathlonService {

    private final DecathlonRepository decathlonRepository;
}
