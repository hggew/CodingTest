# select * from food_warehouse;

# -- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
    case
        when freezer_yn is null then 'N'
        else freezer_yn
    end
    'FREEZER_YN'
from FOOD_WAREHOUSE 
where address like '경기도%'
order by WAREHOUSE_ID ; 