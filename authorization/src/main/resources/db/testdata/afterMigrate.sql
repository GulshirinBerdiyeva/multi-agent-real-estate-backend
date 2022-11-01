delete from roles where id is not null;

insert into roles(id, name, authorities, version)
values ('199790f4-1c8a-4aa7-ad9d-ec90111367ec', 'ADMIN', array['AUTHORIZATION', 'SELL', 'ORDER'], 1),
       ('299790f4-1c8a-4aa7-ad9d-ec90111367ec', 'SELLER', array['AUTHORIZATION', 'SELL', 'ORDER'], 1),
       ('399790f4-1c8a-4aa7-ad9d-ec90111367ec', 'CUSTOMER', array['AUTHORIZATION', 'ORDER'], 1);

-- USERS
-- password = password
insert into users(id, email, password, role_id, version)
values ('0d3a68a1-5919-4914-bc20-839fae2480ac', 'email@tut.by', 'password', '199790f4-1c8a-4aa7-ad9d-ec90111367ec', 1);