# DROP TABLE IF EXISTS employee;
# DROP TABLE IF EXISTS users;
# DROP TABLE IF EXISTS authorities;
# DROP TABLE IF EXISTS adverts;
#
#
# CREATE TABLE employee (
#                              empId VARCHAR(10) NOT NULL,
#                              empName VARCHAR(100) NOT NULL
# );
#
# create table users (
#                              username varchar(50) not null primary key,
#                              password varchar(120) not null,
#                              latitude varchar(100) null,
#                              longitude varchar(100) null,
#                              enabled boolean not null
# );
#
# create table authorities (
#                              username varchar(50) not null,
#                              authority varchar(50) not null,
#                              foreign key (username) references users (username)
# );
# create table adverts (
#                              title varchar(100) not null,
#                              description varchar(200) null,
#                              price decimal(9,2) not null,
#                              imageUrl varchar(200) not null,
#                              latitude varchar(100) not null,
#                              longitude varchar(100) not null,
#                              FK_userId int(10) not null
# );
#
# insert into users(username, password, enabled)values('javainuse','javainuse',true);
# insert into authorities(username,authority)values('javainuse','ROLE_ADMIN');
#
# insert into users(username, password, enabled)values('employee','employee',true);
# insert into authorities(username,authority)values('javainuse','ROLE_USER');