
DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    PROCEDURE `northwind_varad`.`SalesByCategory`(IN orderYear VARCHAR(4),IN categoryName VARCHAR(100))
 
    BEGIN
    
SELECT P.name AS "ProductName" , SUM(Odet.UnitPrice*Odet.Quantity) AS "TotalPurchase" FROM orderdetails AS Odet 
INNER JOIN orders AS O ON O.OrderID = odet.OrderID 
INNER JOIN Products AS P ON odet.ProductID = P.id
INNER JOIN categories AS C ON P.CategoryID = C.CategoryID
WHERE YEAR(O.ShippedDate) = orderYear AND C.CategoryName = categoryName
GROUP BY YEAR(O.ShippedDate),ProductName;

    END$$

DELIMITER ;