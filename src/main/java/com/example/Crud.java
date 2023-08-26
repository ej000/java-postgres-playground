package com.example;

import java.sql.*;
import java.util.*;

public class Crud {
	public static void main(String[] args){

        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "")){
	        System.out.println("Conexão realizada com sucesso");

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\nOpções:");
                System.out.println("1. Criar registro");
                System.out.println("2. Ler registro");
                System.out.println("3. Atualizar registro");
                System.out.println("4. Deletar registro");
                System.out.println("0. Sair");
                System.out.println("\n Digite uma opção");
                opcao = scanner.nextInt();

                switch (opcao){
                    case 1:
                        criarRegistro(conn, scanner);
                        break;
                    case 2:
                        lerRegistro(conn);
                        break;
                    case 3:
                        atualizarRegistro(conn, scanner);
                        break;
                    case 4:
                        deletarRegistro(conn, scanner);
                        break;
                    case 0:
                        System.out.println("Encerrando Programa");
                        break;
                    default:
                        System.out.println("Insira uma opção válida!");
                        break;
                }

            } while (opcao != 0);

        } catch (SQLException e){
            System.err.println("Não foi possível conectar ao BD" + e.getMessage());
        }
    }

    public static void criarRegistro(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Digite o nome do aluno");
        String aluno = scanner.next();
        System.out.println("Digite a idade do aluno");
        int idade = scanner.nextInt();

        String sql = ("INSERT INTO planilha(aluno, idade) VALUES (?,?);");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno);
        stmt.setInt(2, idade);
        stmt.executeUpdate();

        System.out.println("Registro criado com sucesso!");
    }

    public static void lerRegistro(Connection conn) throws SQLException {
        String sql = ("SELECT * FROM planilha");
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        
        System.out.println("Registros dos alunos");
        while (result.next()){
            String aluno = result.getString("aluno");
            int idade = result.getInt("idade");
            System.out.println("Aluno: " + aluno + ", Idade: " +idade);
        }        

    }
    
    public static void atualizarRegistro(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Digite o nome do aluno a atualizar");
        String alunoAntigo = scanner.next();
        System.out.println("Digite o novo nome do aluno");
        String alunoNovo = scanner.next();
        System.out.println("Digite a nova idade");
        int idadeNova = scanner.nextInt();
        
        String sql = ("UPDATE planilha SET aluno=?, idade=? WHERE aluno=?;");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, alunoNovo);
        stmt.setInt(2, idadeNova);
        stmt.setString(3, alunoAntigo);
        stmt.executeUpdate();

        System.out.println("Registro atualizado com sucesso");

    }

    public static void deletarRegistro(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Digite o nome do aluno a deletar");
        String aluno = scanner.next();

        String sql = ("DELETE FROM planilha WHERE aluno=?");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno);
        stmt.executeUpdate();

        System.out.println("Aluno deletado com sucesso");
    }
}
	       