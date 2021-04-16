// Интерактивный курс алгоритмов Java
// Урок 1, задания 1.3 и 1.4

package ru.geekbraines.homework1;

public class MyApp {

    private int number;
    private String myName;

    public MyApp(String name, int number) {
        this.myName = name;
        this.number = number;
    }

    public void getMyApp() {
        System.out.println("создан класс " + this.toString());
    }

    public int getNumber() {
        return number;
    }

    public String getMyName() {
        return myName;
    }

    public static void main(String[] args) {

        MyApp a1 = new MyApp("Класс 1",1);
        a1.getMyApp();
        System.out.println("Примитивный тип данных: целое число " + a1.getNumber());
        System.out.println("Ссылочный тип данных: строка с именем " + a1.getMyName());

        MyApp a2 = new MyApp("Класс 2",(int)(Math.random()*10));
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        long t1 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a2.getNumber()) {
                long t2 = System.nanoTime();
                System.out.printf("Алгоритм перебора выполнен за %d наносекунд, magicNumber равен %d\n", (t2-t1), array[i]);
            }
        }

    }
}
