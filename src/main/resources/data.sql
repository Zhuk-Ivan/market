insert into categories (category_name) values('Еда');
insert into categories (category_name) values('Вкусности');
insert into categories (category_name) values('Вода');

insert into products (product_name, description, cost, notes, special_notes)
values ('Селедка', 'Селедка соленая', 10.000, 'Акция', 'Пересоленная');
insert into products (product_name, description, cost, notes, special_notes)
values ('Тушенка', 'Тушенка соленая', 20.000, 'Вкусная', 'Жилы');
insert into products (product_name, description, cost, notes, special_notes)
values ('Сгущенка', 'В банках', 30.000, 'С ключом', 'Вкусная');
insert into products (product_name, description, cost, notes, special_notes)
values ('Квас', 'В бутылках', 15.000, 'Вятский', 'Теплый');

insert into categories_products (category_id, product_id) values (1, 1);
insert into categories_products (category_id, product_id) values (1, 2);
insert into categories_products (category_id, product_id)  values (2, 3);
insert into categories_products (category_id, product_id)  values (3, 4);

INSERT INTO users (password, user_name, email) VALUES ('$2a$10$EZsSf/DAJ4dMoYZZXVjL2uOOyJ31vkj.OrN6GYd5d6rkFztXMvUVC', 'user', 'user@mail.ru');
INSERT INTO users (password, user_name, email) VALUES ('$2a$10$xjS3u.PwkDHkmJWUOGybLOpLgay3yv7KPROsbgWj7WONTEX4DvwL.', 'pro_user' , 'pro_user@gmail.com');
INSERT INTO users (password, user_name, email) VALUES ('$2a$10$njOAcfkj1/k2flhbwuEafuxZgZvmf.W597nC8vlYMxULFMMbacy5W', 'admin' , 'admin@gmail.com');


INSERT INTO roles (role_name) VALUES ('USER');
INSERT INTO roles (role_name) VALUES ('PRO_USER');
INSERT INTO roles (role_name) VALUES ('ADMIN');


INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);
