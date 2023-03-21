-- https://leetcode.com/problems/group-sold-products-by-the-date/submissions/919451830/

SELECT 
	sell_date,
	COUNT(DISTINCT product) AS num_sold,
	GROUP_CONCAT(DISTINCT product ORDER BY product ASC) AS products 
FROM Activities
GROUP BY sell_date