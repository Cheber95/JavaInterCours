package ru.geekbraines.homework2;

import java.util.Arrays;

public class MyApp {
    private int[] numbers;
    private String myName;
    private String[] words = new String[0];

    public MyApp(String myName) {
        this.myName = myName;
    }

    public void createIntArray(int size, int range) {
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random()*range);
        }
    }

    public void addToStrArray(String word) {
        //words = words.
    }

    public void intArraySort() {
        Arrays.sort(numbers);
    }

    public int lineFindElement(int value) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int binaryFindElement(int value) {
        int left = 0;
        int right = numbers.length - 1;
        int middle = (right + left)/2;
        int iterations = (int) Math.round((Math.log(numbers.length)/Math.log(2)));
        for (int i = 0; i < iterations; i++) {
            int currentValue = numbers[middle];
            if (value > numbers[middle]) {
                left = middle;
                middle = (left + right)/2;
            }
            else if (value < numbers[middle]) {
                right = middle;
                middle = (left + right)/2;
            }
            else if (value == numbers[middle]) {
                return middle;
            }
        }
        return -1;
    }

    public void intBubbleSort() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j] < numbers[j-1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = tmp;
                }
            }
        }
    }

    public void intChangeSort() {
        for (int i = 0; i < numbers.length; i++) {
            int indexOfMin = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[indexOfMin] > numbers[j]) {
                    indexOfMin = j;
                }
            }
            if (numbers[indexOfMin] != numbers[i]) {
                int tmp = numbers[indexOfMin];
                numbers[indexOfMin] = numbers[i];
                numbers[i] = tmp;
            }
        }
    }

    public void intPasteSort() {
        for (int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            int currentIndex = i;
            while (currentIndex > 0 && numbers[currentIndex - 1] > tmp) {
                numbers[currentIndex] = numbers[currentIndex - 1];
                currentIndex--;
            }
            numbers[currentIndex] = tmp;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public static void main(String[] args) {
        long t1 = 0L;
        long t2 = 0L;
        int arraySize = 10;
        int arrayRange = 100;
        MyApp[] myApps = new MyApp[5];
        myApps[0] = new MyApp("Экземпляр №1 приложения");
        myApps[1] = new MyApp("Экземпляр №2 приложения");
        myApps[2] = new MyApp("Экземпляр №3 приложения");
        myApps[3] = new MyApp("Экземпляр №4 приложения");
        myApps[4] = new MyApp("Экземпляр №5 приложения");

        myApps[0].createIntArray(arraySize,arrayRange);
        t1 = System.nanoTime();
        int[] arrayCopy = Arrays.copyOf(myApps[0].getNumbers(),myApps[0].getNumbers().length);
        t2 = System.nanoTime();
        System.out.printf("2.1.1 Копирование массива Arrays.copyOf() занимает %d наносекунд\n", (t2-t1));
        t1 = System.nanoTime();
        System.out.println(Arrays.toString(arrayCopy));
        t2 = System.nanoTime();
        System.out.printf("2.1.2 Вывод массива Arrays.toString() занимает %d наносекунд\n", (t2-t1));
        t1 = System.nanoTime();
        System.out.println(Arrays.equals(arrayCopy, myApps[0].getNumbers()));
        t2 = System.nanoTime();
        System.out.printf("2.1.3 Сравнение массивов Arrays.equals() занимает %d наносекунд\n", (t2-t1));

        arraySize = 40000;
        int value = 49;
        myApps[0].createIntArray(arraySize,arrayRange);
        myApps[0].intArraySort();
        System.out.println("2.2 Длина массива составялет " + arraySize);
        System.out.println("2.2 Искомое значение составялет " + value);
        int findIndex = -1;
        while (findIndex == -1) {
            t1 = System.nanoTime();
            findIndex = myApps[0].lineFindElement(value);
            t2 = System.nanoTime();
            if (findIndex == -1) {
                myApps[0].createIntArray(arraySize,arrayRange);
            }
        }
        System.out.printf("2.2.1 Линенйный поиск занял %d наносекунд\n", (t2-t1));

        findIndex = -1;
        while (findIndex == -1) {
            t1 = System.nanoTime();
            findIndex = myApps[0].binaryFindElement(value);
            t2 = System.nanoTime();
        }
        System.out.printf("2.2.2 Двоичный поиск занял %d наносекунд\n", (t2-t1));

        arraySize = 400;
        myApps[1].createIntArray(arraySize,arrayRange);
        t1 = System.nanoTime();
        myApps[1].intArraySort();
        t2 = System.nanoTime();
        System.out.printf("2.3 Сортировка методом sort() массива из %d элементов заняла %d наносекунд\n", arraySize, (t2-t1));
        //System.out.println(Arrays.toString(myApps[1].getNumbers()));

        myApps[2].createIntArray(arraySize,arrayRange);
        t1 = System.nanoTime();
        myApps[2].intBubbleSort();
        t2 = System.nanoTime();
        System.out.printf("2.4 Сортировка методом пузырька массива из %d элементов заняла %d наносекунд\n", arraySize, (t2-t1));
        //System.out.println(Arrays.toString(myApps[2].getNumbers()));

        myApps[3].createIntArray(arraySize,arrayRange);
        t1 = System.nanoTime();
        myApps[3].intChangeSort();
        t2 = System.nanoTime();
        System.out.printf("2.5 Сортировка методом выбора массива из %d элементов заняла %d наносекунд\n", arraySize, (t2-t1));
        //System.out.println(Arrays.toString(myApps[3].getNumbers()));

        myApps[4].createIntArray(arraySize,arrayRange);
        t1 = System.nanoTime();
        myApps[4].intPasteSort();
        t2 = System.nanoTime();
        System.out.printf("2.6 Сортировка методом вставки массива из %d элементов заняла %d наносекунд\n", arraySize, (t2-t1));
        //System.out.println(Arrays.toString(myApps[4].getNumbers()));
    }
}
