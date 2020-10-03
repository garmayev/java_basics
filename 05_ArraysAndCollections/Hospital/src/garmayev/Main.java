package garmayev;

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
    public static final float MIN_TEMPERATURE = (float) 36.6;
    public static final float MAX_TEMPERATURE = (float) 36.9;

    /**
     * Вывод температур всех пациентов в строку
     *
     * @param array
     * @return
     */
    public static String print(float[] array)
    {
        String result = "";
        for (float item: array)
        {
            result += item + " ";
        }
        return result;
    }

    /**
     * Генератор температур для пациентов
     *
     * @return
     */
    public static float[] fill ()
    {
        float[] array = new float[PATIENT_COUNT];
        for (int i = 0; i < PATIENT_COUNT; i++) {
            // Генерация случайного числа  (32 < x < 40) и приведение его к виду xx.x
            array[i] = (float)((int)(320 + (float) Math.random() * 60)) / 10;
        }
        return array;
    }

    /**
     * Расчет среднего арифметического среди температур пациентов
     *
     * @param array
     * @return
     */
    public static float middle(float[] array)
    {
        float sum = (float)0;
        for (float item: array) sum += item;
        return sum / PATIENT_COUNT;
    }

    /**
     * Подсчет количества здоровых пациентов
     *
     * @param array
     * @return
     */
    public static int good(float[] array)
    {
        int count = 0;
        for (float item : array) {
            if (item > MIN_TEMPERATURE && item < MAX_TEMPERATURE) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        float[] temperatures = fill();
        System.out.println("Температуры пациентов: " + print(temperatures));
        System.out.println("Средняя температура по больнице: " + middle(temperatures));
        System.out.println("Количество здоровых пациентов: " + good(temperatures));
    }
}
