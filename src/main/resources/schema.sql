
-- usersテーブル
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- matchesテーブル
CREATE TABLE matches (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user1 INT NOT NULL,
    user2 INT NOT NULL,
    user1Hand VARCHAR(50) NOT NULL,
    user2Hand VARCHAR(50) NOT NULL,
    FOREIGN KEY (user1) REFERENCES users(id),
    FOREIGN KEY (user2) REFERENCES users(id)
);
