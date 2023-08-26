import sqlite3

conexao = sqlite3.connect("database.db")
conexao.execute("DROP TABLE IF EXISTS tabela;")
conexao.execute('''CREATE TABLE tabela (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    idade int NOT NULL
    );''')

def criar_cadastro(nome, idade):
    conexao.execute("INSERT INTO tabela(nome,idade) VALUES(?,?);",(nome,idade))
    conexao.commit()
    print("Cadastro criado com sucesso")

def ler_cadastro():
    listar_cadastros = conexao.execute("SELECT * FROM tabela;")
    for nome in listar_cadastros:
        print(nome)

def atualizar_cadastro(id, novo_nome, nova_idade):
    conexao.execute("UPDATE tabela SET nome=?, idade=? WHERE id=? ;", (novo_nome, nova_idade, id))
    conexao.commit()
    print("Cadastro atualizado com sucesso")

def deletar_cadastro(id):
    conexao.execute("DELETE FROM tabela WHERE id=?;", (id,)) #NÃO ESQUECER DE DIGITAR A VÍRGULA PÓS ID
    conexao.commit()
    print("Cadastro deletado com sucesso")

criar_cadastro("Joao", 18)
criar_cadastro("Maria", 17)
ler_cadastro()
atualizar_cadastro(2, "Joelma", 19)
ler_cadastro()
deletar_cadastro(2)


