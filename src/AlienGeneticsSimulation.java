import java.util.ArrayList;
import java.util.Scanner;

public class AlienGeneticsSimulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the population of compAlien species: ");
        int sizeOfCompAlien = scn.nextInt();
        System.out.println("...creating compAlien species...");
        char[] geneticCode;
        ArrayList<char[]> storeGeneticCode = new ArrayList<>();

        System.out.println("——————————————————————————");
        for(int i = 1; i <= sizeOfCompAlien; i++){
            geneticCode = new char[128];
            generateGeneticCode(geneticCode);
            storeGeneticCode.add(geneticCode);
            System.out.println("ID: " + i + ", " + findAlienGender(geneticCode) + ", Health: "
                    + findAlienHealth(geneticCode));
        }
        System.out.println("——————————————————————————");

        while(true){
            menu();
            int userOption = scn.nextInt();
            switch(userOption){
                case 0:
                    System.out.print("...closing the simulation...");
                    System.exit(0);
                case 1:
                    System.out.println("——————————————————————————");
                    System.out.print("Enter ID1: ");
                    int firstID = scn.nextInt();
                    System.out.print("Enter ID2: ");
                    int secondID = scn.nextInt();
                    System.out.println("Chance of reproducing compAlien" + firstID + " ("
                            + findAlienGender(storeGeneticCode.get(firstID - 1)) + "), and compAlien" + secondID
                            + " (" + findAlienGender(storeGeneticCode.get(secondID - 1)) + ") is: "
                            + getReproductionRate(storeGeneticCode.get(firstID - 1),
                            storeGeneticCode.get(secondID - 1)) + "%\n");
                    System.out.println("——————————————————————————");
                    break;
                case 2:
                    System.out.println("——————————————————————————");
                    System.out.println("Simulating Random compAlien Reproduction");
                    System.out.print("Enter number of compAlien pairs to reproduce: ");
                    int numberOfPairs = scn.nextInt();
                    int alien1, alien2;
                    for(int i = 1; i <= numberOfPairs; i++){
                        alien1 = 1 + (int) (Math.random() * sizeOfCompAlien);
                        alien2 = 1 + (int) (Math.random() * sizeOfCompAlien);
                        System.out.println("compAlien" + alien1 + " (" +
                                findAlienGender(storeGeneticCode.get(alien1 - 1)) + ") and compAlien" + alien2 + " ("
                                + findAlienGender(storeGeneticCode.get(alien2 - 1)) + ") mate: "
                                + getReproductionRate(storeGeneticCode.get(alien1 - 1),
                                storeGeneticCode.get(alien2 - 1)));
                    }
                    System.out.println("——————————————————————————");
                    break;
                case 3:
                    System.out.println("——————————————————————————");
                    System.out.printf("Male population: " + getMaleCount(storeGeneticCode) + " (%.2f%s)\n",
                            ((double)getMaleCount(storeGeneticCode)/sizeOfCompAlien) * 100, '%');
                    System.out.printf("Female population: " + getFemaleCount(storeGeneticCode) + " (%.2f%s)\n",
                            ((double)getFemaleCount(storeGeneticCode)/sizeOfCompAlien) * 100, '%');
                    System.out.print("Enter a health threshold: ");
                    int healthThreshold = scn.nextInt();
                    System.out.printf("%.2f%s of population has " + healthThreshold + " or greater health.\n",
                            (thresholdCalculator(storeGeneticCode, healthThreshold)/sizeOfCompAlien) * 100, '%');
                    System.out.printf("%.2f%s of female compAlien population (" + endsWithX(storeGeneticCode) +
                                    ") has 'X' and %.2f%s of female compAlien population ("
                                    + endsWithZ(storeGeneticCode) + ") has 'Z' as their last genetic code.\n",
                            ((double)endsWithX(storeGeneticCode)/sizeOfCompAlien) * 100, '%',
                            ((double)endsWithZ(storeGeneticCode)/sizeOfCompAlien) * 100, '%');
                    System.out.println("Viewing illness stats: ");
                    hasIllness(storeGeneticCode);
                    System.out.println("——————————————————————————");
                    break;
                case 4:
                    System.out.println("——————————————————————————");
                    String[] wrestlingPromotions = {"WWE", "AEW", "IMPACT", "GCW", "OZ-ACADEMY", "NWA", "PWG", "DDT",
                            "スターダム/STARDOM", "プロレスリングノア/NOAH", "新日本プロレス/NJPW", "全日本プロレス/AJPW",
                            "GLEAT", "東京女子プロレス/TJPW", "アイスリボン/Ice Ribbon", "天龍プロジェクト/Tenryu Project",
                            "大日本プロレス/BJW", "プロレスリングWAVE/WAVE", "SEAdLINNNG", "マーベラス/Marvelous",
                            "JTO", "Gatoh Move", "Michinoku Pro", "FMW-E", "ガンバレプロレス/GanPro"};
                    for (int i = 1; i <= sizeOfCompAlien; i++){
                        int randomPromotionIndex = (int)(Math.random() * wrestlingPromotions.length);
                        System.out.println("compAlien" + i + "'s favourite wrestling promotion is: "
                                + wrestlingPromotions[randomPromotionIndex]);
                    }
                    System.out.println("——————————————————————————");
                    break;
                case 5:
                    System.out.println("——————————————————————————");
                    String[] killMethod = {"from a random handgun bullet", "after taking a dangerous neck bump",
                            "from an explosion", "from eating too much", "from drinking 7L of water",
                            "after falling from a high building"};
                    for (int i = 1; i <= sizeOfCompAlien; i++){
                        int index = (int)(Math.random() * killMethod.length);
                        System.out.println("compAlien" + i + " died " + killMethod[index] + ".");
                    }
                    System.out.print("\nAll compAliens have been wiped out from existence and the simulation planet" +
                            " has now been ruined... What a cold blooded, sick minded director you are!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    System.out.println("——————————————————————————");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.print("Choose an option:\n" + "1: Mate two compAliens\n" +
                "2: Randomly mate a set of compAliens\n" + "3: Show statistics\n" +
                "4: compAliens' preference of wrestling promotions\n" + "5: Wipe out all of the compAliens\n" +
                "[0: Close the simulation]\n" + "\nEnter an option: ");
    }

    public static void generateGeneticCode(char[] arr){
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (char)((int)(88 + Math.random() * 3));
        }
    }

    public static int findAlienHealth(char[] arr){
        int health = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == 'Y' && arr[i + 1] == 'X' && arr[i + 2] == 'Z')
                health++;
        }
        return health;
    }

    public static String findAlienGender(char[] arr){
        String str = "Female";
        int lastIndex = arr.length - 1;
        if(arr[lastIndex] == 'Y')
            str = "Male";
        return str;
    }

    public static int getReproductionRate(char[] arr1, char[] arr2){
        if(findAlienGender(arr1).equals(findAlienGender(arr2)))
            return 0;
        return (int)(((findAlienHealth(arr1) + findAlienHealth(arr2)) / 84.0) * 100.0);
    }

    public static int getMaleCount(ArrayList<char[]> list){
        int count = 0;
        for(char[] arr : list){
            if(findAlienGender(arr).equals("Male"))
                count++;
        }
        return count;
    }

    public static int getFemaleCount(ArrayList<char[]> list){
        int count = 0;
        for(char[] arr : list){
            if(findAlienGender(arr).equals("Female"))
                count++;
        }
        return count;
    }

    public static double thresholdCalculator(ArrayList<char[]> list, int n){
        double count = 0;
        for(char[] arr : list){
            if(findAlienHealth(arr) >= n)
                count++;
        }
        return count;
    }

    public static int endsWithX(ArrayList<char[]> list){
        int count = 0;
        for(char[] arr : list){
            if (arr[arr.length - 1] == 'X')
                count++;
        }
        return count;
    }

    public static int endsWithZ(ArrayList<char[]> list){
        int count = 0;
        for(char[] arr : list){
            if (arr[arr.length - 1] == 'Z')
                count++;
        }
        return count;
    }

    public static void hasIllness(ArrayList<char[]> list){
        int id = 1;
        for(char[] arr : list){
            int count = 0;
            for(int i = 0; i < arr.length - 2; i++){
                if(arr[i] == 'Z' && arr[i + 1] == 'Y' && arr[i + 2] == 'X')
                    count++;
            }
            if(count >= 5)
                System.out.println("compAlien" + id + " has illness...");
            else
                System.out.println("compAlien" + id + " doesn't have any illness.");
        id++;
        }
    }
}