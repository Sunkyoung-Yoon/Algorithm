-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, count(car_id) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where start_date between '2022-08-01' and '2022-10-31'
and car_id in (
-- 대여 시작일을 기준으로 2022-08 ~ 2022-10까지 총 대여 횟수(행)이 5회 이상인 자동차 id
select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-10-31'
group by car_id
HAVING count(*) > 4
)
-- 월별 해당 car_id의 대여 횟수가 나와야 하기에 아래처럼 묶음
GROUP BY MONTH(START_DATE), CAR_ID
order by MONTH(START_DATE) asc, CAR_ID desc;