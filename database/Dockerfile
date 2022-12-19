FROM postgres

ENV POSTGRES_DB="population"
ENV POSTGRES_PASSWORD="possu"

COPY init.sql /docker-entrypoint-initdb.d/
