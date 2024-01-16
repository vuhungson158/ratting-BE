--liquibase formatted sql
--changeset SonVH25:create-table-subject
create table subject
(
    id             bigserial primary key,
    is_deleted     boolean,
    version        integer,
    created_at     timestamp(6) with time zone,
    updated_at     timestamp(6) with time zone,
    created_by     varchar(255),
    updated_by     varchar(255),

    teacher_id     bigint       not null references teacher,
    credit         integer      not null,
    form_year      integer      not null,
    require        boolean      not null,
    classification varchar(255) not null,
    department     varchar(255) not null,
    name           varchar(255) not null,
    schedule       varchar(255),
    semester       varchar(255)
);

--changeset SonVH25:alter-table-subject-rename-form_year-to-registrable_year
alter table subject
    rename column form_year to registrable_year