public class Main {

    public static void main( String[] args) {
        System.out.println("1 - массив со строчкой; 2 - маленький массив, 3 - правильный массив");
        MyArray array = new MyArray(1);
        MyArray array2 = new MyArray(2);
        MyArray array3 = new MyArray(3);
        try {
            MyArray.ArraySummator(array.myarray);
        }
        catch (MyArraySizeException e) {

        }
        catch (MyArrayDataException e) {

        }
        try {
            MyArray.ArraySummator(array2.myarrayIn);
        }
        catch (MyArraySizeException e) {

        }
        catch (MyArrayDataException e) {

        }
        try {
            MyArray.ArraySummator(array3.myarray);
        }
        catch (MyArraySizeException e) {

        }
        catch (MyArrayDataException e) {

        }
    }

}
