create database if not exists ordernow;

CREATE TABLE odn_user (
    id_user INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_user VARCHAR(150) NOT NULL,
    login_user VARCHAR(20),
    pwd_user VARCHAR(255),
    PRIMARY KEY (id_user)
);

CREATE TABLE odn_dishe (
    id_dishe INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_dishe VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_dishe)
);

CREATE TABLE odn_restaurant (
    id_restaurant INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_restaurant VARCHAR(50),
    id_dishe INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_restaurant),
    FOREIGN KEY (id_dishe) REFERENCES odn_dishe (id_dishe)
);

CREATE TABLE odn_product (
    id_product INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_product VARCHAR(50) NOT NULL,
    id_restaurant INT UNSIGNED NOT NULL,
    price_product DECIMAL(7,2),
    PRIMARY KEY (id_product),
    FOREIGN KEY (id_restaurant) REFERENCES odn_restaurant (id_restaurant)
);

CREATE TABLE odn_order (
    id_order INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_user INT UNSIGNED NOT NULL,
    id_restaurant INT UNSIGNED NOT NULL,
    in_status_order VARCHAR(10) NOT NULL,
    dt_order DATE,
    fl_aval VARCHAR(1),
    rating INT UNSIGNED,
    PRIMARY KEY (id_order),
    FOREIGN KEY (id_restaurant) REFERENCES odn_restaurant (id_restaurant),
    FOREIGN KEY (id_user) REFERENCES odn_user (id_user)
);

CREATE TABLE odn_order_product (
    id_order_product INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_order INT UNSIGNED NOT NULL,
    id_product INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_order_product),
    FOREIGN KEY (id_order) REFERENCES odn_order (id_order),
    FOREIGN KEY (id_product) REFERENCES odn_product (id_product)
);

INSERT INTO odn_dishe (id_dishe, nm_dishe) VALUES(1, 'Pizza');
INSERT INTO odn_dishe (id_dishe, nm_dishe) VALUES(2, 'Hamburguer');
INSERT INTO odn_dishe (id_dishe, nm_dishe) VALUES(3, 'Italian');
INSERT INTO odn_dishe (id_dishe, nm_dishe) VALUES(4, 'Brazilian');
