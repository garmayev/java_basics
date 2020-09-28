package ru.garmayev.aid;

public class Aid {
    private final int CONTAINER_SIZE = 27;
    private final int CAR_SIZE = 12;

    public int car_count;
    public int container_count;

    public int box;

    public Aid(int box) {
        this.box = box;
    }

    public String summary() {
        return "\nНеобходимо:" +
                "\n\tГрузовиков - " + car_count +
                "\n\tКонтейнеров - " + container_count + "\n";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < box; i++ ) {
            if ( i % (CAR_SIZE * CONTAINER_SIZE) == 0 ) {
                car_count++;
                result.append("Грузовик ").append(car_count).append("\n");
            }
            if ( i % CONTAINER_SIZE == 0 ) {
                container_count++;
                result.append("\tКонтейнер ").append(container_count).append("\n");
            }
            result.append("\t\tЯщик ").append(i + 1).append("\n");
        }
        return result.toString() + this.summary();
    }
}
