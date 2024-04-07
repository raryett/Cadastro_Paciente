
import java.time.LocalDate;
import java.time.LocalTime;

public class Paciente {

    private String nome_paciente;
    private int cpf;
    private int idade;
    private int telefone;
    private LocalDate data;
    private LocalTime hora;
    

    public String getNome_paciente() {  //metodo que retorna dados
        return this.nome_paciente;
    }

    public void setNome_Paciente(String nomePaciente) {
        this.nome_paciente = nomePaciente;

    }

    public int getcpf() {
        return this.cpf;
    }

    public void setCpf(int numcpf) {
        this.cpf = numcpf;
    }

    public int getidade() {
        return this.idade;
    }

    public void setIdade(int numidade) {
        this.cpf = numidade;
    }
    
    public int gettelefone() {
        return this.telefone;
    }

    public void setTelefone(int numtelefone) {
        this.cpf = numtelefone;
    }
    
    
    
    

    public LocalDate getdata() {
        return this.data;
    }

    public LocalDate setdata(LocalDate Data) {
        return this.data;
    }

     public LocalTime gethora() {
        return this.hora;
    }

    public LocalTime setdata(LocalTime Hora) {
        return this.hora;
    }

}
