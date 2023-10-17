-- 코드를 입력하세요
SELECT (truncate(PRICE/10000,0)*10000) as PRICE_GROUP, count(*) as PRODUCTS
from PRODUCT
group by (truncate(PRICE/10000,0)*10000)
order by PRICE_GROUP;