import java.util.Arrays;
public class test{

    public static String[] fix_fail_string(String[] input){
        String correct = "fail";
        for (int i =0; i<input.length; i++){
            if (input[i].equals("f4il")){
                input[i] = correct;

            }
        }
        return input;
    }

    public static int[] get_failed_tests(String[] input){

        int result[] = new int[get_fail_count(input)];
        int j = 0;
        for (int i =0; i<input.length; i++){
            if (input[i].equals("f4il")){

                result[j] = i;
                j++;
            }
        }
        return result;
    }

    public static int get_fail_count(String[] input){

        int result = 0;
        for (int i =0; i<input.length; i++){
            if (input[i].equals("f4il")){
                result++;
            }
        }
        return result;
    }

    public  static void test_report(String[] input){ //a void method to print results
        int [] tests = get_failed_tests(input); // get index
        int count = get_fail_count(input);//get count
        String[] fix = fix_fail_string(input);//correct typo
        System.out.println("\n");//space
        System.out.println(count + " tests failed:"); // print count
        for (int i = 0; i<count; i++){
            if(i == count-1){
            System.out.print("Test"+tests[i]+ "\n");} //print index

            else{
            System.out.print("Test"+tests[i]+ ", ");}
        }
        System.out.println();
        System.out.println("Results:"); // print results arrays
        System.out.println(Arrays.toString(fix));
    }
    public static void main(String[] args){
        String[]input = {"pass", "f4il", "pass", "pass", "f4il", "pass", "pass", "pass", "pass", "pass"} ;
        test_report(input); //call report function
    }

}