--liquibase formatted sql
--changeset SonVH25:create-table-teacher_comment_react
create table teacher_comment_react
(
    id         bigserial primary key,
    is_deleted boolean default false,
    version    integer,
    created_at timestamp(6) with time zone,
    updated_at timestamp(6) with time zone,
    created_by varchar(255),
    updated_by varchar(255),

    comment_id bigint       not null references teacher_comment,
    user_id    bigint       not null references auth_user,
    react      varchar(255) not null,
    unique (comment_id, user_id)
);