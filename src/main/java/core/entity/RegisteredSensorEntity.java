package core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Table(name = "registered_sensor")
@Entity
@Accessors(chain = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
