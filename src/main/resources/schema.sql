create table customer
(
  id bigint generated by default as identity primary key,
  email varchar(50),
  password varchar(50)
);