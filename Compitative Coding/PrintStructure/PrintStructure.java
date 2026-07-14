package PrintStructure;

public class PrintStructure {
    public void HollowCube(int size) {
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
   
    public static void main(String[] args) {
        PrintStructure PS = new PrintStructure();
        PS.HollowCube(5); // Set the size of the hollow cube
    }
}
