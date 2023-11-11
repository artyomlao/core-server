package core.repository;

import core.entity.RegisteredSensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepository extends JpaRepository<RegisteredSensorEntity, Long> {

    boolean existsByName(final String name);
}
