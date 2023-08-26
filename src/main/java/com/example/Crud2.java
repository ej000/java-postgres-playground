package com.example;

import java.sql.*;
import java.util.*;


public class Crud2 {
    public static void main(String[] args) {
        

        //tentativa de conexao com o Banco de Dados
        try{
        var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");
            System.out.println("Conexão com BD realizada com sucesso");
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        //menu de opcoes para input do usuario

        do{
            System.out.println("\nOpções:");
            System.out.println("1. Criar registro");
            System.out.println("2. Ler registros");
            System.out.println("3. Atualizar registro");
            System.out.println("4. Deletar registro");
            System.out.println("0. Sair");
            System.out.println("\nDigite o nº da opção desejada:");
            opcao = scanner.nextInt();

            switch(opcao){

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
                    System.out.println("Insira um valor válido");
                    break;
            }

        } while (opcao != 0);

        } catch(SQLException e) {
            System.out.println("Não foi possível conectar ao BD");
        }

        
    }

    //métodos CRUD

    private static void criarRegistro(Connection conn, Scanner scanner)throws SQLException {
        System.out.println("Digite o nome do aluno");
        String aluno = scanner.next();
        System.out.println("Digite a idade do aluno");
        int idade = scanner.nextInt();
        
        String sql = ("INSERT INTO planilha(aluno, idade) VALUES (?,?);");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,aluno);
        stmt.setInt(2, idade);
        stmt.executeUpdate();
        
        System.out.println("Registro criado com sucesso");

    }

    private static void lerRegistro(Connection conn)throws SQLException {
        String sql = ("SELECT * FROM planilha");
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        System.out.println("Registros dos alunos");
        while (result.next()){
            String aluno = result.getString("aluno");
            int idade = result.getInt("idade");
            System.out.println("Aluno:" + aluno + ", Idade:" + idade);
        }
        
    }

    private static void atualizarRegistro(Connection conn, Scanner scanner)throws SQLException {

    }

    private static void deletarRegistro(Connection conn, Scanner scanner)throws SQLException {

    }

}
