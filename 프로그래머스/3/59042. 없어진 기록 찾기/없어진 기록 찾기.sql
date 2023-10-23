-- 코드를 입력하세요
SELECT ANIMAL_ID, name
from animal_outs 
where animal_id not in ( select animal_outs.animal_id 
                        from animal_outs left join animal_ins
                        on animal_outs.ANIMAL_ID = animal_ins.ANIMAL_ID);
                        
 select o.animal_id, o.name
 from animal_outs o left join animal_ins i
 on o.ANIMAL_ID = i.ANIMAL_ID
 where i.datetime is null;
                         