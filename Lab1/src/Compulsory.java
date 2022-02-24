public class Compulsory {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int result, n;
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        n = computeN();
        result = digitSum(n);
        while (result / 10 != 0) {
            result = digitSum(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    public static int computeN()
    {
        int number;
        number = (int) (Math.random() * 1_000_000);
        number *= 3;
        number += 0b10101;
        number += 0xFF;
        number *= 6;
        return number;
    }

    public static int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
