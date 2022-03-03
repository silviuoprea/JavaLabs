import java.util.ArrayList;

import static java.lang.System.nanoTime;
public class Homework {
    public static void Ex1(String[] args)
    {
        int arglength = args.length;
        long init = nanoTime();
        ArrayList<String> wordArray = new ArrayList<String>();
        Neighbours neighbours;
        int n=0, p=0;
        if (!isStringInt(args[0]) || !isStringInt(args[1]))
        {
            System.out.println("Primele 2 argumente nu sunt numere!");
            System.exit(-1);
        }
        else
        {
            System.out.println("Primele 2 argumente sunt numere!");
            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);
        }

        for (int i = 2; i < arglength; i++)
        {
            if (!Character.isLetter(args[i].charAt(0)))
            {
                System.out.println("Argumentul " + args[i] + " nu este litera mare!");
                System.exit(-1);
            }
            else
            {
                System.out.println("Argumentul " + args[i] + " este litera mare!");
            }
        }
        for (int i = 0; i < n; i++)
        {
            wordArray.add(generateWord(arglength, p, args));
        }
        System.out.println(wordArray);
        long end = nanoTime();
        if (n > 30_000)
            System.out.println(end - init);
    }
    public static String generateWord(int arglength, int p, String[] args)
    {
        StringBuilder word = new StringBuilder();
        while (word.length() != p)
        {
            word.append(args[getRandomNumber(2, arglength)]);
        }
        return String.valueOf(word);
    }

    public static Neighbours adjacencyMatrix(int argument)
    {
        Neighbours TODO = new Neighbours<>();
        return TODO;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        Ex1(args);
    }
    /* To run in command prompt compile with javac then run as specified in Hw text */
}
