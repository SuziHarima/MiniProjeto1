import ui.Login;
import util.DadosAlunos;
import util.DadosDiretores;
import util.DadosProfessores;

public class Main {
    private static DadosAlunos dadosAlunos;
    private static DadosProfessores dadosProfessores;
    private static DadosDiretores dadosDiretores;
    public static void main(String[] args) {
        dadosAlunos = new DadosAlunos();
        dadosProfessores = new DadosProfessores();
        dadosDiretores = new DadosDiretores();
        Login.logar(dadosAlunos,dadosProfessores,dadosDiretores);
        dadosAlunos.listar();
        dadosProfessores.listar();
        dadosDiretores.listar();
    }
}
