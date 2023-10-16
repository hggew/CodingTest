-- 코드를 입력하세요
SELECT o.product_id, product_name, sum(price*amount) total_sales 
from food_product p join food_order o
on p.product_id = o.product_id
where year(o.produce_date) = 2022 and month(o.produce_date) = 5
group by product_id
order by total_sales desc, o.product_id;