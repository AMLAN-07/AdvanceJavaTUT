package PrintStructure;

public class DumbBell {
    public void printDumbBell(int rows) {
        for(int i=rows;i>=0;i--){
            for(int j=0;j<rows-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows-i;j++){
                System.out.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DumbBell db = new DumbBell();
        db.printDumbBell(5);
    }
}
