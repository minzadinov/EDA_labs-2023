Lab 4 JMS
=
Данная работа является продолжением лабораторной работы #3, с предметной областью - IT проекты.

В ходе данной работы был создан механизм журналирования. 

Для этого были созданы 2 дополнительные сущности - EmailEntity, WatchDogEntity, далее
использовался Spring AOP - который перехватывал выполнения выбранных методов для отправки сообщения объекту назначения.

Для уведомления был выбраны save, delete методы.

