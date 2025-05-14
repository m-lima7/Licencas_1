-- Criação da seq de licencas

CREATE SEQUENCE LICENCA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da seq de alertas

CREATE SEQUENCE ALERTA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da seq de empresas

CREATE SEQUENCE EMPRESAS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Criação da tabela empresas
CREATE TABLE t_empresas (
                           id_empresa INTEGER PRIMARY KEY NOT NULL,
                           nome_empresa VARCHAR2(100) NOT NULL,
                           cnpj NUMBER NOT NULL
);

-- Criação da tabela t_licencas
CREATE TABLE t_licencas (
                            id_licenca INTEGER PRIMARY KEY NOT NULL,
                            empresa VARCHAR2(100) NOT NULL,
                            id_tipo NUMBER NOT NULL,
                            data_emissao DATE NOT NULL,
                            data_validade DATE NOT NULL,
                            status_licenca VARCHAR2(50) NOT NULL
);

-- Criação da tabela t_alertas
CREATE TABLE t_alertas (
                           id_alerta INTEGER PRIMARY KEY NOT NULL,
                           id_licenca NUMBER NOT NULL,
                           data_alerta DATE NOT NULL,
                           mensagem VARCHAR2(200) NOT NULL,
                           enviado CHAR(1) NOT NULL CHECK (enviado IN ('S', 'N')),
                           CONSTRAINT fk_licenca FOREIGN KEY (id_licenca) REFERENCES t_licencas(id_licenca)
);