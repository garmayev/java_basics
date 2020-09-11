package core;

public class Camera {
    public static Car getNextCar() {
        // Локальная переменная: создание случайного числа для создания номера авто
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        // Локальная переменная: создание случайного числа для создания высоты авто
        int randomHeight = (int) (1000 + 3500. * Math.random());
        // Локальная переменная: создание случайного числа для создания веса авто
        double randomWeight = 600 + 10000 * Math.random();

        // Локальная переменная: создание экзепляра авто
        Car car = new Car();
        // Задание номера для авто
        car.number = randomNumber;
        // Задание высоты для авто
        car.height = randomHeight;
        // Задание веса для авто
        car.weight = randomWeight;
        //
        car.hasVehicle = Math.random() > 0.5;
        // Определение спецтранспорта
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}