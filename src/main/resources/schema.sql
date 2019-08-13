-- file_info table
CREATE TABLE user (
    id varchar(100) PRIMARY KEY,
    name varchar(100) NOT NULL,
    dept varchar(200) NOT NULL,
    created_at timestamp NOT NULL
);