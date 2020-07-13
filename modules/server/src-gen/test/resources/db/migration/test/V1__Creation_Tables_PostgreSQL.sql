
------------ Begin tests utilities ----------------

-- Simulates PostgreSQL UNACCENT function in H2 database for test only.
CREATE ALIAS unaccent FOR "br.com.kerubin.api.servicecore.util.CoreUtils.unaccent";

------------ End tests utilities ------------------

/**************** WARNING WILL DELETE ALL TABLES *********
DROP TABLE IF EXISTS fornecedor CASCADE;
DROP TABLE IF EXISTS produto CASCADE;
DROP TABLE IF EXISTS foto CASCADE;
DROP TABLE IF EXISTS foto CASCADE;
**********************************************************/

CREATE TABLE fornecedor /* Fornecedor */  (
	id UUID NOT NULL,
	tipo_pessoa VARCHAR(255) NOT NULL /* tipoPessoa */,
	nome VARCHAR(255) NOT NULL,
	cnpj_cpf VARCHAR(255) /* cnpjCPF */,
	ie_rg VARCHAR(255) /* ieRG */,
	data_fundacao_nascimento DATE /* dataFundacaoNascimento */,
	nome_contato VARCHAR(255) /* nomeContato */,
	fone VARCHAR(255),
	celular VARCHAR(255),
	email VARCHAR(255),
	site VARCHAR(255),
	cep VARCHAR(255),
	uf VARCHAR(255),
	cidade VARCHAR(255),
	bairro VARCHAR(255),
	endereco VARCHAR(255),
	numero VARCHAR(255),
	complemento VARCHAR(255),
	observacoes VARCHAR(1000),
	ativo BOOLEAN DEFAULT true
);

CREATE TABLE produto /* Produto */  (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE foto /* Foto */  (
	id UUID NOT NULL,
	nome VARCHAR(255),
	descricao VARCHAR(255),
	tamanho NUMERIC(19),
	tipo VARCHAR(255),
	produto UUID
);

CREATE TABLE foto /* FotoImage */  (
	id UUID NOT NULL,
	imagem BYTEA,
	miniatura BYTEA,
	nome VARCHAR(255),
	descricao VARCHAR(255),
	tamanho NUMERIC(19),
	tipo VARCHAR(255),
	produto UUID
);

/* PRIMARY KEYS */
ALTER TABLE fornecedor ADD CONSTRAINT pk_fornecedor_id PRIMARY KEY (id);
ALTER TABLE produto ADD CONSTRAINT pk_produto_id PRIMARY KEY (id);
ALTER TABLE foto ADD CONSTRAINT pk_foto_id PRIMARY KEY (id);
ALTER TABLE foto ADD CONSTRAINT pk_foto_id PRIMARY KEY (id);

/* FOREIGN KEYS */
ALTER TABLE foto ADD CONSTRAINT fk_foto_produto FOREIGN KEY (produto) REFERENCES produto (id);
ALTER TABLE foto ADD CONSTRAINT fk_foto_produto FOREIGN KEY (produto) REFERENCES produto (id);


/* INDEXES */
