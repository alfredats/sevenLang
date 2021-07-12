# Seven Databases in Seven weeks

### Setting up

I will be trying to use docker containers running the respective databases. I don't really weanna deal with potentially 7 new users (one for each db) on my machine.

#### Postgres
```bash
docker pull postgres:13-alpine
```

##### Starting and running the postgres docker image

For a video walkthrough see [here](https://www.youtube.com/watch?v=aHbE3pTyG-Q) (up to 13:20)

```bash
## Starting the container
docker run --name postgres_0 -e POSTGRES_PASSWORD=<set a password here> -d -p 5432:5432 postgres:13-alpine
## Connecting directly 
docker run -it --user postgres postgres_0 /bin/bash
```
You could also choose to run `docker run -it postgres_0 /bin/bash`, after which you access `psql` with `psql -U postgres`. If we wanted to emulate using the docker container as a remote postgres database, we'd run `psql -h <hostname> -p <port> -U <username>`.

##### Random tidbits of info
1. Relational databases are named as such because they are relational based on mathematics (relational algebra). It is not because the tables "relate" to each other via table keys.


