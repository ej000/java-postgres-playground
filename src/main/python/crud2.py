import sqlite3

conexao = sqlite3.connect("database.db")

conexao.execute("DROP TABLE IF EXISTS cadastro;")
conexao.execute('''CREATE TABLE cadastro(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    idade int NOT NULL);''')

def criar_registro(nome, idade):
    conexao.execute("INSERT INTO cadastro(nome, idade) VALUES(?,?);", (nome, idade))
    conexao.commit()
    print("Cadastro realizado com sucesso")

def listar_cadastros():
    listar_nomes = conexao.execute("SELECT * FROM cadastro;")
    for nome in listar_nomes:
        print(nome)

def atualizar_registro(new_nome,new_idade, nome):
    conexao.execute("UPDATE cadastro SET nome=?, idade=? WHERE nome=?;", (new_nome, new_idade, nome))
    conexao.commit()
    print("Cadastros atualizados")

def deletar_registros(id):
    conexao.execute("DELETE FROM cadastro WHERE id=?;", (id,))
    conexao.commit()
    print("Cadastro deletado com sucesso")


criar_registro("Jose", 40)
criar_registro("Maria", 36)
criar_registro("Paulo", 42)
listar_cadastros()
atualizar_registro("Cris",38,"Maria")
listar_cadastros()
deletar_registros(3)
listar_cadastros()