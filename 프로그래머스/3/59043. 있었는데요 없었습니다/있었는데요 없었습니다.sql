SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o
join ANIMAL_INS i
on o.ANIMAL_ID = i.ANIMAL_ID
where i.datetime > o.datetime
order by i.DATETIME