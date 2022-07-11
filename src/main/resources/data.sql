/**
 * CREATE Script for init of DB
*/

-- Create 3 PREMIUM locations

insert into location (id, name, latitude, longitude, type) values (1, 'great location', 12.9, 30.5, 'PREMIUM');

insert into location (id, name, latitude, longitude, type) values (2, 'mega location', 46.6, 15.4, 'PREMIUM');

insert into location (id, name, latitude, longitude, type) values (3, 'luxury location', 48.8, 17.5, 'PREMIUM');

-- Create 3 STANDARD locations

insert into location (id, name, latitude, longitude, type) values (4, 'small location', 11.9, 29.5, 'STANDARD');

insert into location (id, name, latitude, longitude, type) values (5, 'standard location', 44.1, 14.9, 'STANDARD');

insert into location (id, name, latitude, longitude, type) values (6, 'holidays location', 40.8, 18.5, 'STANDARD');




