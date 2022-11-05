create table if not exists users (
    id       text not null primary key,
    email    text not null unique,
    version  integer default 1
);

create table if not exists estates (
    id          text not null primary key,
    apartment   bool not null,
    location    text not null,
    area        float8 not null,
    description text not null,
    file_name   text not null,
    version     integer not null default 1
);
create index estate_location on estates(location);

create table if not exists events (
    id        text not null primary key,
    type      text not null,
    entity_id text not null,
    context   text not null,
    date_time timestamp not null,
    payload   jsonb,
    version   integer default 1
);
create index cx_event_date_time on events (date_time);
cluster events using cx_event_date_time;