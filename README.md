# Ukážka memory leaku
Ukážka demonštruje memory leak na jednoduchej Spring Boot aplikácii. Aplikácia vystavuje REST endpoint
na získanie dát používateľa na URL http://localhost:8080/user/{user-company}/{user-id}.

Memory leak sa prejaví po dostatočne veľkom počte prevolaní REST API (kľudne aj s tým istým používateľom).
Jeho prejavom je zalogovaná výnimka `OutOfMemoryException` na štandardnom výstupe aplikácie a vygenerovaný
heap dump súbor v hlavnom adresári projektu (typicky nazvaný `java_pid<pid>.hprof`, v závislosti od použitého JDK).

Podstata memory leaku spočíva v chýbajúcej implementácii metód `hashCode` a `equals`
v triede [UserId](src/main/java/sk/softec/app/model/UserId.java). To spôsobuje, že cachovanie vyhľadania
používateľov nefunguje správne (kľúče - identifikátory používateľa - s rovnakými atribútmi sú vyhodnotené ako rôzne)
a dochádza k preplneniu cache.

- spustenie aplikácie: `run.bat`
- opakované vyvolanie REST endpoint-u aplikácie: `call_app.bat` (_pre rýchlejšie nasimulovanie memory leaku je vhodné skript pustiť paralelne viackrát_)
