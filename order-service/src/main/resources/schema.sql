DROP TABLE if EXISTS purchase_order;
CREATE TABLE purchase_order
(
    id         uuid DEFAULT random_uuid() PRIMARY KEY,
    user_id    INT,
    product_id INT,
    price      NUMERIC(10, 2),
    status     VARCHAR(50)
);
