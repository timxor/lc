package BinarySearchTree;

// copilot
// https://copilot.github.com/
// https://github.com/github/copilot-docs/blob/main/docs/jetbrains/gettingstarted.md#getting-started-with-github-copilot-in-jetbrains

public class Test {

    int calculateDaysBetweenDates (String date1, String date2){
        // date1 and date2 are in the format "YYYY-MM-DD"

        int[] date1Array = new int[3];
        int[] date2Array = new int[3];

        String[] date1Split = date1.split("-");
        String[] date2Split = date2.split("-");

        for (int i = 0; i < 3; i++){
            date1Array[i] = Integer.parseInt(date1Split[i]);
            date2Array[i] = Integer.parseInt(date2Split[i]);
        }

        int date1Days = date1Array[0] * 365 + date1Array[1] * 30 + date1Array[2];
        int date2Days = date2Array[0] * 365 + date2Array[1] * 30 + date2Array[2];

        return Math.abs(date1Days - date2Days);
    }

    public static void main(String[] args){
        Test test = new Test();
        System.out.println(test.calculateDaysBetweenDates("2019-01-01", "2019-01-02"));
    }
}
