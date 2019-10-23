create table Clientes (
       id integer not null auto_increment,
        bairro varchar(255),
        cep varchar(255),
        cidade varchar(255),
        cpf varchar(255),
        logradouro varchar(255),
        nome varchar(255),
        rg varchar(255),
        sexo varchar(255),
        telefone varchar(255),
        uf varchar(255),
        primary key (id)
)

create table Imoveis (
       id integer not null auto_increment,
        cep varchar(255),
        cidade varchar(255),
        comodos varchar(255),
        nome varchar(255),
        preço double precision,
        rua varchar(255),
        uf varchar(255),
        primary key (id)
)

create table Login (
       id integer not null auto_increment,
        senha varchar(255),
        usuario varchar(255),
        primary key (id)
) 
    
  create table clientes_imoveis (
       id_clientes integer not null,
        id_imoveis integer not null
) 