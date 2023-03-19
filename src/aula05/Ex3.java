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
        this.properties = new Property[5];
        this.nProperties = 0;
    }

    public void newProperty(String location, int rooms, int price) {
        this.properties[nProperties] = new Property(location, rooms, price);
        this.nProperties++;
    }

    private Property getProperty(int idProperty) {
        if (idProperty > (this.properties[nProperties - 1].getIdProperty())) {
            return null;
        }
        for (int i = 0; i < this.nProperties; i++) {
            if (this.properties[i].getIdProperty() == idProperty) {
                return this.properties[i];
            }
        }
        return null;
    }

    public void sell(int idProperty) {
        Property property = this.getProperty(idProperty);

        if (property == null) {
            System.out.println("Imovel " + idProperty + ": nao existe.");
            return;
        }

        if (property.getisAvailable()) {
            property.setAvailable(false);
            System.out.println("Imovel " + idProperty + ": vendido.");
        } else {
            System.out.println("Imovel " + idProperty + ": nao está disponível.");
        }
    }

    public void setAuction(int idProperty, DateYMD auction, int duration) {
        Property property = this.getProperty(idProperty);

        if (property == null) {
            return;
        }

        DateYMD end = new DateYMD(auction.getDay(), auction.getMonth(), auction.getYear());

        property.setDateInit(auction);
        for (int i = 1; i < duration; i++) {
            end.increment();
        }
        property.setDateEnd(end);
    }

    public String toString() {
        String result = "Propriedades:\n";

        // for (int i = 0; i < this.nProperties; i++) {
        // result += this.properties[i].toString();
        // }

        for (Property property : properties) {
            result += property.toString();
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
