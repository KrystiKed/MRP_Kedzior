# Protokoll zur Intermediate-Abgabe - Software Engineering 1



### Beschreibung



###### Die Media Ratings Platform (MRP) ist ein kleiner REST-Server in Java ohne Frameworks auf Basis von com.sun.net.httpserver.HttpServer. Für die Intermediate-Abgabe sind Userregistrierung und Login mit Token umgesetzt. Userdaten liegen zur Laufzeit in einer Map und werden zusätzlich in data/users.json gespeichert und beim Start geladen. Tokens werden beim Login neu erzeugt und nicht persistiert. Die Anwendung startet lokal unter http://localhost:8080. Die Postman-Collection wurde importiert und erfolgreich ausgeführt. Es wurden 5 Test-User angelegt.



### Struktur

###### 

###### Die Anwendung ist in klare Schichten aufgeteilt. Server startet den HTTP-Server und bindet den Router, der anhand von Methode und Pfad an den passenden Controller verteilt, in diesem Fall an den UserController. Request und Response kapseln die Arbeit mit HttpExchange und vereinfachen JSON I\&O. UserController verarbeitet die HTTP-Requests, liest den JSON-Body und gibt passende Statuscodes zurück. UserHandler validiert Eingaben grob und delegiert an die Logik. UserService implementiert Registrierung und Login und nutzt dazu IUserStorage/UserStorage (Persistenz in data/users.json), DataStore (In-Memory-Map usersByName) und AuthService (Token Generierung). Das Modell besteht aus User mit username und password. Für die JSON-(De)Serialisierung wird die Hilfsklasse Json.java verwendet.



### Entscheidungen



###### Ich verwende den eingebauten HttpServer, um Abhängigkeiten gering zu halten und die Checkliste „kein Framework“ einzuhalten. Die Persistenz erfolgt bewusst in einer JSON-Datei, weil das später leicht durch eine Datenbank ersetzt werden kann. Die Tokens werden bei jedem Login neu erzeugt, was die Implementierung einfach hält. Die Postman-Collection liegt im Repo und dient als Nachweis der Endpoints für Login und Registrierung. Lokal habe ich Commits bei Bedarf mit Amend/Rebase/Reset bereinigt, damit die öffentliche History auf GitHub dadurch übersichtlich und sauber bleibt.

