FROM postgres

ENV POSTGRES_DB="population"

# Use trust auth to simplify usage as this db is used only in local connections
ENV POSTGRES_HOST_AUTH_METHOD="trust"

COPY init.sql /docker-entrypoint-initdb.d/
