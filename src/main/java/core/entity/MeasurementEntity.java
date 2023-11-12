package core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import core.converter.LongToBooleanConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Table(name = "measurement")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MeasurementEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_generator")
    @SequenceGenerator(name = "measurement_generator", sequenceName = "measurement_sq", allocationSize = 1)
    private long id;

    @Column(name = "value")
    private Long value;

    @Convert(converter = LongToBooleanConverter.class)
    @Column(name = "raining")
    private Boolean raining;

    @Column(name = "server_time")
    private Timestamp serverTime;

    @Basic
    @Column(name = "sensor_id")
    private Long sensorId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sensor_id", insertable = false, updatable = false)
    private RegisteredSensorEntity sensor;
}
