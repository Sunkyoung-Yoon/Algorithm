-- 코드를 입력하세요
SELECT DATE_FORMAT(DATETIME,'%k') as HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME,'%H') between 09 and 19
GROUP BY DATE_FORMAT(DATETIME,'%H')
order by DATE_FORMAT(DATETIME,'%H');