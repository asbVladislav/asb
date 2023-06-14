
CREATE TABLE currency (
                          cur_id INT primary key ,
                          cur_parentid INT,
                          cur_code INT,
                          cur_abbreviation VARCHAR(10),
                          cur_name VARCHAR(100),
                          cur_name_bel VARCHAR(255),
                          cur_name_eng VARCHAR(255),
                          cur_quot_name VARCHAR(255),
                          cur_quot_name_bel VARCHAR(255),
                          cur_quot_name_eng VARCHAR(255),
                          cur_name_multi VARCHAR(255),
                          cur_name_bel_multi VARCHAR(255),
                          cur_name_eng_multi VARCHAR(255),
                          cur_scale INT,
                          cur_periodicity INT,
                          cur_date_start DATE,
                          cur_date_end DATE
);