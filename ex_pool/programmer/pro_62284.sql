-- 코드를 입력하세요
# SELECT *
# FROM CART_PRODUCTS;

# SELECT CART_ID, NAME
# FROM CART_PRODUCTS;

# WITH PRODUCTS_MILK AS (
#     SELECT CART_ID
#     FROM CART_PRODUCTS
#     WHERE NAME IN ('Milk')
# ) 
# PRODUCTS_YOGURT AS (
#     SELECT CART_ID
#     FROM CART_PRODUCTS
#     WHERE NAME IN ('Yogurt')
# )
# SELECT M.CART_ID
# FROM PRODUCTS_MILK M JOIN PRODUCTS_YOGURT Y USING(CART_ID)
# ORDER BY 1;

-- 인라인 뷰 서브쿼리 활용
-- Milk를 구입한 장바구니 아이디를 조회한 테이블과
-- Yogurt를 구입한 장바구니 아이디를 조회한 테이블을
-- 조인하여 동시에 구입한 장바구니 �dept��이디를 찾고, 정렬한다.
SELECT M.CART_ID
FROM (
    SELECT CART_ID
    FROM CART_PRODUCTS
    WHERE NAME IN ('Milk')
    ) M 
    JOIN 
    (
    SELECT CART_ID
    FROM CART_PRODUCTS
    WHERE NAME IN ('Yogurt')
    ) Y 
    USING(CART_ID)
ORDER BY 1;
