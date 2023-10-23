-- 코드를 입력하세요
SELECT j.FLAVOR
from first_half f join july j
on f.flavor = j.flavor
group by f.flavor
order by sum(f.TOTAL_ORDER) + sum(j.TOTAL_ORDER) desc
limit 3;