create table if not exists projects (
    id bigint primary key,
    project_name text,
    budget numeric,
    command_id integer
);

create table if not exists commands(
    id bigint primary key,
    person_id bigint
);

create table if not exists command_persons (
    command_id bigint,
    persons text
);