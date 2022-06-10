INSERT INTO sr03_users (id, firstname, lastName, mail, password, admin) VALUES (1, 'John', 'BOB', 'jb@test.com', 'jb', 1);
INSERT INTO sr03_users (id, firstname, lastName, mail, password, admin) VALUES (2, 'Paul', 'FIOUL', 'pf@test.com', 'pf', 0);
INSERT INTO sr03_users (id, firstname, lastName, mail, password, admin) VALUES (3, 'Michal', 'POULPE', 'mp@test.com', 'mp', 0);

INSERT INTO sr03_channels (id, title, description, date, duration, user_id) VALUES (1, 'channel 1', '', '2022-06-01T10:00:00', 3, 1);
INSERT INTO sr03_channels (id, title, description, date, duration, user_id) VALUES (2, 'channel 2', '', '2022-06-10T12:00:00', 5, 1);
INSERT INTO sr03_channels (id, title, description, date, duration, user_id) VALUES (3, 'channel 3', '', '2022-06-20T14:00:00', 7, 2);
