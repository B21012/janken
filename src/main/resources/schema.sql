-- usersテーブル
CREATE TABLE users (
    id IDENTITY PRIMARY KEY,
    userName VARCHAR NOT NULL
);

-- matchesテーブル
CREATE TABLE matches (
    id IDENTITY PRIMARY KEY,
    user1 INT,
    user2 INT,
    user1Hand VARCHAR,
    user2Hand VARCHAR,
    isActive BOOLEAN NOT NULL
);

--matchinfoテーブル
CREATE TABLE matchinfo (
    id IDENTITY PRIMARY KEY,
    user1 INT,
    user2 INT,
    user1Hand VARCHAR,
    isActive BOOLEAN
);
