--liquibase formatted sql
--changeset SonVH25:create-table-teacher_rating
create table teacher_rating
(
    id          bigserial primary key,
    is_deleted  boolean,
    version     integer,
    created_at  timestamp(6) with time zone,
    updated_at  timestamp(6) with time zone,
    created_by  varchar(255),
    updated_by  varchar(255),

    enthusiasm  integer check ((enthusiasm <= 100) AND (enthusiasm >= 0)),
    erudition   integer check ((erudition >= 0) AND (erudition <= 100)),
    friendly    integer check ((friendly >= 0) AND (friendly <= 100)),
    pedagogical integer check ((pedagogical <= 100) AND (pedagogical >= 0)),
    star        integer check ((star <= 10) AND (star >= 0)),

    teacher_id  bigint not null references teacher,
    user_id     bigint not null references auth_user,

    unique (teacher_id, user_id)
);