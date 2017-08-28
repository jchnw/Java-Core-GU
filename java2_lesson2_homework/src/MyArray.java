import java.util.Random;


public class MyArray {

    private Random rand = new Random();
    String[][] myarray = new String[4][4];
    String[][] myarrayIn = new String[3][3];

    public MyArray(int answer){

        if (answer == 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    myarray[i][j] = String.valueOf(rand.nextInt(20));
                }
            }

                myarray[1][1] = "hello";

        }
        if (answer == 2) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {

                    myarrayIn[i][j] = String.valueOf(rand.nextInt(20));
                }
            }

        }
        if (answer == 3) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    myarray[i][j] = String.valueOf(rand.nextInt(20));
                }
            }



        }


    }

    public static void ArraySummator (String[][] a) throws MyArraySizeException, MyArrayDataException  {
        Integer val;
        int x = a.length;
           if (x !=4) throw new MyArraySizeException();

        int summ = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                val = tryParseInt(a[i][j]);
                if (val == null) throw new MyArrayDataException(i, j);
                if (val != null) summ += val;

            }
        }
        System.out.println(summ);
    }

    private static Integer tryParseInt(String src) {
        Integer result = null;
        try {
            result = Integer.parseInt(src);
        } catch(NumberFormatException e)  {
        }
        return result;
    }
}
