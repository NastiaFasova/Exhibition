package museum;

public enum TypeOfExhibition {
    BIOGRAPHICAL(120), HISTORICAL(150), BOTANICAL(180),
    ARTISTIC(180), ZOOLOGICAL(195);
    private double price;
    private static final long ENUM_SIZE = 4;

    TypeOfExhibition(double price) {
        this.price = price;
    }

    TypeOfExhibition() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String showTypeOfMuseumExhibition() {
        System.out.print("TypeOfMuseumExhibition enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (TypeOfExhibition typeOfExhibition : TypeOfExhibition.values()) {
            if (typeOfExhibition.price != 0) {
                stringBuilder.append(typeOfExhibition)
                        .append(" price: ")
                        .append(typeOfExhibition.price)
                        .append("; ");
            } else {
                stringBuilder.append(typeOfExhibition);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    @Override
    public String toString() {
        return "TypeOfExhibition{" +
                "price=" + price +
                "} " + super.toString();
    }
}