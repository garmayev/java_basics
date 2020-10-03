package garmayev;

public class Main {
    public static final int size = 11;
    public static String[][] figure;

    /**
     * Заполнение двумерного массива "пустыми" (со знаком пробела) строками
     * @return
     */
    public static String[][] generate()
    {
        String [][] array = new String[size][size];
        for ( int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                array[i][j] = " ";
            }
        }
        return array;
    }

    /**
     * Заполнение главной диагонали матрицы Строкой "Х"
     */
    public static void diagonal1()
    {
        for (int i = 0; i < figure.length; i++) {
            figure[i][i] = "X";
        }
    }

    /**
     * Заполнение побочной диагонали матрицы Строкой "Х"
     */
    public static void diagonal2() {
        for (int i = 0; i < figure.length; i++) {
            figure[i][(figure[i].length - 1)-i] = "X";
        }
    }

    /**
     * Вывод двумерного массива в консоль
     */
    public static void print() {
        for (int i = 0; i < figure.length; i++) {
            for (int j = 0; j < figure[i].length; j++) {
                System.out.print(figure[i][j]);
            }
            // "Разделитель" массивов (т.е. сброс "каретки" на новую строку)
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Генерация "пустой" матрицы
        figure = generate();
        // Заполнение главной диагонали
        diagonal1();
        // Заполнение побочной диагонали
        diagonal2();
        // Печать двумерного массива
        print();
    }
}
