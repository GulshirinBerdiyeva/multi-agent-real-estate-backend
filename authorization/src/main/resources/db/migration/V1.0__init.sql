create table if not exists roles (
    id          text not null primary key,
    name        text not null,
    authorities text[],
    version     integer default 1
);

create table if not exists users (
    id                  text not null primary key,
    email               text not null unique,
    password            text not null,
    role_id             text constraint fk_users_role references roles(id) on delete cascade,
    version             integer default 1
);

create table if not exists refresh_tokens (
    id               text not null primary key,
    hash             text not null,
    expiry_date_time timestamp not null,
    user_id          text constraint fk_refresh_tokens_user references users(id) on delete cascade
);