insert into agencia (id, numero) values (1, 1234);
insert into agencia (id, numero) values (2, 2345);
insert into agencia (id, numero) values (3, 3456);
insert into agencia (id, numero) values (4, 4789);

insert into pessoa (nome, email, cpf, data_Nascimento, tipo_pessoa) values ('Kamila Freitas Porto', 'example@gmail.com', '128.799.314-10', '2000-01-01', 'PF');

insert into conta (numero, saldo, agencia_id, pessoa_id) values ('123456', 2000, 1, 1);

insert into transacao (data_transacao, valor, tipo_transacao, conta_id) values ('2021-01-01', 100, 'DEPOSITO', 1);
insert into transacao (data_transacao, valor, tipo_transacao, conta_id) values ('2021-01-02', 120, 'DEPOSITO', 1);
insert into transacao (data_transacao, valor, tipo_transacao, conta_id) values ('2021-01-03', 200, 'DEPOSITO', 1);
insert into transacao (data_transacao, valor, tipo_transacao, conta_id) values ('2021-01-04', 100, 'SAQUE', 1);