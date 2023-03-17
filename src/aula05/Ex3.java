package aula05;

class Property {

    private static int currentId = 1000;

    private int idProperty;
    private int rooms;
    private String location;
    private int price;
    private boolean isAvailable;
    private DateYMD dateInit;
    private DateYMD dateEnd;

    public Property(String location, int rooms, int price) {
        this.location = location;
        this.rooms = rooms;
        this.price = price;
        this.idProperty = currentId;
        this.isAvailable = true;
        this.dateInit = null;
        this.dateEnd = null;
        Property.currentId++;
    }

    public String getLocation() {
        return location;
    }

    public int getRooms() {
        return rooms;
    }

    public int getPrice() {
        return price;
    }

    public int getIdProperty() {
        return idProperty;
    }

    public boolean getisAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public static void setCurrentId(int currentId) {
        Property.currentId = currentId;
    }

    public void setDateInit(DateYMD dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(DateYMD dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String toString() {
        String available;
        if (this.isAvailable) {
            available = "sim";
        } else {
            available = "nao";
        }

        String dates;
        if (this.dateInit == null || !this.isAvailable) {
            dates = "";
        } else {
            dates = "; leilao " + this.dateInit + " : " + this.dateEnd;
        }
        return "Imóvel: " + this.idProperty + "; quartos: " + this.rooms
                + "; localidade: " + this.location + "; preço: " + this.price + "; disponivel: " + available
                + dates + "\n";
    }

}

class RealEstate {
    private Property[] properties;
    private int nProperties;

    public RealEstate() {
        this.properties = new Property[90];
        this.nProperties = 0;
    }

    public void newProperty(String location, int rooms, int price) {
        properties[nProperties] = new Property(location, rooms, price);
        nProperties++;
    }

    public void sell(int idProperty) {
        if (idProperty > (properties[nProperties - 1].getIdProperty())) {
            System.out.println("Imovel " + idProperty + ": nao existe.");
            return;
        }
        int position = 0;
        for (int i = 0; i < this.nProperties; i++) {
            if (this.properties[i].getIdProperty() == idProperty) {
                position = i;
                break;
            }
        }
        if (position < 0) {
            System.out.println("Imovel " + idProperty + ": nao existe.");
            return;
        }
        if (properties[position].getisAvailable()) {
            System.out.println("Imovel " + idProperty + ": vendido.");
        }
        if (!properties[position].getisAvailable()) {
            System.out.println("Imovel " + idProperty + ": nao está disponível.");
        }
        properties[position].setAvailable(false);
    }

    public void setAuction(int idProperty, DateYMD auction, int duration) {
        int position = 0;
        DateYMD end = new DateYMD(auction.getDay(), auction.getMonth(), auction.getYear());
        for (int i = 0; i < this.nProperties; i++) {
            if (this.properties[i].getIdProperty() == idProperty) {
                position = i;
                break;
            }
        }
        properties[position].setDateInit(auction);
        for (int i = 1; i < duration; i++) {
            end.increment();
            properties[position].setDateEnd(end);
        }
    }

    public String toString() {
        String result = "Propriedades:\n";

        for (int i = 0; i < nProperties; i++) {

            result += properties[i].toString();
        }
        return result;
    }
}

public class Ex3 {
    public static void main(String[] args) {
        RealEstate imobiliaria = new RealEstate();
        imobiliaria.newProperty("Glória", 2, 30000);
        imobiliaria.newProperty("Vera Cruz", 1, 25000);
        imobiliaria.newProperty("Santa Joana", 3, 32000);
        imobiliaria.newProperty("Aradas", 2, 24000);
        imobiliaria.newProperty("São Bernardo", 2, 20000);

        imobiliaria.sell(1001);
        imobiliaria.sell(1001);
        imobiliaria.sell(1010);
        imobiliaria.setAuction(1002, new DateYMD(21, 03, 2023), 4);
        imobiliaria.setAuction(1003, new DateYMD(1, 4, 2023), 3);
        imobiliaria.setAuction(1001, new DateYMD(1, 4, 2023), 4);
        imobiliaria.setAuction(1010, new DateYMD(1, 4, 2023), 4);

        System.out.println(imobiliaria);

    }
}
