# Resliv
Test for Resliv

Для работы проекта потребуется: Java 13, PostgreSQL 10.
***
После утсановки PostgreSQL необходимо прописать пути к папке lib и папке bin в корне приложения:

https://sqlbackupandftp.com/blog/setting-windows-path-for-postgres-tools
***
После того, как пути были прописаны необходимо в консоли прописать:

initdb -D /usr/local/pgsql/resliv -E UTF8 --username=postgres
***
После чего будет создана база данных, к которой можно будет подключиться прописав в консоли:

pg_ctl -D /usr/local/pgsql/resliv start
***
Если будет использовать иная СУБД, то необходимо внести соответствующие правки в файлы:

src/main/resources/application.properties 

src/main/resources/hibernate.cfg.xml
***
После того, как СУБД будет настроена проект может быть запущен.
***
Для управления данными необходимо в адресной строке браузера ввести следующий адрес:

http://localhost:8080
***
Возможности по редактированию городов и сообщений представлены здесь:

https://github.com/PavelKisliuk/Resliv/blob/master/src/main/resources/img/Интерфейс.jpg

src/main/resources/img/Интерфейс.jpg
***
Данные бота:

username = ReslivTestBot

token = 1057831883:AAH2x4lXfBDn89_YYBQl_ZSUJ0jELRx7V6s
***
Система работает по следующей схеме:

Controller <-> Command <-> Service <-> Specification <-> Repository

1. Данные приходят на контроллер, в котором выбирается команда по обработке этих данных.
2. Данные приходят на команду, где должным образом извлекаются и передаются на определённый сервис.
3. Данные приходят на сервис, где передаются на определённую спецификацию, после чего формируется ответ, который возвращается в обратно порядке.
4. Данные приходят на спецификацию, которая используя репозитории осуществляет запросы к базе данных.
5. Репозитории осуществляют запросы к базе данных.

Телеграмм Бот работает сразу с сервисами, минуя стадию контроллера и команды. Бот принимает название города и возвращает привязанное к городу сообщение.