CREATE TABLE produto_dimdim (
    id NUMBER PRIMARY KEY,
    nome VARCHAR2(255),
    descricao VARCHAR2(1000),
    preco NUMBER,
    quantidade_em_estoque NUMBER,
    fornecedor_id NUMBER,
    CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor_dimdim(id)
);

CREATE TABLE fornecedor_dimdim (
    id NUMBER PRIMARY KEY,
    nome VARCHAR2(255),
    endereco VARCHAR2(500),
    telefone VARCHAR2(20)
);
