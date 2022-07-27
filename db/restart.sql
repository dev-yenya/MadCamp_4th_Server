use cs496_exchange;
drop table UserProfile;
create table UserProfile(
    id varchar(64) primary key,
    name varchar(64),
    email varchar(256)
);
alter table UserProfile convert to charset utf8;
drop table Post;
create table Post(
    id int(11) not null auto_increment primary key,
    title varchar(64),
    uid varchar(64),
    postDate timestamp not null default current_timestamp,
    context text,
    category varchar(64),
    imgUrl varchar(500)
);
alter table Post convert to charset utf8;
