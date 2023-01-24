CREATE TABLE models_trims
(
    model_id BIGINT NOT NULL,
    trims_id BIGINT NOT NULL,
    CONSTRAINT pk_models_trims PRIMARY KEY (model_id, trims_id)
);

CREATE TABLE trims
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_trims PRIMARY KEY (id)
);

ALTER TABLE models_trims
    ADD CONSTRAINT uc_models_trims_trims UNIQUE (trims_id);

ALTER TABLE models_trims
    ADD CONSTRAINT fk_modtri_on_model FOREIGN KEY (model_id) REFERENCES models (id);

ALTER TABLE models_trims
    ADD CONSTRAINT fk_modtri_on_trim FOREIGN KEY (trims_id) REFERENCES trims (id);