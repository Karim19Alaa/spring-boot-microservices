CREATE DATABASE IF NOT EXISTS movieratingsdb;
USE movieratingsdb;

CREATE TABLE IF NOT EXISTS rating (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    movie_id VARCHAR(50),
    rating INT
);
CREATE TABLE IF NOT EXISTS movie (
    movie_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);


-- Create a stored procedure to insert 200 rows of sample data
DELIMITER //
CREATE PROCEDURE GenerateSampleData()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 200 DO
        INSERT INTO ratings (user_id, movie_id, rating)
        VALUES
        (CONCAT('user', FLOOR(1 + RAND() * 10)), CONCAT('movie', FLOOR(1 + RAND() * 20)), FLOOR(1 + RAND() * 5));

        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Call the stored procedure to insert the data
CALL GenerateSampleData();

Select * from rating;

-- Create a stored procedure to insert 20 rows of sample data into the Movie table
DELIMITER //
CREATE PROCEDURE GenerateMovieData()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 20 DO
        INSERT INTO movie (movie_id, name, description)
        VALUES
        (CONCAT('movie', i), CONCAT('Movie ', i), CONCAT('Description for Movie ', i));

        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Call the stored procedure to insert the Movie data
CALL GenerateMovieData();

-- Verify the Movie table
SELECT * FROM movie;
