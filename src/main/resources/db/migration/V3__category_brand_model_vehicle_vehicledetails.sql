CREATE TABLE brands
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_brands PRIMARY KEY (id)
);

CREATE TABLE car_details
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
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
    CONSTRAINT pk_car_details PRIMARY KEY (id)
);

CREATE TABLE cars_images
(
    vehicle_id BIGINT NOT NULL,
    images_id  BIGINT NOT NULL
);

CREATE TABLE category
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE images
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    `path` VARCHAR(255)          NULL,
    CONSTRAINT pk_images PRIMARY KEY (id)
);

CREATE TABLE models
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    vehicle_id BIGINT                NULL,
    CONSTRAINT pk_models PRIMARY KEY (id)
);

ALTER TABLE cars
    ADD brand_id BIGINT NULL;

ALTER TABLE cars
    ADD car_detail_id BIGINT NULL;

ALTER TABLE cars
    ADD category_id BIGINT NULL;

ALTER TABLE cars
    ADD model_id BIGINT NULL;

ALTER TABLE cars_images
    ADD CONSTRAINT uc_cars_images_images UNIQUE (images_id);

ALTER TABLE cars
    ADD CONSTRAINT FK_CARS_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brands (id);

ALTER TABLE cars
    ADD CONSTRAINT FK_CARS_ON_CAR_DETAIL FOREIGN KEY (car_detail_id) REFERENCES car_details (id);

ALTER TABLE cars
    ADD CONSTRAINT FK_CARS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE cars
    ADD CONSTRAINT FK_CARS_ON_MODEL FOREIGN KEY (model_id) REFERENCES models (id);

ALTER TABLE models
    ADD CONSTRAINT FK_MODELS_ON_VEHICLE FOREIGN KEY (vehicle_id) REFERENCES brands (id);

ALTER TABLE cars_images
    ADD CONSTRAINT fk_carima_on_image FOREIGN KEY (images_id) REFERENCES images (id);

ALTER TABLE cars_images
    ADD CONSTRAINT fk_carima_on_vehicle FOREIGN KEY (vehicle_id) REFERENCES cars (id);

ALTER TABLE cars
    DROP COLUMN brand;

ALTER TABLE cars
    DROP COLUMN category;

ALTER TABLE cars
    DROP COLUMN model;