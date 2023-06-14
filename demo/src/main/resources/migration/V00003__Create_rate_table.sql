
CREATE TABLE rate (
                      id BIGINT AUTO_INCREMENT primary key ,
                      cur_id INTEGER,
                      cur_name VARCHAR(255),
                      cur_official_rate double,
                      cur_abbreviation VARCHAR(10),
                      date TIMESTAMP,
                      cur_scale INTEGER
);
