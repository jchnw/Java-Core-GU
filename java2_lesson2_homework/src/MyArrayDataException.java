public class MyArrayDataException extends Exception {
    public  MyArrayDataException(int i, int j) {
    System.out.println("Неверные данные в ячейке массива: [" + i +"][" + j +"]");
}
}
