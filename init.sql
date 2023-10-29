CREATE TABLE cars
(
    id                  SERIAL PRIMARY KEY,
    car_uid             uuid UNIQUE NOT NULL,
    brand               VARCHAR(80) NOT NULL,
    model               VARCHAR(80) NOT NULL,
    registration_number VARCHAR(20) NOT NULL,
    power               INT,
    price               INT         NOT NULL,
    type                VARCHAR(20)
        CHECK (type IN ('SEDAN', 'SUV', 'MINIVAN', 'ROADSTER')),
    availability        BOOLEAN     NOT NULL
);

CREATE TABLE payment
(
    id          SERIAL PRIMARY KEY,
    payment_uid uuid        NOT NULL,
    status      VARCHAR(20) NOT NULL
        CHECK (status IN ('PAID', 'CANCELED')),
    price       INT         NOT NULL
);

CREATE TABLE rental
(
    id          SERIAL PRIMARY KEY,
    rental_uid  uuid UNIQUE              NOT NULL,
    username    VARCHAR(80)              NOT NULL,
    payment_uid uuid                     NOT NULL,
    car_uid     uuid                     NOT NULL,
    date_from   TIMESTAMP WITH TIME ZONE NOT NULL,
    date_to     TIMESTAMP WITH TIME ZONE NOT NULL,
    status      VARCHAR(20)              NOT NULL
        CHECK (status IN ('IN_PROGRESS', 'FINISHED', 'CANCELED'))
);

alter table cars
    owner to postgres;

alter table payment
    owner to postgres;

alter table rental
    owner to postgres;


INSERT INTO cars (id, availability, brand, car_uid, model, power, price, registration_number, type)
values (1, true, 'Mercedes Benz', '109b42f3-198d-4c89-9276-a7520a7120ab', 'GLA 250', 249, 3500, 'ЛО777Х799', 'SEDAN'),
       (2, true, 'ВАЗ', '4b3dc63a-702a-11ee-b962-0242ac120002', '2108', 349, 400001, 'ВАЗ123', 'SUV'),
       (3, true, 'LADA', '4b3dc784-702a-11ee-b962-0242ac120002', 'Granta', 348, 400002, 'LADA123', 'MINIVAN'),
       (4, true, 'Audi', '4b3dc8b0-702a-11ee-b962-0242ac120002', 'Q7', 347, 400003, 'AUDI456', 'ROADSTER'),
       (5, true, 'BMW', '4b3dcf18-702a-11ee-b962-0242ac120002', '5', 346, 400004, 'BMW123', 'SEDAN'),
       (6, true, 'BMWX3', '4b3dd058-702a-11ee-b962-0242ac120002', 'е83', 345, 300005, 'BMWX321', 'SUV'),
       (7, true, 'Chevrolet', '4b3dd170-702a-11ee-b962-0242ac120002', 'Epica', 344, 300006, 'Chevrolet123', 'MINIVAN'),
       (8, true, 'Citroen', '4b3dd2a6-702a-11ee-b962-0242ac120002', 'C4', 343, 300007, 'Citroen1234', 'ROADSTER'),
       (9, true, 'Daewoo', '4b3dd3c8-702a-11ee-b962-0242ac120002', 'Nexia', 342, 300008, 'Daewoo123', 'SUV'),
       (10, true, 'FORD', '4b3dd4fe-702a-11ee-b962-0242ac120002', 'Explorer', 341, 300009, 'FORD123', 'MINIVAN'),
       (11, true, 'Audi', '4b3dc37e-702a-11ee-b962-0242ac120002', 'A3', 350, 400000, 'AUDI123', 'ROADSTER');