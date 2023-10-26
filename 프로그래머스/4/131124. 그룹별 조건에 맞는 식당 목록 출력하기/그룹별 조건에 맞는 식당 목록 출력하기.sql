# -- 코드를 입력하세요
SELECT m.member_name,  r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
from member_profile m right join rest_review  r
on m.member_id = r.member_id   
where m.member_id = (select member_id from rest_review 
                        group by member_id
                        order by count(member_id) desc limit 1) 
order by r.review_date, r.review_Text;