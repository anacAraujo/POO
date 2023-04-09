package aula08.Ex01;

public class Main {
    public static void main(String[] args) {
        Ligeiro ligeiro = new Ligeiro("AA-AA-00", "AAAA", "aaa00a", 222, "FG45DFF345CV56", 444);
        ligeiro.trajeto(1);
        ligeiro.trajeto(1111);
        ligeiro.trajeto(-22);
        System.out.println(ligeiro.ultimoTrajeto());
        System.out.println(ligeiro.distanciaTotal());

        EmpresaAluguer empresa = new EmpresaAluguer("Carros Aluguer", "1111-111", "aluguer@carros.pt");
        empresa.adicionarAutomovel(ligeiro);
        System.out.println(empresa);
    }
}
