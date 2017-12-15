import java.util.concurrent.*;


public class MainClass {
        public static final int CARS_COUNT = 4;
        public static void main(String[] args) {
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            final int THREADS_COUNT = 4; // задаем кол-во потоков
            final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);
            final CountDownLatch cdl1 = new CountDownLatch(CARS_COUNT);// задаем значение счетчика
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            for (int i = 0; i < THREADS_COUNT; i++) {
                final int w = i;
                new Thread(() -> {
                    try {
                            cars[w] = new Car(race, 20 + (int) (Math.random() * 10));
                            cars[w].prepareToStart();
                            cdl.countDown();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
// не работает, и я не знаю, почему
            for (int i = 0; i < CARS_COUNT; i++) {
                final int w = i;
                    new Thread(() -> {
                        try {
                            cars[w].racingMode();
                            cdl1.countDown();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }).start();
                }
            try {
                cdl.await();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
}

