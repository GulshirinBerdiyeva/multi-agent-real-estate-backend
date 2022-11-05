delete from roles where id is not null;

insert into roles(id, name, authorities, version)
values ('199790f4-1c8a-4aa7-ad9d-ec90111367ec', 'ADMIN', array['AUTHORIZATION', 'SELL_ESTATE', 'VIEW_ESTATE'], 1),
       ('299790f4-1c8a-4aa7-ad9d-ec90111367ec', 'SELLER', array['AUTHORIZATION', 'SELL_ESTATE', 'VIEW_ESTATE'], 1),
       ('399790f4-1c8a-4aa7-ad9d-ec90111367ec', 'CUSTOMER', array['AUTHORIZATION', 'VIEW_ESTATE'], 1);

-- USERS
-- password = Qwerty1!
insert into users(id, email, password, role_id, version)
values ('0d3a68a1-5919-4914-bc20-839fae2480ac', 'admin@tut.by',
        '$2a$10$ZWLfGFkubsP4rxMwg3y8Ve3WKbi8HxbN.n4ep66iRj6RSN5GRA8rK', '199790f4-1c8a-4aa7-ad9d-ec90111367ec', 1),
       ('1d3a68a1-5919-4914-bc20-839fae2480ac', 'seller@tut.by',
        '$2a$10$ZWLfGFkubsP4rxMwg3y8Ve3WKbi8HxbN.n4ep66iRj6RSN5GRA8rK', '299790f4-1c8a-4aa7-ad9d-ec90111367ec', 1),
       ('2d3a68a1-5919-4914-bc20-839fae2480ac', 'customer@tut.by',
        '$2a$10$ZWLfGFkubsP4rxMwg3y8Ve3WKbi8HxbN.n4ep66iRj6RSN5GRA8rK', '399790f4-1c8a-4aa7-ad9d-ec90111367ec', 1);