# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table CNH (
  id                        integer auto_increment not null,
  numero                    bigint,
  data_emissao              datetime,
  validade                  datetime,
  uf_id                     integer,
  categoria_cnh_id          integer,
  pessoa_id                 integer,
  constraint pk_CNH primary key (id))
;

create table CarteiraTrabalho (
  id                        integer auto_increment not null,
  ctps                      bigint,
  serie                     integer,
  pessoa_id                 integer,
  constraint pk_CarteiraTrabalho primary key (id))
;

create table Categoria (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_Categoria primary key (id))
;

create table CategoriaCNH (
  id                        integer auto_increment not null,
  categoria                 varchar(255),
  constraint pk_CategoriaCNH primary key (id))
;

create table Cidade (
  id                        integer auto_increment not null,
  uf_id                     integer,
  nome                      varchar(255),
  constraint pk_Cidade primary key (id))
;

create table Email (
  id                        integer auto_increment not null,
  endereco                  varchar(255),
  pessoa_id                 integer,
  constraint pk_Email primary key (id))
;

create table Endereco (
  id                        integer auto_increment not null,
  cep                       bigint,
  endereco                  varchar(255),
  bairro                    varchar(255),
  cidade_id                 integer,
  constraint pk_Endereco primary key (id))
;

create table EstadoCivil (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_EstadoCivil primary key (id))
;

create table Etnia (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_Etnia primary key (id))
;

create table Filiacao (
  id                        integer auto_increment not null,
  cpf                       bigint,
  nome                      varchar(255),
  pessoa_id                 integer,
  constraint pk_Filiacao primary key (id))
;

create table Nacionalidade (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_Nacionalidade primary key (id))
;

create table Naturalidade (
  id                        integer auto_increment not null,
  pais_id                   integer,
  cidade_id                 integer,
  uf_id                     integer,
  constraint pk_Naturalidade primary key (id))
;

create table Pais (
  id                        integer auto_increment not null,
  nome                      varchar(255),
  constraint pk_Pais primary key (id))
;

create table Pessoa (
  id                        integer auto_increment not null,
  cpf                       bigint,
  nome                      varchar(255),
  data_nascimento           datetime,
  sexo                      tinyint(1) default 0,
  filhos                    tinyint(1) default 0,
  foto                      varchar(255),
  etnia_id                  integer,
  tipo_identidade_id        integer,
  estado_civil_id           integer,
  endereco_id               integer,
  nacionalidade_id          integer,
  naturalidade_id           integer,
  constraint pk_Pessoa primary key (id))
;

create table RegistroGeral (
  id                        integer auto_increment not null,
  rg                        bigint,
  orgao_expedidor           varchar(255),
  data_expedicao            datetime,
  pessoa_id                 integer,
  uf_id                     integer,
  constraint pk_RegistroGeral primary key (id))
;

create table Reservista (
  id                        integer auto_increment not null,
  certificado               bigint,
  serie                     bigint,
  orgao                     varchar(255),
  dispensa_incorporacao     bigint,
  unidade_alistamento       varchar(255),
  pessoa_id                 integer,
  constraint pk_Reservista primary key (id))
;

create table ServicoMilitar (
  id                        integer auto_increment not null,
  ano                       integer,
  pessoa_id                 integer,
  uf_id                     integer,
  constraint pk_ServicoMilitar primary key (id))
;

create table Telefone (
  id                        integer auto_increment not null,
  numero                    bigint,
  tipo_telefone_id          integer,
  pessoa_id                 integer,
  constraint pk_Telefone primary key (id))
;

create table TipoIdentidade (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_TipoIdentidade primary key (id))
;

create table TipoTelefone (
  id                        integer auto_increment not null,
  descricao                 varchar(255),
  constraint pk_TipoTelefone primary key (id))
;

create table TituloEleitor (
  id                        integer auto_increment not null,
  titulo                    bigint,
  zona                      integer,
  secao                     integer,
  pessoa_id                 integer,
  cidade_id                 integer,
  constraint pk_TituloEleitor primary key (id))
;

create table UF (
  id                        integer auto_increment not null,
  abreviacao                varchar(255),
  pais_id                   integer,
  nome                      varchar(255),
  constraint pk_UF primary key (id))
;

create table Usuario (
  id                        integer auto_increment not null,
  nome_usuario              varchar(255),
  hash_senha                varchar(255),
  data_criacao              datetime,
  constraint uq_Usuario_nome_usuario unique (nome_usuario),
  constraint pk_Usuario primary key (id))
;

