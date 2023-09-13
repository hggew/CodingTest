-- 코드를 입력하세요
SELECT count(user_id)
from user_info
where date_format(joined, '%y') = 21  and age between 20 and 29;
 