--liquibase formatted sql
--changeset SonVH25:create-table-subject_rating
create table subject_rating
(
    id                 bigserial primary key,
    is_deleted         boolean,
    version            integer,
    created_at         timestamp(6) with time zone,
    updated_at         timestamp(6) with time zone,
    created_by         varchar(255),
    updated_by         varchar(255),

    easy_to_understand integer check ((easy_to_understand <= 100) AND (easy_to_understand >= 0)),
    practicality       integer check ((practicality >= 0) AND (practicality <= 100)),
    star               integer check ((star <= 10) AND (star >= 0)),

    subject_id         bigint not null references subject,
    user_id            bigint not null references auth_user,
    unique (subject_id, user_id)
);