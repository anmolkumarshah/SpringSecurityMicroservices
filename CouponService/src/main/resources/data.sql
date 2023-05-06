insert into user(id,email,name,password) values
(101,'anmol@virtusa.com','Anmol Shah','$2a$10$.4ObaacLfE5e.Tk.laYrS..Y1HlNGuPD8P9OIgYShg6Sgh5xHz7fO'),
(102,'saloni@virtusa.com','Saloni Shah','$2a$10$.4ObaacLfE5e.Tk.laYrS..Y1HlNGuPD8P9OIgYShg6Sgh5xHz7fO');

insert into role(id,name) values
(201,'ROLE_ADMIN'),
(202,'ROLE_USER');

insert into user_role(user_id,role_id) values
(101,201),
(102,202);