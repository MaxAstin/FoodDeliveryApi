DROP TABLE IF EXISTS user;

CREATE TABLE menu_product
(
    menu_product_uuid VARCHAR PRIMARY KEY auto_increment,
    name              VARCHAR(128),
    cost              INT,
    discountCost      INT,
    weight            INT,
    description       VARCHAR(128),
    comboDescription  VARCHAR(128),
    photoLink         VARCHAR(MAX),
    productCode       VARCHAR(128),
    barcode           INT,
    visible           BOOL,
);