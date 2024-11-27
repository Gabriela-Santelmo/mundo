package mundo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Continente america = criarContinenteAmerica();
        Continente africa = criarContinenteAfrica();
        Continente asia = criarContinenteAsia();
        Continente europa = criarContinenteEuropa();
        Continente oceania = criarContinenteOceania();
        Continente antartida = new Continente("Antártida");

        boolean running = true;

        while (running) {
            exibirMenuPrincipal();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    consultarDadosPais(scanner, america, africa, asia, europa, oceania, antartida);
                    break;
                case "2":
                    menuContinentes(scanner, america, africa, asia, europa, oceania, antartida);
                    break;
                case "3":
                    adicionarPais(scanner, america, africa, asia, europa, oceania, antartida);
                    break;
                case "4":
                    consultarPaises(america, africa, asia, europa, oceania, antartida);
                    break;
                case "0":
                    System.out.println("\nVocê saiu. Tchau!");
                    running = false;
                    break;
                default:
                    System.out.println("\nOpção inválida, digite apenas números.\n");
            }
        }

        scanner.close(); 
    }

    private static void exibirMenuPrincipal() {
        System.out.println(" ==========================================");    	
        System.out.println("|                MUNDO                     |");
        System.out.println(" ==========================================");    	
        System.out.println("|           ESCOLHA UMA OPÇÃO:             |");
        System.out.println("| 1 – Dados sobre País                     |");
        System.out.println("| 2 – Dados sobre Continente               |");
        System.out.println("| 3 – Adicionar País                       |");
        System.out.println("| 4 – Consultar Países Armazenados         |");
        System.out.println("| 0 – Sair                                 |");
        System.out.println(" ==========================================");    	
    }

    private static Continente criarContinenteAmerica() {
        Continente america = new Continente("América");
        america.adicionarPais(new Pais("BRA", "Brasil", 8515767, 213993441));
        america.adicionarPais(new Pais("USA", "Estados Unidos", 9833517, 331002651));
        america.adicionarPais(new Pais("CAN", "Canadá", 9984670, 37742154));
        return america;
    }

    private static Continente criarContinenteAfrica() {
        Continente africa = new Continente("África");
        africa.adicionarPais(new Pais("NGA", "Nigéria", 923768, 206139589));
        africa.adicionarPais(new Pais("ETH", "Etiópia", 1104300, 114963588));
        africa.adicionarPais(new Pais("EGY", "Egito", 1002450, 102334404));
        return africa;
    }

    private static Continente criarContinenteAsia() {
        Continente asia = new Continente("Ásia");
        asia.adicionarPais(new Pais("CHN", "China", 9596961, 1444216107));
        asia.adicionarPais(new Pais("IND", "Índia", 3287263, 1393409038));
        asia.adicionarPais(new Pais("JPN", "Japão", 377975, 126476461));
        return asia;
    }

    private static Continente criarContinenteEuropa() {
        Continente europa = new Continente("Europa");
        europa.adicionarPais(new Pais("DEU", "Alemanha", 357022, 83783942));
        europa.adicionarPais(new Pais("FRA", "França", 551695, 65273511));
        europa.adicionarPais(new Pais("ITA", "Itália", 301340, 60317116));
        return europa;
    }

    private static Continente criarContinenteOceania() {
        Continente oceania = new Continente("Oceania");
        oceania.adicionarPais(new Pais("AUS", "Austrália", 7692024, 25687041));
        oceania.adicionarPais(new Pais("NZL", "Nova Zelândia", 268838, 5084300));
        return oceania;
    }
    
    private static void menuContinentes(Scanner scanner, Continente... continentes) {
        boolean running = true;
        while (running) {
            System.out.println("\n- ESCOLHA UM CONTINENTE:");
            for (int i = 0; i < continentes.length; i++) {
                System.out.println((i + 1) + " - " + continentes[i].getNome());
            }
            System.out.println("0 - Retornar ao menu inicial");

            String opcao = scanner.nextLine();
            try {
                int escolha = Integer.parseInt(opcao);
                if (escolha == 0) {
                    running = false;
                } else if (escolha >= 1 && escolha <= continentes.length) {
                    exibirDadosContinente(continentes[escolha - 1]);
                } else {
                    System.out.println("Opção inválida, escolha um número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    private static void exibirDadosContinente(Continente continente) {
        int numeroPaises;
        switch (continente.getNome()) {
            case "América":
                numeroPaises = 35;
                break;
            case "África":
                numeroPaises = 54;
                break;
            case "Ásia":
                numeroPaises = 49;
                break;
            case "Europa":
                numeroPaises = 44;
                break;
            case "Oceania":
                numeroPaises = 14;
                break;
            case "Antártida":
                numeroPaises = 0; // Não possui países reconhecidos
                break;
            default:
                numeroPaises = continente.getPaises().size(); // Caso não esteja listado
        }

        System.out.println("\nDados sobre o continente: " + continente.getNome());
        System.out.println("Número de países reconhecidos: " + numeroPaises);
        System.out.println("Número de países cadastrados: " + continente.getPaises().size());
        System.out.println("População total: " + continente.getPopulacaoTotal());
        System.out.println("Dimensão total (km²): " + continente.getDimensaoTotal());
        System.out.println("Densidade populacional: " + continente.getDensidadePopulacional());
        if (!continente.getPaises().isEmpty()) {
            System.out.println("País com maior população: " + continente.getPaisMaiorPopulacao().getNome());
            System.out.println("País com menor população: " + continente.getPaisMenorPopulacao().getNome());
            System.out.println("País com maior dimensão: " + continente.getPaisMaiorDimensao().getNome());
            System.out.println("País com menor dimensão: " + continente.getPaisMenorDimensao().getNome());
        } else {
            System.out.println("Nenhum país registrado neste continente.");
        }
    }

    private static void consultarDadosPais(Scanner scanner, Continente... continentes) {
        System.out.println("\n- CONSULTAR DADOS DE UM PAÍS");
        System.out.print(" Digite o nome do país que deseja consultar: ");
        String nomePais = scanner.nextLine().trim();

        for (Continente continente : continentes) {
            for (Pais pais : continente.getPaises()) {
                if (pais.getNome().equalsIgnoreCase(nomePais)) {
                    System.out.println("\nInformações sobre o país: " + pais.getNome());
                    System.out.println("Código ISO: " + pais.getCodigoISO());
                    System.out.println("População: " + pais.getPopulacao());
                    System.out.println("Dimensão (km²): " + pais.getDimensao());
                    System.out.println("Densidade populacional: " + pais.getDensidadePopulacional());
                    System.out.println("Localizado no continente: " + continente.getNome());
                    System.out.println("");
                    return;
                }
            }
        }
        System.out.println("País não encontrado no sistema.\n");
    }

    private static void adicionarPais(Scanner scanner, Continente... continentes) {
        System.out.println("\n- ADICIONAR UM NOVO PAÍS");

        System.out.print("Digite o nome abreviado (exemplo: BRA): ");
        String codigoISO = scanner.nextLine().toUpperCase();

        System.out.print("Digite o nome do país: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o continente onde o país está localizado (América, África, Ásia, Europa, Oceania ou Antártida: ");
        String nomeContinente = scanner.nextLine();

        System.out.print("Digite a população total do país (número inteiro, sem pontuação): ");
        long populacao = Long.parseLong(scanner.nextLine());

        System.out.print("Digite a dimensão total (em km² e utilize .(ponto)): ");
        double dimensao = Double.parseDouble(scanner.nextLine());

        for (Continente continente : continentes) {
            if (continente.getNome().equalsIgnoreCase(nomeContinente)) {
                Pais novoPais = new Pais(codigoISO, nome, dimensao, populacao);
                continente.adicionarPais(novoPais);
                System.out.println("País adicionado ao continente: " + continente.getNome());
                System.out.println("");
                return;
            }
        }
        System.out.println("Continente inválido! Tente novamente.\n");
    }

    private static void consultarPaises(Continente... continentes){
        System.out.println("\n- PAÍSES ARMAZENADOS NO SISTEMA:");
        for (Continente continente : continentes) {
            System.out.println("\n" + continente.getNome() + ":");
            if (continente.getPaises().isEmpty()) {
                System.out.println("  Nenhum país registrado.\n");
            } else {
                for (Pais pais : continente.getPaises()) {
                    System.out.println("  - " + pais.getNome() + " (" + pais.getCodigoISO() + ")");
                }
            }
        }
    }
}