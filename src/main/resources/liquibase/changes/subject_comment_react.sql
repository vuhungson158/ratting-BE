--liquibase formatted sql
--changeset SonVH25:create-table-subject_comment_react
create table subject_comment_react
(
    id         bigserial primary key,
    is_deleted boolean,
    version    integer,
    created_at timestamp(6) with time zone,
    updated_at timestamp(6) with time zone,
    created_by varchar(255),
    updated_by varchar(255),

    react      varchar(255),

    comment_id bigint not null references subject_comment,
    user_id    bigint not null references auth_user,
    unique (comment_id, user_id)
);