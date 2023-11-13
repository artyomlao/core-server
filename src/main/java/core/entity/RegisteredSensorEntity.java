package core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Table(name = "registered_sensor")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisteredSensorEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registered_sensor_generator")
    @SequenceGenerator(name = "registered_sensor_generator", sequenceName = "registered_sensor_sq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "key")
    private String key;

    @Column(name = "active")
    private boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<MeasurementEntity> measurements;
}
