
# WEB-es alkalmazások (GEIAL333B)

2017.05

Zelena Patrik Gergő (W137BJ)

Kérvény Nyilvántartó Rendszer

A feladat célja egy olyan rendszer fejlesztése ami lehetővé teszi a hallgatói kérvények online ügyintézését.

A feladat megvalósítása:

Környezet:

OS: Arch Linux

IDE: IntelliJ

Technológia: Spring Boot

Adatbázis: MariaDB (RDBMS)


A feladat megvalósításához először a felhasználói hozzáféréseket hoztam létre. Három role került az adatbázisba. Így mindenki csak a saját jogosultságának megfelelő funkciókat éri el. 
Az authentikóció megvalósítása Spring Security segítségével  történt.
Az alkalmazás Maven multi-module alkalamzás. A szülő projekt tartalmazza a 8 belső modult amik az alkalamzás pontos műküdéséért felelősek.
Az adatbázis kapcsolat JPA és Hibernate technológiákkal lett megvalósítva.
Front-end be- és kilépésre is van lehetősége a felhasználónak így a Thymeleaf, template kezelő is a rendszer része.
Minden ROLE-hoz külön RestControllel tartozik amely a JSON fájlok előállításáért és fogadásáért a felelős.
Létezik egy elsődleges kontrollel ami a böngészéből való belépésért felelős.

Az alkalamzás a következő URL-eken kersztül  kommunikál:

REST Tábla:
![alt text](http://kephost.com/images/2017/05/08/Kepernyokeperrol2017-05-0810-01-25.png)
