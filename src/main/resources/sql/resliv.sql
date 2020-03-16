DROP TABLE Cities;
DROP TABLE Messages;


CREATE TABLE Messages
(
    message_Id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    message    text   NOT NULL UNIQUE,
    PRIMARY KEY (message_Id)
);

INSERT INTO Messages (message)
VALUES ('В Москве можно посетить следующие места: Останкинская телебашня, Большой театр, Музей-заповедник «Царицыно».'),
       ('В Минске можно посетить следующие места: Национальная библиотека, Театр оперы и балета, Лошицкий парк.'),
       ('В Риге можно посетить следующие места: Ратушная площадь, Этнографический музей, Ботанический сад.'),
       ('В Венеции можно посетить следующие места: Площадь Сан-Марко, Собор Сан-Марко, Мост Риальто.'),
       ('В Санкт-Петербурге можно посетить следующие места: Исаакиевский собор, Эрмитаж и Дворцовая площадь, Крейсер «Аврора».');

CREATE TABLE Cities
(
    city_Id    bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name       text   NOT NULL UNIQUE,
    message_Id bigint NOT NULL,
    FOREIGN KEY (message_Id) REFERENCES Messages (message_Id)
);

INSERT INTO Cities (name, message_Id)
VALUES ('МОСКВА', 1),
       ('МИНСК', 2),
       ('РИГА', 3),
       ('ВЕНЕЦИЯ', 4),
       ('САНКТ-ПЕТЕРБУРГ', 5),
       ('САНКТ ПЕТЕРБУРГ', 5),
       ('САНКТПЕТЕРБУРГ', 5),
       ('САНТ-ПЕТЕРБУРГ', 5),
       ('САНТ ПЕТЕРБУРГ', 5),
       ('САНТПЕТЕРБУРГ', 5),
       ('ЛЕНИНГРАД', 5),
       ('ПЕТРОГРАД', 5),
       ('ПИТЕР', 5);