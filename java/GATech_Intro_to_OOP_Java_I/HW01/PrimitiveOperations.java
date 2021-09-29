public class PrimitiveOperations {
    public static void main(String[] args) {
        int firstNum = 10;
        double secNum = 2.0;
        System.out.println("" + firstNum);
        System.out.println("" + secNum);
        
        double product = firstNum * secNum;
        System.out.println("" + product);
        
        float floated = (float)firstNum;
        System.out.println("" + floated);
        
        int inted = (int)secNum;
        System.out.println("" + inted);
        
        char upper = 'A';
        System.out.println("" + upper);
        
        char lower = (char)((int)upper + 32);
        System.out.println("" + lower);
    }
}

