CREATE DATABASE IF NOT EXISTS movieratingsdb;
USE movieratingsdb;

CREATE TABLE IF NOT EXISTS ratings (
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

-----------------------------------------------------
-- -- Use Python Script to generate sample data -- --
-----------------------------------------------------

Select * from ratings;


------------------------------------------------------------------------
-- -- We dont need Movie table, it is handled by the api and mongo -- --
------------------------------------------------------------------------
