Программа работает с базой данный mySQL. Для запуска необходимо изменить настройки подключения к базе данных в файле application.properties, находящийся по адресу src/main/resources/application.properties.
Далее собрать проект при помощи maven и запустить. Таблицы в базе данных создаются автоматически.

методы GET:
/user - возвращает всех пользователей
/user/{id} - возвращает пользователя с указанным id
/user/name={name} - возвращает список пользователей чьё имя совпадает с указанным значением(или частично совподает)
/contact - возвращает все контакты
/contact/{id} - возвращает контакт с указанным id
/contact/number={number} - возвращает список контактов чей номер совпадает с указанным значением

методы POST:
/user - добавляет пользователя в базу данных
/contact - добавляет контакт в базу данных

методы PUT
/user/{id} - изменяет пользователя с указанным id
/contact/{id} - изменяет контакт с указанным id

методы DELETE
/user/{id} - удаляет пользователя с указанным id, а также все его контакты
/contact/{id} - удаляет контакт с указанным id

Для unit тестов используется h2 in-memory database с настройками находящимися по адресу src/test/resources/application.properties.