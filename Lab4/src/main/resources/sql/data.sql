insert into projects(id, project_name, budget, command_id)
values (1, "NPC", "20001200", 1);

insert into commands(id, person_id)
    values (1, 1);

insert into command_persons(command_id, persons)
values (1, "Dyrov V.")