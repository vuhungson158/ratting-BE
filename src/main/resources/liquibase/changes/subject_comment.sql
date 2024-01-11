--liquibase formatted sql
--changeset SonVH25:create-table-subject_comment
create table subject_comment
(
    id         bigserial primary key,
    is_deleted boolean,
    version    integer,
    created_at timestamp(6) with time zone,
    updated_at timestamp(6) with time zone,
    created_by varchar(255),
    updated_by varchar(255),

    comment    varchar(255),

    subject_id bigint not null references subject,
    user_id    bigint not null references auth_user,
    unique (subject_id, user_id)
);