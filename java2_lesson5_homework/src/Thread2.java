public class Thread2 implements Runnable {
    private long timeTh2;

    public void run() {
        timeTh2 = System.currentTimeMillis();
        System.arraycopy (MyArray.getMyarray(), MyArray.getMarr2ndh().length, MyArray.getMarr2ndh(), 0, MyArray.getMarr2ndh().length);
        MyArray.CalculateFormula(MyArray.getMarr2ndh());
        System.arraycopy (MyArray.getMarr2ndh(),0, MyArray.getMyarray(), MyArray.getMarr2ndh().length, MyArray.getMarr2ndh().length);
        timeTh2 = (System.currentTimeMillis() - timeTh2);
    }
    public long getTimeTh2() {
        return timeTh2;
    }
}
