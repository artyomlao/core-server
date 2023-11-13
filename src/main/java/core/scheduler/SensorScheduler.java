package core.scheduler;

import core.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SensorScheduler {

    private final SensorsService sensorService;

    @Autowired
    public SensorScheduler(final SensorsService sensorService) {
        this.sensorService = sensorService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void sendData() {
        sensorService.disableSensors();
    }
}
