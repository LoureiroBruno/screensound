package br.com.teste.screensound.principal;

import br.com.teste.screensound.model.Artista;
import br.com.teste.screensound.model.Musica;
import br.com.teste.screensound.model.TipoArtista;
import br.com.teste.screensound.repository.ArtistaRepository;
import br.com.teste.screensound.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final ArtistaRepository repositorio;
    
    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
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
                                    
                    9 - Sair
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

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista: ");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla ou banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }

    private void cadastrarMusicas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Cadastrar música de que artista? ");
            var nome = leitura.nextLine();

            Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

            if (artista.isPresent()) {
                System.out.println("Qual o nome da música? ");
                var nomeMusica = leitura.nextLine();

                Musica musica = new Musica(nomeMusica);
                musica.setArtista(artista.get());
                artista.get().getMusicas().add(musica);
                repositorio.save(artista.get());

                System.out.println("Cadastrar outra musica? (S/N)");
                cadastrarNovo = leitura.nextLine();

            } else {
                System.out.println("Artista não encontrado");
            }
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de que artista? ");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscarMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar dados sobre qual artista? ");
        var nome = leitura.nextLine();
        var resposta = ConsultaChatGPT.obterInformacao(nome);
        System.out.println(resposta.trim());
    }

}