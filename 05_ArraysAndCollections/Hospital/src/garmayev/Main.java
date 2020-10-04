package garmayev;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    /**
     * Список констант:
     *
     *   PATIENT_COUNT - количество пациентов
     *   MIN_TEMPERATURE - минимальная температура, при которой пациент считается здоровым
     *   MAX_TEMPERATURE - максимальная температура, при которой пациент считается здоровым
     */
    public static final int PATIENT_COUNT = 30;
    public static final float MIN_TEMPERATURE = 36.6f;
    public static final float MAX_TEMPERATURE = 36.9f;

    public static final float MIN_AVAILABLE_TEMPERATURE = 32f;
    public static final float MAX_AVAILABLE_TEMPERATURE = 40f;
    public static final String PATTERN = "#0.00°C";

    public static DecimalFormat formatter;

    /**
     * Вывод температур всех пациентов в строку
     *
     * @param array
     * @return
     */
    public static String arrayToString(double[] array)
    {
        StringBuilder result = new StringBuilder();
        for (double item: array)
        {
            result.append(formatter.format(item)).append(" ");
        }
        return result.toString();
    }

    /**
     * Генератор температур для пациентов
     *
     * @return
     */
    public static double[] generateTemperatures ()
    {
        double[] array = new double[PATIENT_COUNT];
        for (int i = 0; i < PATIENT_COUNT; i++) {
            // Генерация случайного числа  (32 < x < 40) и приведение его к виду xx.x
            array[i] = (float)MIN_AVAILABLE_TEMPERATURE + Math.random() * (MAX_AVAILABLE_TEMPERATURE - MIN_AVAILABLE_TEMPERATURE);
        }
        return array;
    }

    /**
     * Расчет среднего арифметического среди температур пациентов
     *
     * @param array
     * @return
     */
    public static float getAverageFromHospital(double[] array)
    {
        float sum = (float)0;
        for (double item: array) sum += item;
        return sum / PATIENT_COUNT;
    }

    /**
     * Подсчет количества здоровых пациентов
     *
     * @param array
     * @return
     */
    public static int getCountHealthyPatient(double[] array)
    {
        int count = 0;
        for (double item : array) {
            if (item > MIN_TEMPERATURE && item < MAX_TEMPERATURE) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        formatter = new DecimalFormat(PATTERN);
        double[] temperatures = generateTemperatures();
        System.out.println("Температуры пациентов: " + arrayToString(temperatures));
        System.out.println("Средняя температура по больнице: " + formatter.format(getAverageFromHospital(temperatures)));
        System.out.println("Количество здоровых пациентов: " + getCountHealthyPatient(temperatures));
    }
}
