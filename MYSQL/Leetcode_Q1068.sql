--https://leetcode.com/problems/product-sales-analysis-i/description/

select product_name, year, price
from Sales S inner join Product P
where S.product_id = P.product_id