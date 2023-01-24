CREATE TABLE cars
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    brand    VARCHAR(255)          NULL,
    model    VARCHAR(255)          NULL,
    category VARCHAR(255)          NULL,
    price    INT                   NOT NULL,
    CONSTRAINT pk_cars PRIMARY KEY (id)
);

ALTER TABLE cars
    ADD CONSTRAINT uc_cars_brand UNIQUE (brand);