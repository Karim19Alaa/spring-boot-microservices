import random
import requests
from bs4 import BeautifulSoup
import re
import mysql.connector
import os





# with open("index.html", encoding='utf-8') as file:
#     html = file.read()

# soup = BeautifulSoup(html, 'html.parser')
# # print(soup.prettify())
# movie_ids = [os.path.basename(a['href']) for a in soup.find_all('a', attrs={'href': re.compile(r'/movie/'), 'class': 'image'})]

movie_ids = ['1096197', '932420', '1011985', '1239251', '940551', '693134', '969492', '792307', '870404', '1072790', '787699', '984249', '438631', '848538', '866398', '1227816', '636706', '714567', '609681', '949429']
user_ids = [f"user{i}" for i in range(1, 100)]
print(len(movie_ids))

conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="pass",
    database="movieratingsdb"
)

# table_creation = "CREATE DATABASE IF NOT EXISTS movieratingsdb;"

cursor = conn.cursor()

ratings_table_creation = """
CREATE TABLE IF NOT EXISTS movieratingsdb.ratings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    movie_id VARCHAR(50),
    rating INT
);
"""

cursor.execute(ratings_table_creation)

cursor.execute("TRUNCATE TABLE movieratingsdb.ratings;")

seen = set()

for i in range(1000):
    user = user_ids[random.randint(0, len(user_ids) - 1)]
    movie = movie_ids[random.randint(0, len(movie_ids) - 1)]
    while (user, movie) in seen:
        user = user_ids[random.randint(0, len(user_ids) - 1)]
        movie = movie_ids[random.randint(0, len(movie_ids) - 1)]

    seen.add((user, movie))
    sql = f"INSERT INTO movieratingsdb.ratings (user_id, movie_id, rating) VALUES ('{user}', '{movie}', {random.randint(2, 5)});"
    # print(sql)
    cursor.execute(sql)

conn.commit()
conn.close()

