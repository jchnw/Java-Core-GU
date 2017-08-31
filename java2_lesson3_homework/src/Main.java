import java.util.HashMap;

public class Main {

        public static void main(String[] args) {
            String[] dictionary = new String[20];
            for (int i=0; i < dictionary.length/2; i++){
                dictionary[i]="словарь" + Integer.toString (i);
            }
            for (int i=dictionary.length/2; i < dictionary.length; i++){
                dictionary[i]="словарик" + Integer.toString (i);
            }
            dictionary[1]="другое слово";
            dictionary[7]="другое";
            dictionary[12]="другое";
            dictionary[18]="тут";
            dictionary[19]="тут";

            HashMap<String, Integer> hmDictionary = new HashMap<>();
            for(int i = 0; i < dictionary.length; i++ ){
                Integer frequency = hmDictionary.get(dictionary[i]);
                hmDictionary.put(dictionary[i], frequency == null ? 1 : frequency + 1);
            }
            System.out.println(dictionary);
            System.out.println(hmDictionary.get("word"));
            System.out.println ("Количество повторений уникальных слов " + hmDictionary + " .Количество уникальных слов: " + hmDictionary.size());

            PhoneBook phoneBook = new PhoneBook ();
            phoneBook.add ("Павлов", 11234551);
            phoneBook.add ("Павлов", 13556632);
            phoneBook.add ("Михалков", 3456432);
            phoneBook.add ("Китов", 11567423);
            phoneBook.add ("Сидренко", 65653456);
            phoneBook.add ("Ильин", 75632773);
            phoneBook.add ("Михалков", 576245542);
            phoneBook.add ("Шоев", 26264646);
            phoneBook.add ("Китов", 566677755);
            phoneBook.add ("Иванов", 54676753);
            phoneBook.add ("Иванов", 44542331);
            phoneBook.add ("Иванов", 43556234);
            phoneBook.add ("Иванов", 12333356);
            phoneBook.add ("Иванов", 135664532);

            phoneBook.get ( "Павлов" );
            phoneBook.get ("Сидоров");
            phoneBook.get ("Ильин");
            phoneBook.get("Китов");
            phoneBook.get("Сергеев");
        }

}