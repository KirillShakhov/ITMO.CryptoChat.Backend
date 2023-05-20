package ru.itmo.cryptochat.server.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.itmo.cryptochat.server.repositories.CustomizedMessageCrudRepository;

import java.util.Date;
import java.util.Calendar;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class CleanerService {
    private final CustomizedMessageCrudRepository customizedMessageCrudRepository;

    @Transactional
    @Scheduled(fixedRate = 30000)
    public void greeting() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -1);
        Date oneHourBack = cal.getTime();
        customizedMessageCrudRepository.deleteByCreatedDateLessThan(oneHourBack);
    }
}
