package multithread.m0.e2;

import java.util.Arrays;

/**
 * Home work of Module 0 Lesson 2
 *
 * В Этот раз мы рассмотрим второй способ создания и использование потоков, интерфейс Runnable.
 * В этой задаче Вам нужно будет создать реализацию интерфейса Runnable который ищет максимальный элемент в массиве int.
 *
 * Класс который Вам нужно реализовать называется MaxRunnable, его API состоит из следующих методов:
 *
 * MaxRunnable(final int[] target) - конструктор который принимает на вход массив в котором будет произведен поиск максимального элемента;
 * public int getResult() - метод который используется для того что бы получить результат после того как поток закончил свое выполнение.
 */
public class MaxRunnable implements Runnable {
    private int[] target;
    private int max;

    public MaxRunnable(int[] target) {
        this.target = target;
    }

    public int getResult(){
        return max;
    }

    @Override
    public void run() {
        max = Arrays.stream(target).max().getAsInt();
    }
}
