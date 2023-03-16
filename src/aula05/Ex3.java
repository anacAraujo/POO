package aula05;

class Property {
    private String location;
    private int rooms;
    private int price;
    private int idProperty;
    private boolean isAvailable = true;

    public Property(String loccation, int rooms, int price, int idProperty) {
        this.location = loccation;
        this.rooms = rooms;
        this.price = price;
        this.idProperty = idProperty;
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

}

class RealEstate {
    private Property[] properties = new Property[5];
    private int nProperties = 0;
    private int nIdProerty = 1000;

    public void newProperty(String location, int rooms, int price) {
        properties[nProperties] = new Property(location, rooms, price, nIdProerty);
        nProperties++;
        nIdProerty++;
    }

    public void sell(int idProperty) {
        // TODO
        int position = 0;
        switch (idProperty) {
            case 1000:
                position = 0;
                break;
            case 1001:
                position = 1;
                break;
            case 1002:
                position = 2;
                break;
            case 1003:
                position = 3;
                break;
            case 1004:
                position = 4;
                break;
        }
        properties[position].setAvailable(false);
    }

    public void setAuction(int idProperty, DateYMD auction, int duration /*
                                                                          * não tenho a certeza se este int representa a
                                                                          * duração do leitão
                                                                          */) {
        // TODO
    }

    public String toString() {
        // TODO datas
        String result = "";
        String available;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getisAvailable()) {
                available = "sim";
            } else {
                available = "nao";
            }
            result += "Imóvel: " + properties[i].getIdProperty() + "; quartos: " + properties[i].getRooms()
                    + "; localidade: " + properties[i].getLocation() + "; preço: " + properties[i].getPrice()
                    + "; disponivel: " + available + "....... \n";
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
        imobiliaria.setAuction(1002, new DateYMD(21, 3, 2023), 4);
        imobiliaria.setAuction(1003, new DateYMD(1, 4, 2023), 3);
        imobiliaria.setAuction(1001, new DateYMD(1, 4, 2023), 4);
        imobiliaria.setAuction(1010, new DateYMD(1, 4, 2023), 4);

        System.out.println(imobiliaria);

    }
}
