-- 코드를 입력하세요
SELECT round(avg(daily_fee),0) 'AVERAGE_FEE'
from CAR_RENTAL_COMPANY_CAR 
where CAR_TYPE ='SUV'
