# Resliv
Test for Resliv

Для работы проекта потребуется: Java 13, PostgreSQL 10.

После утсановки PostgreSQL необходимо прописать пути к папке lib и папке bin в корне приложения:
https://sqlbackupandftp.com/blog/setting-windows-path-for-postgres-tools

После того, как пути были прописаны необходимо в консоли прописать:
initdb -D /usr/local/pgsql/resliv -E UTF8 --username=postgres

После чего будет создана база данных, к которой можно будет подключиться прописав в консоли:
pg_ctl -D /usr/local/pgsql/resliv start

Если будет использовать иная СУБД, то необходимо внести соответствующие правки в файлы:
src/main/resources/application.properties 
src/main/resources/hibernate.cfg.xml

После того, как СУБД будет настроена проект может быть запущен.

Для управления данными необходимо в адресной строке браузера ввести следующий адрес:
http://localhost:8080

