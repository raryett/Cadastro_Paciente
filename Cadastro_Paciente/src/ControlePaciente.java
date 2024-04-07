
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bia-1
 */
public class ControlePaciente {

    Pacientes pacientes = new Pacientes();//declaraçao de objeto 

    java.sql.ResultSet rsRegistro; //objeto com caracteristica receber um conjunto de dados atraves da interface resultset.

    private Statement comando = null;
    private Connection conexao = null;

    public void conexao() { //criando o metodo

        try {
            //definiçao de variaveis necessarias para conexao ao mysql
            //banco de dados
            String servername = "localhost:3306"; //conexao local com a porta 3306 depende da porta do xampp
            String namebd = "clinica1db";
            //usuario e senha do banco
            String username = "root";
            String password = "";
            //especifica o driver utilizado
            String drivername = "com.mysql.cj.jdbc.Driver"; //precisa ser especificado apenas uma vez, procurar o driver instalado
            Class.forName(drivername);

            //criando a conexao com o banco de dados, instruçao sql + variavel poderia ser a instruçao com todos os dados sem ter que declarar a variavel
            String url = "jdbc:mysql://" + servername + "/" + namebd + "?useTimezone=true&serverTimezone=UTC"; //timezone para nao ter erro com o fuso horario
            conexao = DriverManager.getConnection(url, username, password);
            comando = conexao.createStatement();

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver nao encontrado: " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro de conexao ao banco: " + e);
        }

    }

    public void Cadastrar(String nomePaciente, int cpf, int idade, int numTel, String procedimento, String data, String hora) {
        pacientes.setnome_Paciente(nomePaciente);
        pacientes.setCpf(cpf);
        pacientes.setIdade(idade);
        pacientes.setTelefone(numTel);
        pacientes.setProcedimento(procedimento);
        pacientes.setData(data);
        pacientes.setHora(hora);

        PreparedStatement sql;//chamar interface

        try {
            sql = conexao.prepareStatement("Insert into aluno(nomePaciente,cpf,idade,numTel,procedimento,data,hora) values(?, ?, ?, ?,?,?,?)");//instruçao em sql para inserir o registro
            
            sql.setString(1,pacientes.getNome_Paciente());
            sql.setInt(2, pacientes.getCpf()); 
            sql.setInt(3, pacientes.getIdade());
            sql.setInt(4, pacientes.getTelefone());
            sql.setString(5,pacientes.getProcedimento());
            sql.setString(6,pacientes.getData());
            sql.setString(7,pacientes.getHora());
            
            int reg = sql.executeUpdate();//resposta para saber se conseguiu inserir uma linha ao banco de dados ou nao
            if (reg != 0) {
                JOptionPane.showMessageDialog(null, "registro cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "erro ao cadastrar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexao com o banco nome do erro: " + e);
        }

    }

}


