package br.com.teste.screensound.principal;

import br.com.teste.screensound.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    
    public Principal(ArtistaRepository repositorio) {
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 9) { // sempre será true
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    _____________________________________________________         
                    9 - Sair
                    -----------------------------------------------------
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoArtista() {

    }

    private void buscarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMusicas() {
    }

    private void cadastrarArtistas() {
    }
}