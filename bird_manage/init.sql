CREATE TABLE food (
    food_id SERIAL PRIMARY KEY,
    category VARCHAR(10) NOT NULL,
    portion FLOAT,
    time_stamp timestamp NOT NULL,
    operator VARCHAR(50)
);

CREATE TABLE water (
    change_id SERIAL PRIMARY KEY,
    time_stamp timestamp NOT NULL,
    operator VARCHAR(50)
);

CREATE TABLE illness (
    illness_id SERIAL PRIMARY KEY,
    symptom VARCHAR(50) NOT NULL,
    start_time timestamp NOT NULL,
    end_time timestamp,
    hospital_flag INTEGER
);