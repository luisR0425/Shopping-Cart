-- -------------------------------------------------------
-- Table "PRODUCTS"
-- -------------------------------------------------------
CREATE TABLE PRODUCTS (
  "id" SERIAL NOT NULL,
  "nombre" VARCHAR(45) NOT NULL,
  "sku" VARCHAR(150),
  "descripcion" VARCHAR(1000),
  PRIMARY KEY ("id"));

-- -------------------------------------------------------
-- Table "CARTS"
-- -------------------------------------------------------
CREATE TABLE CARTS (
  "id" SERIAL NOT NULL,
  "status" CHAR(1) NOT NULL,
  PRIMARY KEY ("id"));

-- -------------------------------------------------------
-- Table "PRODUCT_CARS"
-- -------------------------------------------------------
CREATE TABLE PRODUCTS_CARS (
  "product_id" INT NOT NULL,
  "cart_id" INT NOT NULL,
  "quantity" INT NULL,
  PRIMARY KEY ("product_id", "cart_id"),
  CONSTRAINT "fk_products_cars_products"
    FOREIGN KEY ("product_id")
    REFERENCES PRODUCTS ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_products_cars_carts"
    FOREIGN KEY ("cart_id")
    REFERENCES CARTS ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);