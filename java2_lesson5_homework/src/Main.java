public class Main {
        public static void main(String[] args) {
            MyArray myArray = new MyArray();
            long time = System.currentTimeMillis();
            myArray.CalculateFormula(MyArray.getMyarray());
            System.out.println("Первый метод выполнялся: " + (System.currentTimeMillis() - time));
            Thread1 thr1 = new Thread1();
            Thread2 thr2 = new Thread2();
            Thread thread1 = new Thread(thr1);
            Thread thread2 = new Thread(thr2);
            time = System.currentTimeMillis();
            thread1.start ();
            thread2.start ();

            try {
                thread1.join ();
                thread2.join ();
            }
            catch (InterruptedException e) {
                e.printStackTrace ();
            }
            System.out.println("Второй метод выполнялся: " + (System.currentTimeMillis() - time));

        }

}

