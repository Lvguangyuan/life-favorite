CREATE DATABASE IF NOT EXISTS lifefavorite default character set utf8 COLLATE utf8_general_ci;
CREATE TABLE IF NOT EXISTS bookmark(id SERIAL, title VARCHAR(255), link VARCHAR(255), description VARCHAR(255), type VARCHAR(25), imageId VARCHAR(255));
INSERT INTO bookmark(title, link, description) VALUES ("百度", "https://www.baidu.com", "百度测试用例");
INSERT INTO bookmark(title, link, description) VALUES ("谷歌", "https://www.google.com", "谷歌测试用例");
