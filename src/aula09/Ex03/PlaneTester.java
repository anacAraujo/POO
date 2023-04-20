package aula09.Ex03;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        Scanner sc = new Scanner(System.in);
        int userchoise = 7;

        do {
            System.out.println(
                    "1 - Adicionar Avião\n2 - Remover Avião\n3 - Procurar Avião\n4 - Imprimir frota\n5 - Imprimir Aviões Tipo\n6 - Avião mais rápido\n7 - Sair");
            userchoise = sc.nextInt();
            switch (userchoise) {
                case 1:
                    System.out.println("1 - Avião Comercial\n2 - Avião Militar");
                    userchoise = sc.nextInt();

                    System.out.print("id: ");
                    String idAdd = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = sc.nextLine();
                    System.out.print("Ano Produção: ");
                    int ano = sc.nextInt();
                    System.out.print("Nº Máximo de Passageiros: ");
                    int maxPassageiros = sc.nextInt();
                    System.out.print("Velocidade Máxima: ");
                    int maxVelocidade = sc.nextInt();

                    switch (userchoise) {
                        case 1:
                            System.out.print("Nº Tripulantes: ");
                            int tripulantes = sc.nextInt();

                            CommercialPlane cp = new CommercialPlane(idAdd, fabricante, ano, maxPassageiros,
                                    maxVelocidade,
                                    tripulantes);
                            planeManager.addPlane(cp);
                            break;
                        case 2:
                            System.out.print("Nº Munições: ");
                            int municoes = sc.nextInt();

                            MilitaryPlane mp = new MilitaryPlane(idAdd, fabricante, ano, maxPassageiros, maxVelocidade,
                                    municoes);
                            planeManager.addPlane(mp);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Id: ");
                    String idRemover = sc.nextLine();
                    sc.nextLine();
                    planeManager.removePlane(idRemover);
                    break;
                case 3:
                    System.out.print("Id: ");
                    String idProcurar = sc.nextLine();
                    sc.nextLine();
                    planeManager.searchPlane(idProcurar).toString();
                    break;
                case 4:
                    planeManager.printAllPlanes();
                    break;
                case 5:
                    System.out.println("1- Comerciais\n2 - Militares");
                    userchoise = sc.nextInt();

                    switch (userchoise) {
                        case 1:
                            planeManager.getCommercialPlanes().toString();
                            break;
                        case 2:
                            planeManager.getMilitaryPlanes().toString();
                            break;
                    }
                    break;
                case 6:
                    planeManager.getFastestPlane().toString();
                    break;
            }
        } while (userchoise != 7);

        sc.close();
    }
}
