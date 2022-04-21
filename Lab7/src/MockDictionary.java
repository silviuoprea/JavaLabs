import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MockDictionary extends Dictionary {
    @Override
    public boolean isWord(String str) {
        try {
            File myObj = new File("c:\\Users\\blkma\\Desktop\\Repo\\JavaLabs\\Lab7\\src\\MockDictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(str.equals(data))
                    return true;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
