package core.controller;

import core.entity.MeasurementEntity;
import core.model.KeyModel;
import core.model.MeasurementsModel;
import core.model.NameModel;
import core.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;

    @Autowired
    public SensorsController(final SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @PostMapping("/registration")
    public ResponseEntity<KeyModel> registration(final @RequestBody NameModel nameModel) {
        return ResponseEntity.ok(sensorsService.registerSensor(nameModel));
    }

    @PostMapping("{key}/measurements")
    public ResponseEntity<MeasurementEntity> measurements(
            final @RequestBody MeasurementsModel measurementsModel, @PathVariable final String key) {

        return ResponseEntity.ok(sensorsService.registerInfo(measurementsModel, key));
    }
}
