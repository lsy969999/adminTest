pgdocker
```
docker run -d --name my-postgres-container --restart always -e POSTGRES_USER=myuser -e POSTGRES_PASSWORD=mypassword -e POSTGRES_DB=mydatabase -p 5432:5432 -v /mypostgres:/var/lib/postgresql/data postgres:latest
```

```
docker exec -it my-postgres-container /bin/bash
```