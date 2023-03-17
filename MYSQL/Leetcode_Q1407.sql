-- https://leetcode.com/problems/top-travellers/description/

-- Write your MySQL query statement below
SELECT name,  ifnull(sum(distance), 0) as travelled_distance
from Users LEFT JOIN Rides On Users.id = Rides.user_id
GROUP BY Rides.user_id
ORDER BY travelled_distance DESC, name 