package core.service;

import core.entity.MeasurementEntity;
import core.entity.RegisteredSensorEntity;
import core.model.KeyModel;
import core.model.MeasurementsModel;
import core.model.NameModel;
import core.model.exception.EntityNotFoundException;
import core.model.exception.InvalidSensorNameException;
import core.repository.MeasurementRepository;
import core.repository.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SensorsService {

    private final SensorsRepository sensorsRepository;
    private final MeasurementRepository measurementRepository;

    @Autowired
    public SensorsService(
            final SensorsRepository sensorsRepository, final MeasurementRepository measurementRepository) {

        this.sensorsRepository = sensorsRepository;
        this.measurementRepository = measurementRepository;
    }

    public KeyModel registerSensor(final NameModel nameModel) {
        validateSensor(nameModel);
        final String key = UUID.randomUUID().toString();

        sensorsRepository.save(new RegisteredSensorEntity()
                .setName(nameModel.getName())
                .setKey(key));

        return new KeyModel(key);
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

    public MeasurementEntity registerInfo(final MeasurementsModel model, final String key) {
        final RegisteredSensorEntity entity = sensorsRepository.findByKey(key);

        if (entity == null) {
            throw new EntityNotFoundException("Key doesn't exist");
        }

        return measurementRepository.save(new MeasurementEntity()
                .setValue(model.getValue())
                .setRaining(model.getRaining())
                .setSensorId(entity.getId())
                .setServerTime(Timestamp.valueOf(LocalDateTime.now())));
    }
}
