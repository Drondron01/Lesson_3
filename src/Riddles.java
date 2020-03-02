/*
1. Написать программу, которая загадывает случайное число от 0 до 9,
и пользователю дается 3 попытки угадать это число. При каждой попытке
компьютер должен сообщить больше ли указанное пользователем число чем
загаданное, или меньше. После победы или проигрыша выводится запрос
– «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
играем до тех пор, пока игрок не отгадает слово
используем только маленькие буквы
*/

import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.*;

public class Riddles {
    public static void main(String[] args) {
        int q = (int) (random()*10);
        Scanner in = new Scanner(System.in);
        System.out.println("Загаданно число  от 0 до 9, у Вас 3 попытки, введите ответ: ");
        int answer = in.nextInt();
        int i = 0;
        for (i = 0; i < 2; i++) {
            if  (answer == q){
                System.out.println("Поздравяем вы выиграли");
                break;
            } else {
                int n = 2-i;
                System.out.println("Ответ неверный, осталось " + n + " попыток, введите число" );
                answer = in.nextInt();
            }
        }
        if (i == 2){
            System.out.println("игра закончена, вы проиграли, правильный ответ  " + q );
        }

        System.out.println(" Следующая игра " );
        String [] words = new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};;
        int nWd = (int) (random()*words.length);
        //System.out.println("Отгадайте слово   " + words[nWd] + "  " + nWd + "  " + words.length);
        String riddleword = words[nWd];
        System.out.println("Отгадайте слово (загаданное слово - " + riddleword + ") номер слова в массиве -" + nWd);
        String awd = in.nextLine();
        awd = in.nextLine();
        boolean aw = true;
        int lengthW = words[nWd].length();	//Длина слова
        int nl = 1;							//Количество букв подсказок
        while (aw) {						//Цикл перебора подсказок
            if (awd.equals(words[nWd])){
                System.out.println("игра закончена, вы выиграли" );
                break;
            }
            else if (nl == lengthW) {
                System.out.println("игра закончена, вы проиграли, слово " + words[nWd] );
                aw = false;
            }
            else {
                System.out.println("Ответ неверный" );
                System.out.println("Подсказка "  + words[nWd].substring( 0,nl )+ "XXXXXXXXXXX");
                awd = in.nextLine();
                nl++;
            }
        }
    }


}
