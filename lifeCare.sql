drop database lifecare;
create database lifecare;

begin;

\c lifecare;

create table pessoa(
    id serial primary key,
    cpf character varying(11) unique,
    nome character varying(100) not null,
    data_nasc timestamp without time zone not null,
    telefone character varying(20) not null,
    email character varying(100) not null,
    senha character varying(20) not null,
    genero character varying(100) not null,  
    endereco character varying(100) not null,
    estado_civil character varying(100) not null
);

create table pessoa_foto(
    id serial primary key,
    pessoa_id integer references pessoa(id) on update cascade on delete no action,
    foto character varying (300) 
);

alter table pessoa add constraint ck1_pessoa check(genero in ('masculino', 'feminino','outro'));
alter table pessoa add constraint ck2_pessoa check(estado_civil in ('solteiro', 'casado','separado','divorciado','viuvo'));

create table responsavel(
    id serial primary key,
    pessoa_id integer references pessoa(id) on update cascade on delete no action 
);

create table cuidador(
    id serial primary key,
    coren character varying(100) unique,
    pessoa_id integer references pessoa(id) on update cascade on delete no action 
);

create table idoso(
    id serial primary key,
    telefone_responsavel character varying(20) not null,
    nivel_debilidade character varying(100) not null,
    historico_medico character varying(300) not null,
    pessoa_id integer references pessoa(id) on update cascade on delete no action 
);

alter table idoso add constraint ck1_idoso check(nivel_debilidade in ('leve', 'moderado','grave','profundo'));

create table responsavel_idoso(
    id serial primary key,
    responsavel_id integer references responsavel(id) on update cascade on delete no action,
    idoso_id integer references idoso(id) on update cascade on delete no action
);

create table contrato(
    id serial primary key,
    data_inicio timestamp without time zone not null,
    data_fim timestamp without time zone not null,
    cuidador_id integer references cuidador(id) on update cascade on delete no action,
    idoso_id integer references idoso(id) on update cascade on delete no action
);

create table atendimento_diario(
    id serial primary key,
    data_hora timestamp without time zone not null,
    observacao text not null,
    conclusao_atividade character varying(20) not null,
    contrato_id integer references contrato(id) on update cascade on delete no action
);

alter table atendimento_diario add constraint ck1_atendimento_diario check(conclusao_atividade in ('concluido', 'nao concluido','em andamento'));

create table rotina_diaria(
    id serial primary key,
    data_hora timestamp without time zone not null,
    descricao text not null,
    tipo character varying(100) not null,
    subtipo character varying(100) not null,
    atendimento_diario_id integer references atendimento_diario(id) on update cascade on delete no action,
    responsavel_idoso_id integer references responsavel_idoso(id) on update cascade on delete no action
);

alter table rotina_diaria add constraint ck1_rotina_diaria check(tipo in ('alimentacao', 'medicamento','atividades'));
alter table rotina_diaria add constraint ck2_rotina_diaria check(subtipo in ('lazer', 'fisica ','fisioterapica','lucidas'));

create table atendimento_rotina(
    id serial primary key,
    manutencao character varying(100) not null,
    atendimento_diario_id integer references atendimento_diario(id) on update cascade on delete no action,
    rotina_diaria_id integer references rotina_diaria(id) on update cascade on delete no action
);


commit;

INSERT INTO PESSOA VALUES (defaut, '12345678912', 'ana julia mendes', '08/11/2002', '35999999999', 'anaju@email.com', 'lalala', 'feminino', 'rua lalala', 'solteiro');
INSERT INTO PESSOA VALUES (defaut, '98745678912', 'juliana bernandes', '15/11/2002', '35988899999', 'juliana@email.com', 'lalala', 'outro', 'rua lalala', 'solteiro');
