-- Write an SQL query to report the names of all the salespersons who did not have any orders related to the company with the name "RED".
-- Having SalesPerson, Company, Orders and tables

select name from SalesPerson
where name not in
(select SP.name from SalesPerson SP, Orders OD, Company C 
where SP.sales_id = OD.sales_id
and C.name = "RED"
and C.com_id = OD.com_id)