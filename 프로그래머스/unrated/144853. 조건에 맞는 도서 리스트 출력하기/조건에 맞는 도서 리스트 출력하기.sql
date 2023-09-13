-- 코드를 입력하세요
SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
from book
where category = '인문' 
    and date_format(published_date, '%Y') = 2021
order by published_date;