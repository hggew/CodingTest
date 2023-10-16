-- 코드를 입력하세요
SELECT o.product_id, product_name, (price*amount) total_sales 
from food_product p join food_order o
on p.product_id = o.product_id
where year(o.produce_date) = 2022 and month(o.produce_date) = 5
group by product_id
order by total_sales desc, o.product_id;


SELECT FD.PRODUCT_ID,
       PRODUCT_NAME, SUM(PRICE * AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS FD
LEFT JOIN FOOD_ORDER AS FO ON FD.PRODUCT_ID = FO.PRODUCT_ID
WHERE LEFT(FO.PRODUCE_DATE, 7) = '2022-05'
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC