-- Retrive the customer that ordered the most from orders table 

SELECT customer_number 
FROM orders
group by customer_number
order by COUNT(*) DESC
LIMIT 1;