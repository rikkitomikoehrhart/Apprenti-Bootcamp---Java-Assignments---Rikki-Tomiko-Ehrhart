SELECT *
FROM Item
WHERE StartDate >= '2019-01-01'
AND (EndDate <= '2021-01-01' OR EndDate IS NULL)