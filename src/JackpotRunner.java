import java.util.*;

public class JackpotRunner {
    private static List<Integer> numbersAppearedInSection1 = new ArrayList<Integer>();
    private static List<Integer> numbersAppearedInSection2 = new ArrayList<Integer>();

    // TODO: remove repeated numbers in all run
    public static void main(String[] args) {
        int maxRunTimes = 8;
        for (int i = 0; i < maxRunTimes; i++)
            run();
    }

    private static void run() {
        List<Integer> numbersInSection1 = new ArrayList<Integer>();
        List<Integer> numbersInSection2 = new ArrayList<Integer>();

        chooseNumbers(1, numbersInSection1);
        chooseNumbers(2, numbersInSection2);
        outputChosenNumbers(numbersInSection1, numbersInSection2);
    }

    private static void init(List<Integer> numbersInSection1, List<Integer> numbersInSection2) {
        numbersInSection1.clear();
        numbersInSection2.clear();
    }

    private static void chooseNumbers(int section, List<Integer> chosenNumbers) {
        int chosenNumber;
        int maxLotteryNumber = (section == 1) ? 38 : 8;
        int maxQuantityInSection = (section == 1) ? 6 : 1;
        List<Integer> appearedNumbers = (section == 1) ? numbersAppearedInSection1 : numbersAppearedInSection2;
        for (int i = 0; i < maxQuantityInSection; i++) {
            do {
                chosenNumber = (int) (Math.random() * maxLotteryNumber) + 1;
            } while(appearedNumbers.size() <= maxLotteryNumber && appearedNumbers.contains(chosenNumber));
            chosenNumbers.add(chosenNumber);
        }
    }

    private static void outputChosenNumbers(List<Integer> numbersInSection1, List<Integer> numbersInSection2) {
        Collections.sort(numbersInSection1);
        for (Integer appearedNumber : numbersInSection1) {
            System.out.print(appearedNumber);
            System.out.print(' ');
        }
        System.out.print(numbersInSection2);
        System.out.println();
    }
}
