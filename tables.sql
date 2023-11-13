CREATE TABLE IF NOT EXISTS public.registered_sensor
(
    id bigint NOT NULL,
    name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    key character varying(36) COLLATE pg_catalog."default" NOT NULL,
    active boolean,
    CONSTRAINT registered_sensor_pk PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS public.measurement
(
    id bigint NOT NULL,
    value double precision NOT NULL,
    raining bigint NOT NULL,
    sensor_id bigint NOT NULL,
    server_time timestamp without time zone,
    CONSTRAINT measurement_pk PRIMARY KEY (id),
    CONSTRAINT measurement_registered_sensor_id_fk FOREIGN KEY (sensor_id)
    REFERENCES public.registered_sensor (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);