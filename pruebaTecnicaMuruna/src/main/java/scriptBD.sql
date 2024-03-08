CREATE TABLE usuarios (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    token VARCHAR(255),
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    active BOOLEAN
);

CREATE TABLE phones (
    usuario_id VARCHAR(255) REFERENCES usuarios(id),
    number VARCHAR(255),
    citycode VARCHAR(255),
    countrycode VARCHAR(255)
);