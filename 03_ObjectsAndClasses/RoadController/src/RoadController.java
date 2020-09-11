import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    // Объявление глобальных переменных
    // Максимальный вес пассажирского автомобиля
    private static double passengerCarMaxWeight = 3500.0; // kg
    // Максимальная высота пассажирского автомобиля
    private static int passengerCarMaxHeight = 2000; // mm
    // Максимальная высота пропускного пункта
    private static int controllerMaxHeight = 3500; // mm

    // Цена проезда пассажского авто
    private static int passengerCarPrice = 100; // RUB
    // Цена проезда грузового авто
    private static int cargoCarPrice = 250; // RUB
    // ополнительная цена для прицепа
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        // Создание переменной для считывания вводимых данных
        Scanner scanner = new Scanner(System.in);
        // Локальная переменная: Количество авто, которые надо сгененрировать
        int carsCount = scanner.nextInt();

        // Локальная переменная: переменная i - счетчик, количество пропущенных авто
        for (int i = 0; i < carsCount; i++) {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        // Локальная переменная: высота авто
        int carHeight = car.height;
        // Локальная переменная: изначальная стоимость проезда
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            // Локальная переменная: высота авто
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
        } else {
            price = cargoCarPrice;
            if (car.hasVehicle) {
                price = price + vehicleAdditionalPrice;
            }
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}