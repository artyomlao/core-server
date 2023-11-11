package core.controller;

import core.model.KeyModel;
import core.model.NameModel;
import core.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
