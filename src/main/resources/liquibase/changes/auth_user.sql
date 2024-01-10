create table auth_user
(
    id           bigserial primary key,
    is_deleted   boolean,
    version      integer,
    created_at   timestamp(6) with time zone,
    updated_at   timestamp(6) with time zone,
    created_by   varchar(255),

    display_name varchar(255),
    email        varchar(255) unique,
    gender       varchar(255) not null,
    password     varchar(255),
    role         varchar(255) not null,
    updated_by   varchar(255)
);