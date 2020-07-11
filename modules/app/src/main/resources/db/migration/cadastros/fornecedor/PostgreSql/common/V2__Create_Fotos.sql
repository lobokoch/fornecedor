
CREATE TABLE produto /* Produto */  (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE foto /* Foto */  (
	id UUID NOT NULL,
	imagem BYTEA NOT NULL,
	miniatura BYTEA,
	nome VARCHAR(255),
	descricao VARCHAR(255),
	tamanho NUMERIC(19),
	tipo VARCHAR(255) NOT NULL,
	produto UUID NOT NULL
);

/* PRIMARY KEYS */
ALTER TABLE produto ADD CONSTRAINT pk_produto_id PRIMARY KEY (id);
ALTER TABLE foto ADD CONSTRAINT pk_foto_id PRIMARY KEY (id);

/* FOREIGN KEYS */
ALTER TABLE foto ADD CONSTRAINT fk_foto_produto FOREIGN KEY (produto) REFERENCES produto (id);


/* INDEXES */
