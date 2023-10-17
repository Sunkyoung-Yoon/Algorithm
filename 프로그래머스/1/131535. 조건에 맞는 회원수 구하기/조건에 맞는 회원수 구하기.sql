-- 코드를 입력하세요
SELECT count(*) as USERS
from USER_INFO
where age between 20 and 29
and DATE_FORMAT(JOINED, '%Y') = '2021';