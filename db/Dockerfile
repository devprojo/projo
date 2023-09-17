FROM postgres:16.0
ENV POSTGRES_DB=mydatabase
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
# Expose the PostgreSQL default port
EXPOSE 5432
# Optionally, you can include initialization scripts
COPY init.sql /docker-entrypoint-initdb.d/
# Start PostgreSQL when the container starts
CMD ["postgres"]
