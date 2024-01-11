--liquibase formatted sql
--changeset SonVH25:create-table-teacher_comment
create table teacher_comment
(
    id         bigserial primary key,
    is_deleted boolean default false,
    version    integer,
    created_at timestamp(6) with time zone,
    updated_at timestamp(6) with time zone,
    created_by varchar(255),
    updated_by varchar(255),

    teacher_id bigint       not null references teacher,
    user_id    bigint       not null references auth_user,
    comment    varchar(255) not null,

    unique (teacher_id, user_id)
);