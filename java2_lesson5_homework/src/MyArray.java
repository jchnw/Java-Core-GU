public class MyArray {
    private static final int size = 10000000;
    private static final int h = size/2;
    private static float[] myarray = new float[size];
    private static float[] marr1sth = new float[h];
    private static float[] marr2ndh = new float[h];

    public MyArray(){
            for (int i=0; i < myarray.length; i++) {
                myarray[i] = 1;
            }
    }


    public static float[] CalculateFormula (float arr[]) {
        for (int i=0; i < arr.length; i++) {
            arr[i] = (float)(arr[i]* Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        return arr;
    }

    public static float[] getMyarray() {
        return myarray;
    }

    public static float[] getMarr1sth() {
        return marr1sth;
    }

    public static float[] getMarr2ndh() {
        return marr2ndh;
    }

}
