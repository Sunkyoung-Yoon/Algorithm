-- 코드를 입력하세요
SELECT board.TITLE, board.BOARD_ID, reply.REPLY_ID, reply.WRITER_ID, reply.CONTENTS, 
DATE_FORMAT(reply.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD board JOIN USED_GOODS_REPLY reply
ON board.BOARD_ID = reply.BOARD_ID
WHERE board.CREATED_DATE between '2022-10-01' and '2022-10-31'
order by reply.Created_date, board.TITLE;