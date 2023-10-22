
-- usersテーブル
CREATE TABLE users (
    id IDENTITY PRIMARY KEY,
    userName VARCHAR NOT NULL
);

-- matchesテーブル
CREATE TABLE matches (
    id IDENTITY PRIMARY KEY,
    user1 VARCHAR,
    user2 VARCHAR,
    user1Hand VARCHAR,
    user2Hand VARCHAR
);
