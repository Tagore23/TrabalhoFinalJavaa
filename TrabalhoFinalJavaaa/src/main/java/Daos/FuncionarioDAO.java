package Daos;

import Models.Funcionario;
import Models.Gerente;
import Models.FuncionarioGeral;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final Logger logger = LogManager.getLogger(FuncionarioDAO.class);
    private String filePath;
    private FileManager fileManager;

    public FuncionarioDAO(String filePath) {
        this.filePath = filePath;
        this.fileManager = new FileManager(); // Inicializa o FileManager com o construtor padrão
        criarDiretorio(filePath); // Chama o método criarDiretorio com o caminho do arquivo
    }

    private void criarDiretorio(String filePath) {
        if (filePath == null) {
            logger.error("Caminho de arquivo é nulo.");
            return;
        }
        this.fileManager.criarDiretorio(new File(filePath).getParent()); // Utiliza new File(filePath).getParent() para obter o diretório pai
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = lerFuncionarios();
        funcionarios.add(funcionario);
        escreverFuncionarios(funcionarios);
    }

    public List<Funcionario> lerFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            inicializarArquivo(); // Inicializa com funcionários padrão se o arquivo não existir
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    double salario = Double.parseDouble(dados[2]);
                    int horasMensais = Integer.parseInt(dados[3]);
                    String funcao = dados[4];

                    // Verifica o tipo de funcionário pela função
                    Funcionario funcionario;
                    if (funcao.equalsIgnoreCase("Gerente")) {
                        funcionario = new Gerente();
                    } else {
                        funcionario = new FuncionarioGeral(id, nome, salario, horasMensais, funcao);
                    }
                    funcionarios.add(funcionario);
                }
            } catch (IOException e) {
                logger.error("Erro ao ler funcionários do arquivo.", e);
            }
        }
        return funcionarios;
    }

    private void escreverFuncionarios(List<Funcionario> funcionarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Funcionario funcionario : funcionarios) {
                bw.write(funcionario.getId() + "," + funcionario.getNome() + "," +
                        funcionario.getSalario() + "," + funcionario.getHorasMensais() + "," +
                        funcionario.getFuncao());
                bw.newLine();
            }
        } catch (IOException e) {
            logger.error("Erro ao escrever funcionários no arquivo.", e);
        }
    }

    private void inicializarArquivo() {
        List<Funcionario> funcionarios = new ArrayList<>();
        // Exemplo de inicialização com funcionários padrão
        funcionarios.add(new Gerente());
        funcionarios.add(new FuncionarioGeral(2, "Maria", 2000.0, 160, "Atendente"));
        escreverFuncionarios(funcionarios);
    }

    public boolean removerFuncionarioPorID(int id) {
        List<Funcionario> funcionarios = lerFuncionarios();
        Funcionario funcionarioARemover = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionarioARemover = funcionario;
                break;
            }
        }
        if (funcionarioARemover != null) {
            funcionarios.remove(funcionarioARemover);
            escreverFuncionarios(funcionarios);
            return true;
        }
        return false;
    }

    public void atualizarFuncionario(Funcionario funcionarioAtualizado) {
        List<Funcionario> funcionarios = lerFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == funcionarioAtualizado.getId()) {
                funcionarios.set(i, funcionarioAtualizado);
                break;
            }
        }
        escreverFuncionarios(funcionarios);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        List<Funcionario> funcionarios = lerFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }
}
