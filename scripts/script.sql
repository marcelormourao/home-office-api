CREATE SCHEMA home_office;

CREATE TABLE home_office.tb_usuario
(
	id_usuario integer NOT NULL,
	nome varchar(300) NOT NULL
);

CREATE SEQUENCE tb_usuario_seq INCREMENT 1 START 1;

ALTER TABLE home_office.tb_usuario ALTER COLUMN id_usuario
SET DEFAULT nextval(('tb_usuario_seq'::text)::regclass);

ALTER TABLE home_office.tb_usuario ADD CONSTRAINT PK_tb_usuario PRIMARY KEY (id_usuario);

CREATE TABLE home_office.tb_atividade
(
	id_atividade integer NOT NULL,
	id_usuario integer NOT NULL,
	descricao varchar(300) NOT NULL,
	data date,
	batida_inicial time,
	saida_almoco time,
    retorno_almoco time,
    batida_final time
);

CREATE SEQUENCE tb_atividade_seq INCREMENT 1 START 1;

ALTER TABLE home_office.tb_atividade ALTER COLUMN id_atividade
SET DEFAULT nextval(('tb_atividade_seq'::text)::regclass);

ALTER TABLE home_office.tb_atividade ADD CONSTRAINT PK_tb_atividade PRIMARY KEY (id_atividade);

ALTER TABLE home_office.tb_atividade ADD CONSTRAINT FK_tb_usuario
FOREIGN KEY (id_usuario) REFERENCES home_office.tb_usuario (id_usuario)
ON DELETE No Action ON UPDATE No Action;
