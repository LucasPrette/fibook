## Fibook

### Autores
- Lucas Del Prette
- Matheus Augusto Ferreira
- Matsu Shimote

### Início Rápido
#### Criando as tabelas
Inicie seu SQL Server, cre um schema  `fibook` e abra o editor SQL de sua preferência e rode as seguintes queries
```sql
CREATE TABLE fibook.usuario(
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE fibook.post(
    id INT IDENTITY(1,1) PRIMARY KEY,
    conteudo VARCHAR(1000) NOT NULL,
    usuario_id INT NOT NULL,
    
    FOREIGN KEY (usuario_id) REFERENCES fibook.usuario(id)
);

CREATE TABLE fibook.comentario(
    id INT IDENTITY(1,1) PRIMARY KEY,
    post_id INT NOT NULL,
    usuario_id INT NOT NULL,
    conteudo VARCHAR(1000) NOT NULL,
    
    FOREIGN KEY (post_id) REFERENCES fibook.post(id),
    FOREIGN KEY (usuario_id) REFERENCES fibook.usuario(id)
);
```

#### Conectando ao banco de dados
Abra o arquivo `BancoDeDados.java` e confirme se as informações de **schema**, **usuario** e **senha** estão iguais aos configurados em seu SQL server 

#### Rodando a aplicação
 Abra o arquivo `Main.java` e rode a aplicação utilizando o IntelliJ.