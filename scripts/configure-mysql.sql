#Create Database
create database pos_db;

#Create User
create user 'pos_user'@'localhost' identified by 'Password1';
create user 'pos_user'@'%' identified by 'Password1';
#Database Grants
GRANT SELECT ON pos_db.* to 'pos_user'@'localhost';
GRANT INSERT ON pos_db.* to 'pos_user'@'localhost';
GRANT UPDATE ON pos_db.* to 'pos_user'@'localhost';
GRANT DELETE ON pos_db.* to 'pos_user'@'localhost';
GRANT SELECT ON pos_db.* to 'pos_user'@'%';
GRANT INSERT ON pos_db.* to 'pos_user'@'%';
GRANT UPDATE ON pos_db.* to 'pos_user'@'%';
GRANT DELETE ON pos_db.* to 'pos_user'@'%';
GRANT ALL PRIVILEGES ON pos_db.* TO 'pos_user'@'localhost';
GRANT ALL PRIVILEGES ON pos_db.* TO 'pos_user'@'%';
