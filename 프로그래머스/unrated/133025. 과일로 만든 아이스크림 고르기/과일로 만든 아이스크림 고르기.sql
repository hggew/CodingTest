-- 코드를 입력하세요
SELECT FIRST_HALF.flavor 
from FIRST_HALF LEFT JOIN ICECREAM_INFO
    on FIRST_HALF.flavor = ICECREAM_INFO.flavor 
where FIRST_HALF.TOTAL_ORDER >=3000
  and ICECREAM_INFO.INGREDIENT_TYPE ='fruit_based'
order by FIRST_HALF.total_order desc;

# SELECT customer.name, orders.saleprice -- 속성들
# FROM customer LEFT JOIN orders -- 테이블
# 	ON customer.custid = orders.custid; -- 조인조건

