--liquibase formatted sql
--changeset SonVH25:create-table-teacher
create table teacher
(
    id          bigserial primary key,
    is_deleted  boolean default false,
    version     integer,
    created_at  timestamp(6) with time zone,
    updated_at  timestamp(6) with time zone,
    created_by  varchar(255),
    updated_by  varchar(255),

    furigana    varchar(255) not null,
    gender      varchar(255) not null,
    name        varchar(255) not null,
    nationality varchar(255) not null
);

--changeset SonVH25:alter-table-teacher-add-column-dob
alter table teacher
    add column dob timestamp(6) not null default now();