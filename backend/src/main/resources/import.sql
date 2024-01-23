INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user (name, email, password) VALUES ('Thiago Barbosa', 'thiago@gmail.com', '$2a$10$vBPuHuYDyQOPTYQOl4y/HusTmJnA4BNJi6STjlpRpJQEU/7lmnkC2');
INSERT INTO tb_user (name, email, password) VALUES ('Teste de inserção de usuário', 'jose@gmail.com', '$2a$10$uMVhwk33MBbD839ZqAQYR.GxdLqOBaZuLpk7Wf0CPOjBoVMdDOVn6');
INSERT INTO tb_user (name, email, password) VALUES ('Teste de inserção de usuário', 'teste2@gmail.com', '$2a$10$ANlKe/Y6TvzNXgNN6kqbZufa67lt.uDxhwz7Q8peE.QaEQR4uPOoi');
INSERT INTO tb_user (name, email, password) VALUES ('Teste 5', 'teste5@gmail.com', '$2a$10$xllSjTwI5H.rzGp/SiUkp.MC4OwB1j7xLhdhHqPLZUZgw/wqI3ZoW');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);

INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);

INSERT INTO tb_categoria (id, nome_categoria) VALUES (1, 'Salário');

INSERT INTO tb_lancamento (descricao, ano, mes, valor ,user_id, status, tipo ) VALUES ('lorem ipsum',2024, 2, 90.9, 1,'PENDENTE', 'RECEITA' );
INSERT INTO tb_categoria_lancamento (categoria_id, lancamento_id) VALUES (1, 1);