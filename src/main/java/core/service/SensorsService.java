package core.service;

import core.entity.RegisteredSensorEntity;
import core.model.KeyModel;
import core.model.NameModel;
import core.model.exception.InvalidSensorNameException;
import core.repository.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(final SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public KeyModel registerSensor(final NameModel nameModel) {
        validateSensor(nameModel);
        sensorsRepository.save(new RegisteredSensorEntity().setName(nameModel.getName()));
        return new KeyModel(UUID.randomUUID().toString());
    }

    private void validateSensor(final NameModel nameModel) {
        final String sensorName = nameModel.getName();

        if (sensorName.length() < 3 || sensorName.length() > 30) {
            throw new InvalidSensorNameException("Sensor name length can't be less than 3 and greater than 30");
        }

        if (sensorsRepository.existsByName(nameModel.getName())) {
            throw new InvalidSensorNameException("Sensor name already exists. Choose another one");
        }
    }
}
