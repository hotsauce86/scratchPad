import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class thePad {


    public static void main(String[] args){

        String countSpaceExample = "asdhfwer t asdljfno as doahedjkhnd ";

        System.out.println(countSpace(countSpaceExample));
    ////////////////////////////////////////
        String s1 = "asbcsdsdf";
        String s2 = "sdfbeljkdcfj";

        MatchTwoString(s1,s2);
        stringMap(s1,s2);
//////////////////////////////////////////////////

        Scanner in = new Scanner(System.in);

        int[][] grid = new int[10][10];

         System.out.println("Select your option:");
         System.out.println("'1': \tcreate new island, \t'2': \tgrow island \t '3': \tseed new isalnd \t'0': \t end program");
        int choice = in.nextInt();
         while(choice !=0){
             switch (choice){
                 case(1):
                     islandMaker(grid);
                     printOcean(grid);
                     break;

                 case(2):
                     growIsland(grid);
                     printOcean(grid);
                     break;
                 case(3):
                     seedIsland(grid);
                     printOcean(grid);
                     break;


             }
             System.out.println("");
             System.out.println("Select your option:");
             System.out.println("'1': \tcreate new island, \t'2': \tgrow island \t '0': \t end program");
             choice = in.nextInt();
         }





       islandMaker(grid);

        System.out.println("");System.out.println("growth uno");
        growIsland(grid);
        printOcean(grid);

        System.out.println("");System.out.println("growth dos");
        growIsland(grid);
        printOcean(grid);

        System.out.println("");System.out.println("growth tres");
        growIsland(grid);
        printOcean(grid);

    }








    /*
    RANDOM METHOD GENERATOR
     */


    public static String countSpace(String x){

        String y;
        int spaceCounter =0;
        String[] z = x.split("");

        for(String temp : z){
            if(temp.equals(" ")){
                spaceCounter++;
            }
        }

        y="spaces found in string: " + spaceCounter;

        return y;
    }

    public static void MatchTwoString(String s1, String s2){

        String[] s1collect = s1.split("");
        String[] s2collect = s2.split("");

        boolean match =false;
        for(String a : s1collect){
            for(String b: s2collect){
                if(a.equals(b)){
                    match=true;
                    System.out.println("match is true");
                    break;
                }
            }
            if(match==true){
                break;
            }

        }
        if(match==false){
            System.out.println("match is false");
        }
    }

    public static void stringMap (String s1, String s2){
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.chars());
        System.out.println(s1.codePoints());
        System.out.println(s1.concat(s2));
        System.out.println(s1.replaceFirst(" ", s2));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.matches("a"));
        System.out.println(s1.replace("a", "A"));
        System.out.println(s1.split("a"));
        System.out.println(s1.replace("a", "T"));
    }

    public static void intMap (int x){
        System.out.println(x);

        int i1 = 27;
        List<Integer> integerList = new LinkedList<>();
        for(int i=0; i <10; i++){
            //make random an int and output froma a range of 40
            integerList.add((int)(Math.random()*4));
            System.out.println(integerList.get(i));
        }

    }











    /*//////////////////////////////////////////////////////////////////////////////////
    ISLAND GENERATOR METHODS
     *//////////////////////////////////////////////////////////////////////////////////

    public static void islandMaker(int[][] someGrid){
        //int[][] grid = new int[10][10];
        int[][] grid = someGrid;

        //y axis
        for(int i =0; i<grid.length; i++){
            //x axis
            for(int j=0; j< grid.length; j++){
                grid[j][i] = 0;
                System.out.print(" "+grid[j][i]);
            }
            System.out.println("");
        }

        System.out.println("");System.out.println("seed");
        seedIsland(grid);
     //   printOcean(grid);

        /*
        System.out.println("");System.out.println("growth uno");
        growIsland(grid);
        printOcean(grid);

        System.out.println("");System.out.println("growth dos");
        growIsland(grid);
        printOcean(grid);

        System.out.println("");System.out.println("growth tres");
        growIsland(grid);
        printOcean(grid);
        */


    }

    public static int[][] seedIsland(int[][] someOcean){

        for(int i =0; i<someOcean.length; i++){
            //x axis
            for(int j=0; j< someOcean.length; j++){
                int x = (int)(Math.random()*50);
                if ((j > 0 && j < someOcean.length - 1) && (i > 0 && i < someOcean.length - 1)) {
                    if(x==4){
                        someOcean[j][i] = 1;
                    }
                }


            }
        }
        return someOcean;
    }

    public static void printOcean(int[][] someOcean){
        for(int i =0; i<someOcean.length; i++){
            //x axis
            /*
            for(int j=0; j< someOcean.length; j++){
                System.out.print(" "+someOcean[j][i]);
            }
            System.out.println("");
            */

            for(int j=0; j< someOcean.length; j++){
                System.out.print("  "+String.format("%02d",someOcean[j][i]));
            }
            System.out.println("");System.out.println("");
        }
    }

    public static int[][] growIsland(int[][] someOcean){
        //first we find the highest points on the map
        int highestPoint =0;
        for(int i =0; i<someOcean.length; i++){
            for(int j=0; j< someOcean.length; j++){

                if(someOcean[j][i]>highestPoint){
                    highestPoint=someOcean[j][i];
                }
            }
        }

        //next we raise the highest points
        for(int i =0; i<someOcean.length; i++){
            for(int j=0; j< someOcean.length; j++){
                if(someOcean[j][i]==highestPoint){
                    someOcean[j][i]++;
                }
            }
        }
        highestPoint++;

        //and now we raise the points around them

        //well use secondWave as a way to add some randomness

        //for each layer in the z axis
        for(int k=0; k<highestPoint;k++) {
            //the y axis
            for (int i = 0; i < someOcean.length; i++) {
                //the x axis
                for (int j = 0; j < someOcean.length; j++) {

                    //finding the hight at this point
                    if (someOcean[j][i] == highestPoint-k) {
                        //we check the immediate cardinal directions
                        if ((j > 0 && j < someOcean.length - 1) && (i > 0 && i < someOcean.length - 1)) {
                            int secondWave = (int)(Math.random()*(2+k));
                            if(secondWave==1) {
                                //North
                                if (someOcean[j][i - 1] < someOcean[j][i]) {
                                    someOcean[j][i - 1]++;
                                }
                                //South
                                if (someOcean[j][i + 1] < someOcean[j][i]) {
                                    someOcean[j][i + 1]++;
                                }
                                //East
                                if (someOcean[j + 1][i] < someOcean[j][i]) {
                                    someOcean[j + 1][i]++;
                                }
                                //West
                                if (someOcean[j - 1][i] < someOcean[j][i]) {
                                    someOcean[j - 1][i]++;
                                }
                            }
                            if(secondWave==2) {
                                //North
                                if (someOcean[j][i - 1] < someOcean[j][i]) {
                                    someOcean[j][i - 1]--;
                                }
                                //South
                                if (someOcean[j][i + 1] < someOcean[j][i]) {
                                    someOcean[j][i + 1]--;
                                }
                                //East
                                if (someOcean[j + 1][i] < someOcean[j][i]) {
                                    someOcean[j + 1][i]--;
                                }
                                //West
                                if (someOcean[j - 1][i] < someOcean[j][i]) {
                                    someOcean[j - 1][i]--;
                                }
                            }
                        }
                    }
                }
            }
        }

        return someOcean;
    }


}
