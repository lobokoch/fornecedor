/**************** WARNING WILL DELETE ALL TABLES *********
DROP TABLE IF EXISTS fornecedor CASCADE;
**********************************************************/

CREATE TABLE fornecedor (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	cpf_cnpj VARCHAR(255) /* cpfCNPJ */,
	ie VARCHAR(255),
	nome_contato VARCHAR(255) /* nomeContato */,
	fone VARCHAR(255),
	celular VARCHAR(255),
	email VARCHAR(255),
	site VARCHAR(255),
	observacoes VARCHAR(1000)
);

/* PRIMARY KEYS */
ALTER TABLE fornecedor ADD CONSTRAINT pk_fornecedor_id PRIMARY KEY (id);

/* FOREIGN KEYS */

