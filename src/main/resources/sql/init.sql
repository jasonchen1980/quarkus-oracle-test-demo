use quarkus_test;

CREATE TABLE persons(
    person_id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    PRIMARY KEY(person_id)
);

INSERT INTO persons (first_name, last_name) VALUES ("CHEN", "JASON");