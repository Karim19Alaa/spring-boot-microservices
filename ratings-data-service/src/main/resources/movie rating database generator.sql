CREATE DATABASE IF NOT EXISTS movieratingsdb;
USE movieratingsdb;

CREATE TABLE IF NOT EXISTS ratings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId VARCHAR(50),
    movieId VARCHAR(50),
    rating INT
);


-- Create a stored procedure to insert 200 rows of sample data
DELIMITER //
CREATE PROCEDURE GenerateSampleData()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 200 DO
        INSERT INTO ratings (userId, movieId, rating)
        VALUES
        (CONCAT('user', FLOOR(1 + RAND() * 10)), CONCAT('movie', FLOOR(1 + RAND() * 20)), FLOOR(1 + RAND() * 5));

        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Call the stored procedure to insert the data
CALL GenerateSampleData();

Select * from ratings;