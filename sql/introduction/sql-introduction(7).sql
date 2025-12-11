USE my_shop;
SELECT price AS 가격 , stock_quantity AS 재고, price*stock_quantity AS 합계 FROM products;
SELECT price AS 가격 , stock_quantity AS 재고, price+3000 AS `배송비 포함` FROM products;

SELECT concat(name, ' ' , email) FROM customers;
SELECT CONCAT_WS('-', name, email) AS 컬럼 FROM customers;

select UPPER(email) from customers;

SELECT name, CHAR_LENGTH(name) AS char_length, LENGTH(name) AS byte_length FROM customers;

SELECT name, IFNULL(description, '상품 설명 미기재') AS description FROM products;
SELECT name, COALESCE(description, '상품 설명 미기재') AS description FROM products;
