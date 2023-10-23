-- 코드를 입력하세요


SELECT o.ANIMAL_ID, o.NAME 
from animal_outs o join animal_ins i
on o.animal_id = i.animal_id
where i.datetime > o.datetime 
order by i.datetime;  


 