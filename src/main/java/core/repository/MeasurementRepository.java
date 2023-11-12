package core.repository;

import core.entity.MeasurementEntity;
import core.entity.RegisteredSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
}
