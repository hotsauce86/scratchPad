public class thePad {


    public static void main(String[] args){

        String countSpaceExample = "asdhfwer t asdljfno as doahedjkhnd ";


        System.out.println(countSpace(countSpaceExample));

        String s1 = "asbcsdsdf";
        String s2 = "sdfbeljkdcfj";

        MatchTwoString(s1,s2);
    }

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

}
