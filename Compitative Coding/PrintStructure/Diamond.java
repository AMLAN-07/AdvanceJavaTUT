package PrintStructure;

public class Diamond {
    public void printDiamond(int rows) {
        for(int i=rows-1; i<=rows; i++) {
            for(int j=i; j<rows; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=rows-1; i>=1; i--) {
            for(int j=i; j<rows; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        
    }
    public static void main(String[] args) {
        Diamond d = new Diamond();
        d.printDiamond(5);
    }
}
