public class Thread1 implements Runnable {
    private long timeTh1;

    public void run() {
        timeTh1 = System.currentTimeMillis();
        System.arraycopy (MyArray.getMyarray(), 0, MyArray.getMarr1sth(), 0, MyArray.getMarr1sth().length);
        MyArray.CalculateFormula(MyArray.getMarr1sth());
        System.arraycopy (MyArray.getMarr1sth(),0, MyArray.getMyarray(), 0, MyArray.getMarr1sth().length);
        timeTh1 = (System.currentTimeMillis() - timeTh1);
    }
    public long getTimeTh1() {
        return timeTh1;
    }
}