alter table CNH add constraint fk_CNH_uf_1 foreign key (uf_id) references UF (id) on delete restrict on update restrict;
create index ix_CNH_uf_1 on CNH (uf_id);
alter table CNH add constraint fk_CNH_categoriaCNH_2 foreign key (categoria_cnh_id) references CategoriaCNH (id) on delete restrict on update restrict;
create index ix_CNH_categoriaCNH_2 on CNH (categoria_cnh_id);
alter table CNH add constraint fk_CNH_pessoa_3 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_CNH_pessoa_3 on CNH (pessoa_id);
alter table CarteiraTrabalho add constraint fk_CarteiraTrabalho_pessoa_4 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_CarteiraTrabalho_pessoa_4 on CarteiraTrabalho (pessoa_id);
alter table Cidade add constraint fk_Cidade_uf_5 foreign key (uf_id) references UF (id) on delete restrict on update restrict;
create index ix_Cidade_uf_5 on Cidade (uf_id);
alter table Email add constraint fk_Email_pessoa_6 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_Email_pessoa_6 on Email (pessoa_id);
alter table Endereco add constraint fk_Endereco_cidade_7 foreign key (cidade_id) references Cidade (id) on delete restrict on update restrict;
create index ix_Endereco_cidade_7 on Endereco (cidade_id);
alter table Filiacao add constraint fk_Filiacao_pessoa_8 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_Filiacao_pessoa_8 on Filiacao (pessoa_id);
alter table Naturalidade add constraint fk_Naturalidade_pais_9 foreign key (pais_id) references Pais (id) on delete restrict on update restrict;
create index ix_Naturalidade_pais_9 on Naturalidade (pais_id);
alter table Naturalidade add constraint fk_Naturalidade_cidade_10 foreign key (cidade_id) references Cidade (id) on delete restrict on update restrict;
create index ix_Naturalidade_cidade_10 on Naturalidade (cidade_id);
alter table Naturalidade add constraint fk_Naturalidade_uf_11 foreign key (uf_id) references UF (id) on delete restrict on update restrict;
create index ix_Naturalidade_uf_11 on Naturalidade (uf_id);
alter table Pessoa add constraint fk_Pessoa_etnia_12 foreign key (etnia_id) references Etnia (id) on delete restrict on update restrict;
create index ix_Pessoa_etnia_12 on Pessoa (etnia_id);
alter table Pessoa add constraint fk_Pessoa_tipoIdentidade_13 foreign key (tipo_identidade_id) references TipoIdentidade (id) on delete restrict on update restrict;
create index ix_Pessoa_tipoIdentidade_13 on Pessoa (tipo_identidade_id);
alter table Pessoa add constraint fk_Pessoa_estadoCivil_14 foreign key (estado_civil_id) references EstadoCivil (id) on delete restrict on update restrict;
create index ix_Pessoa_estadoCivil_14 on Pessoa (estado_civil_id);
alter table Pessoa add constraint fk_Pessoa_endereco_15 foreign key (endereco_id) references Endereco (id) on delete restrict on update restrict;
create index ix_Pessoa_endereco_15 on Pessoa (endereco_id);
alter table Pessoa add constraint fk_Pessoa_nacionalidade_16 foreign key (nacionalidade_id) references Nacionalidade (id) on delete restrict on update restrict;
create index ix_Pessoa_nacionalidade_16 on Pessoa (nacionalidade_id);
alter table Pessoa add constraint fk_Pessoa_naturalidade_17 foreign key (naturalidade_id) references Naturalidade (id) on delete restrict on update restrict;
create index ix_Pessoa_naturalidade_17 on Pessoa (naturalidade_id);
alter table RegistroGeral add constraint fk_RegistroGeral_pessoa_18 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_RegistroGeral_pessoa_18 on RegistroGeral (pessoa_id);
alter table RegistroGeral add constraint fk_RegistroGeral_uf_19 foreign key (uf_id) references UF (id) on delete restrict on update restrict;
create index ix_RegistroGeral_uf_19 on RegistroGeral (uf_id);
alter table Reservista add constraint fk_Reservista_pessoa_20 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_Reservista_pessoa_20 on Reservista (pessoa_id);
alter table ServicoMilitar add constraint fk_ServicoMilitar_pessoa_21 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_ServicoMilitar_pessoa_21 on ServicoMilitar (pessoa_id);
alter table ServicoMilitar add constraint fk_ServicoMilitar_uf_22 foreign key (uf_id) references UF (id) on delete restrict on update restrict;
create index ix_ServicoMilitar_uf_22 on ServicoMilitar (uf_id);
alter table Telefone add constraint fk_Telefone_tipoTelefone_23 foreign key (tipo_telefone_id) references TipoTelefone (id) on delete restrict on update restrict;
create index ix_Telefone_tipoTelefone_23 on Telefone (tipo_telefone_id);
alter table Telefone add constraint fk_Telefone_pessoa_24 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_Telefone_pessoa_24 on Telefone (pessoa_id);
alter table TituloEleitor add constraint fk_TituloEleitor_pessoa_25 foreign key (pessoa_id) references Pessoa (id) on delete restrict on update restrict;
create index ix_TituloEleitor_pessoa_25 on TituloEleitor (pessoa_id);
alter table TituloEleitor add constraint fk_TituloEleitor_cidade_26 foreign key (cidade_id) references Cidade (id) on delete restrict on update restrict;
create index ix_TituloEleitor_cidade_26 on TituloEleitor (cidade_id);
alter table UF add constraint fk_UF_pais_27 foreign key (pais_id) references Pais (id) on delete restrict on update restrict;
create index ix_UF_pais_27 on UF (pais_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table CNH;

drop table CarteiraTrabalho;

drop table Categoria;

drop table CategoriaCNH;

drop table Cidade;

drop table Email;

drop table Endereco;

drop table EstadoCivil;

drop table Etnia;

drop table Filiacao;

drop table Nacionalidade;

drop table Naturalidade;

drop table Pais;

drop table Pessoa;

drop table RegistroGeral;

drop table Reservista;

drop table ServicoMilitar;

drop table Telefone;

drop table TipoIdentidade;

drop table TipoTelefone;

drop table TituloEleitor;

drop table UF;

drop table Usuario;

SET FOREIGN_KEY_CHECKS=1;

