# restApiDemo
RestApiDemo - zwraca dane użytkoników github.
Api wykorzystuje:
- Java 17,
- Spring boot 2.6.7,
- Lombok,
- Oracle 21c,
- JWT

Jak wyżej wspominałem, baza danych stoi na oracle 21c. Przed włączeniem api baza danych musi być gotowa. Odpalamy ją jako kontener w dockerze:  `docker run -dp 1521:1521 --name oracle_21 sdejnert/oracle`. Obraz bazy danych ma w sobie pliki inicjalizacyje, które tworzą użytkownika bazy danych: `restapi/restapi2022@XEPDB1`.

Struktura tabel tworzona jest podczas pierwszego włączania api poprzez Liquibase.

Api uruchamia sie na porcie 8070.
Zapytania do api:

1. Logowanie i utworzenie token'a - POST - [/restApiDemo/authenticate], przykład: http://localhost:8070/restApiDemo/authenticate
W body musimy wysłać dane logowania: 
`{
  "username": "rest",
  "password": "restapi2022"
}`
Api zwraca nam bearer token, który ważny jest przez godzinę. Token wysyłamy z przedrostkiem "Bearer ", czyli:
przykładowy token: `"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZXN0IiwiZXhwIjoxNjUzMTQ4MDA0LCJpYXQiOjE2NTMxMzAwMDR9._3miKjsbceWjNg2Dy1ENwDIPwCE1FjOqsYproSYgOjmmoGQ2YkQBXIaA_GZYu3ZYg7MmEhAFZaErAcvajzkbSQ"`
wysyłamy w takiej formie: `"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyZXN0IiwiZXhwIjoxNjUzMTQ4MDA0LCJpYXQiOjE2NTMxMzAwMDR9._3miKjsbceWjNg2Dy1ENwDIPwCE1FjOqsYproSYgOjmmoGQ2YkQBXIaA_GZYu3ZYg7MmEhAFZaErAcvajzkbSQ"`
2. Pobieranie danych użytkowników githab - GET [/restApiDemo/user/{login}], przykład: http://localhost:8070/restApiDemo/user/octocat
W Headers musimy wysłać klucz `Authorization` z wygenerowanym tokenem jako wartość.
