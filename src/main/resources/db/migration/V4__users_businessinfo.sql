CREATE TABLE business_info
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    business_name VARCHAR(500)          NULL,
    slug          VARCHAR(500)          NULL,
    address       VARCHAR(500)          NULL,
    `description` VARCHAR(2000)         NULL,
    working_hours VARCHAR(500)          NULL,
    working_days  VARCHAR(500)          NULL,
    CONSTRAINT pk_business_info PRIMARY KEY (id)
);

CREATE TABLE users
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    name             VARCHAR(255)          NULL,
    email            VARCHAR(255)          NULL,
    image            VARCHAR(500)          NULL,
    phone            VARCHAR(255)          NULL,
    location         VARCHAR(255)          NULL,
    business_info_id BIGINT                NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_vehicles
(
    user_id     BIGINT NOT NULL,
    vehicles_id BIGINT NOT NULL,
    CONSTRAINT pk_users_vehicles PRIMARY KEY (user_id, vehicles_id)
);

ALTER TABLE business_info
    ADD CONSTRAINT uc_business_info_businessname UNIQUE (business_name);

ALTER TABLE business_info
    ADD CONSTRAINT uc_business_info_slug UNIQUE (slug);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_phone UNIQUE (phone);

ALTER TABLE users_vehicles
    ADD CONSTRAINT uc_users_vehicles_vehicles UNIQUE (vehicles_id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_BUSINESSINFO FOREIGN KEY (business_info_id) REFERENCES business_info (id);

ALTER TABLE users_vehicles
    ADD CONSTRAINT fk_useveh_on_user FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users_vehicles
    ADD CONSTRAINT fk_useveh_on_vehicle FOREIGN KEY (vehicles_id) REFERENCES cars (id);