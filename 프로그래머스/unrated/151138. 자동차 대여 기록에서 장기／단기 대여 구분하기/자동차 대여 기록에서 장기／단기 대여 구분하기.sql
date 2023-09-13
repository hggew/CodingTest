-- 코드를 입력하세요
SELECT history_id, car_id, date_format(start_date, '%Y-%m-%d') 'START_DATE', 
        date_format(end_date, '%Y-%m-%d') 'END_DATE' ,
    case
        when datediff(end_date, start_date)+1 >= 30 then '장기 대여'
        else '단기 대여'
    end 'RENT_TYPE'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where  date_format(start_date, '%Y-%m') ='2022-09'
order by history_id desc;

-- 당일대여, 당일반납 = 1일