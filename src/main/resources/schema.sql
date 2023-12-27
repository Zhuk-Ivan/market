create table products
(
    product_id bigint not null AUTO_INCREMENT,
    product_name varchar(255) not null,
    description varchar(255),
    cost numeric,
    notes varchar(255),
    special_notes varchar(255),
    primary key(product_id)
);

create table categories
(
    category_id bigint not null AUTO_INCREMENT,
    category_name varchar(255) not null,
    primary key(category_id)
);

create table categories_products
(
    category_product_id bigint not null AUTO_INCREMENT,
    category_id bigint not null,
    product_id bigint not null,
    primary key(category_product_id)
);

CREATE TABLE users (
    user_id bigint NOT NULL AUTO_INCREMENT,
    email varchar(255) DEFAULT NULL,
    password varchar(255) DEFAULT NULL,
    user_name varchar(255) DEFAULT NULL,
    PRIMARY KEY (user_id)
);


CREATE TABLE roles (
    role_id bigint NOT NULL AUTO_INCREMENT,
    role_name varchar(60) DEFAULT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);