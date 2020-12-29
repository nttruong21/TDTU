

public class Test {
    public static void main(String[] args) {
        Exercise3 ex = new Exercise3();
        System.out.println("Recursion: " + ex.exA_Rec(5));
        System.out.println("Iteration: " + ex.exA_Ite(5));
        System.out.println("Array: " + ex.exA_Arr(5));
        System.out.println("Recursion: " + ex.exB_Rec(21));
        System.out.println("Iteration: " + ex.exB_Ite(21));
        System.out.println("Array: " + ex.exB_Arr(21));
        System.out.println("Recursion: " + ex.exC_Rec(5, 3));
        System.out.println("Iteration: " + ex.exC_Ite(5, 3));
        System.out.println("Array: " + ex.exC_Arr(5, 3));
        System.out.println("Recursion: " + ex.exD_Rec(5));
        System.out.println("Iteration: " + ex.exD_Ite(5));
        System.out.println("Array: " + ex.exD_Arr(5));
    }
}
