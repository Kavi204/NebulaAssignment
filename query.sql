SELECT * 
FROM orders
WHERE user_email LIKE '%@gmail.com'
ORDER BY order_date DESC;
