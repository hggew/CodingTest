-- 코드를 입력하세요
SELECT year(SALES_DATE)year, Month(SALES_DATE) month, 
        count(DISTINCT u.USER_ID) as PUCHASED_USERS, 
        ROUND(count(DISTINCT u.USER_ID)
              /(select count(*) from USER_INFO where year(joined) = 2021 ), 1) as PUCHASED_RATIO
from USER_INFO u right join online_sale o
on u.user_id = o.user_id
where year(u.joined) = 2021
group by year, month
order by year, month;

 