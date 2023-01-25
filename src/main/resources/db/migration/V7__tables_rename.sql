CREATE TABLE vehicle_details
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    created_at           datetime              NULL,
    updated_at           datetime              NULL,
    year_of_manufacture  VARCHAR(20)           NULL,
    trim                 VARCHAR(255)          NULL,
    color                VARCHAR(255)          NULL,
    `condition`          VARCHAR(255)          NULL,
    transmission         VARCHAR(255)          NULL,
    mileage              VARCHAR(255)          NULL,
    vin_chassis_no       VARCHAR(20)           NULL,
    is_registered        BIT(1)                NOT NULL,
    is_exchange_possible BIT(1)                NOT NULL,
    fuel                 VARCHAR(255)          NULL,
    drive_train          VARCHAR(255)          NULL,
    no_of_seats          INT                   NOT NULL,
    no_of_cylinders      INT                   NOT NULL,
    engine_size          VARCHAR(255)          NULL,
    horse_power          VARCHAR(255)          NULL,
    `description`        VARCHAR(3000)         NULL,
    features             VARCHAR(3000)         NULL,
    CONSTRAINT pk_vehicle_details PRIMARY KEY (id)
);

CREATE TABLE vehicles
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    created_at         datetime              NULL,
    updated_at         datetime              NULL,
    brand_id           BIGINT                NULL,
    model_id           BIGINT                NULL,
    category_id        BIGINT                NULL,
    price              INT                   NOT NULL,
    vehicle_details_id BIGINT                NULL,
    CONSTRAINT pk_vehicles PRIMARY KEY (id)
);

CREATE TABLE vehicles_images
(
    vehicle_id BIGINT NOT NULL,
    images_id  BIGINT NOT NULL
);

ALTER TABLE vehicles_images
    ADD CONSTRAINT uc_vehicles_images_images UNIQUE (images_id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brands (id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_MODEL FOREIGN KEY (model_id) REFERENCES models (id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_VEHICLEDETAILS FOREIGN KEY (vehicle_details_id) REFERENCES vehicle_details (id);

ALTER TABLE users_vehicles
    ADD CONSTRAINT fk_userveh_on_vehicle FOREIGN KEY (vehicles_id) REFERENCES vehicles (id);

ALTER TABLE vehicles_images
    ADD CONSTRAINT fk_vehima_on_image FOREIGN KEY (images_id) REFERENCES images (id);

ALTER TABLE vehicles_images
    ADD CONSTRAINT fk_vehima_on_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);

ALTER TABLE cars
    DROP FOREIGN KEY FK_CARS_ON_BRAND;

ALTER TABLE cars
    DROP FOREIGN KEY FK_CARS_ON_CAR_DETAIL;

ALTER TABLE cars
    DROP FOREIGN KEY FK_CARS_ON_CATEGORY;

ALTER TABLE cars
    DROP FOREIGN KEY FK_CARS_ON_MODEL;

ALTER TABLE cars_images
    DROP FOREIGN KEY fk_carima_on_image;

ALTER TABLE cars_images
    DROP FOREIGN KEY fk_carima_on_vehicle;

ALTER TABLE users_vehicles
    DROP FOREIGN KEY fk_useveh_on_vehicle;

DROP TABLE car_details;

DROP TABLE cars;

DROP TABLE cars_images;