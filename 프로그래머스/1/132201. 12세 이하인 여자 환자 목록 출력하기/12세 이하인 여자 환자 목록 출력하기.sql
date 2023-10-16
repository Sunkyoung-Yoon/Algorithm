-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO,'NONE')
from patient
where GEND_CD = 'W' AND AGE <= 12
order by age desc, PT_NAME asc;