-- https://leetcode.com/problems/user-activity-for-the-past-30-days-i/submissions/920621502/

select 
  activity_date as day,
  count(DISTINCT user_id) as active_users
from Activity
WHERE (activity_date > "2019-06-27" AND activity_date <= "2019-07-27")
group by activity_date