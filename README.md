# GraphQL + Spring Boot + PostgreSQL

Sample project testing GraphQL with Spring Boot and PostgreSQL running in a container. 

Useful as a guide as you will need to create the proper PostgreSQL tables to run this project.

## Getting Started

### Prerequisites

* Maven
* Docker

### PostgreSQL
Set up a PostgreSQL image on your machine. We will also want to set up a volume so we can persist data. POSTGRES_USER, POSTGRES_PASSWORD, POSTGRES_DB are environment variables that can be changed.

````
docker run --rm   --name pg-docker -e POSTGRES_USER=postgres POSTGRES_PASSWORD=docker POSTGRES_DB=postgres -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres
````

We can connect to our PostgreSQL instance using:
````
docker exec --tty --interactive pg-docker psql -h localhost -U postgres -d postgres
````

Sample scripts used for database:
````
CREATE TABLE public.person
(
    person_id integer NOT NULL,
    first_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default",
    address_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (person_id),
    CONSTRAINT fkk7rgn6djxsv2j2bv1mvuxd4m9 FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;
````

````
CREATE TABLE public.address
(
    id integer NOT NULL,
    address text COLLATE pg_catalog."default",
    CONSTRAINT address_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.address
    OWNER to postgres;
````
## Deployment

* Build the JAR file
````
mvn clean install
````

* Build the Docker image
````
docker build -t graphqlperson .
````

* Run Docker Compose to start up the Spring Boot Application and PostgreSQL database
````
docker-compose up -d
````

## GraphiQL

GraphiQL is included in the project which gives us a nice UI to query our GraphQL schemas.

````
http://localhost:8080/graphiql/
````