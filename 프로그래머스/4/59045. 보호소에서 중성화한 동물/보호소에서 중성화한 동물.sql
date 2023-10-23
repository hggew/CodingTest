-- 코드를 입력하세요
SELECT o.ANIMAL_ID,	o.ANIMAL_TYPE, o.NAME
from animal_outs o left join animal_ins i
on o.animal_id = i.animal_id
where i.SEX_UPON_INTAKE like 'Intact%' and (o.SEX_UPON_OUTCOME like 'Spayed%' or o.SEX_UPON_OUTCOME like 'Neutered%')
order by o.animal_id;
