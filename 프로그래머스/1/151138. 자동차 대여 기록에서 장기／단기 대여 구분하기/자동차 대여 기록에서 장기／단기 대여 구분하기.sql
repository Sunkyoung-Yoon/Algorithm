-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, date_format(START_DATE,"%Y-%m-%d") as START_DATE,
date_format(END_DATE,"%Y-%m-%d") as END_DATE,
(
case
    when TIMESTAMPDIFF(day, START_DATE, END_DATE)+1 >= 30
    then '장기 대여'
    else '단기 대여' end
) as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(START_DATE,"%Y-%m") = '2022-09'
order by HISTORY_ID desc;