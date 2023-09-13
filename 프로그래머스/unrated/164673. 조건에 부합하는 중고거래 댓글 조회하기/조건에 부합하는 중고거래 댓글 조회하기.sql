-- 코드를 입력하세요
SELECT USED_GOODS_BOARD.title, USED_GOODS_REPLY.board_id,  
        USED_GOODS_REPLY.REPLY_ID, USED_GOODS_REPLY.writer_id, 
        USED_GOODS_REPLY.contents, date_format(USED_GOODS_REPLY.created_date, '%Y-%m-%d') 'CREATED_DATE'
from USED_GOODS_REPLY left join  USED_GOODS_BOARD
    on USED_GOODS_BOARD.board_id = USED_GOODS_REPLY.board_id
where year(USED_GOODS_BOARD.CREATED_DATE) = 2022 and month(USED_GOODS_BOARD.CREATED_DATE) = 10
order by USED_GOODS_REPLY.created_date, USED_GOODS_BOARD.title;

# select * from USED_GOODS_BOARD;

