# test_for_sber
Для запуска: java -jar target/test_sber.jar
В программе используется база данных, которую можно создать из файла table. Для соединения с ней используется локальная сеть,
поэтому необходимо поменять в DaoConnect хостинг и пароль и пересобрать jar: mkdir target && cp -r src/resources target &&
javac -d target  src/main/java/server/*/*  src/main/java/thinClient/* &&
jar cvfm target/test_sber.jar src/main/manifest.txt -C target/ .
