package core;

public class Car {
    // Глобальные переменные
    private String number;
    private int height;
    private double weight;
    private boolean hasVehicle;
    private boolean isSpecial;

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public boolean getVehicle() { return this.hasVehicle; }
    public void setVehicle(boolean hasVehicle) { this.hasVehicle = hasVehicle; }

    public boolean getSpecial() { return this.isSpecial; }
    public void setSpecial(boolean isSpecial) { this.isSpecial = isSpecial; }

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}