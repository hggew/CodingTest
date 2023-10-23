-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(price*sales_amount ) SALES
from product join offline_sale
on product.product_id = offline_sale.product_id
group by product.product_id
order by sales desc, product_code;
 