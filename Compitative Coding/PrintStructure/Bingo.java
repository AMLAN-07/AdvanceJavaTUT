package PrintStructure;

public class Bingo {
    public void snakePattern(int size) {
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    System.out.print((i * size + j + 1) + "\t");
                } else {
                    System.out.print((i * size + (size - j)) + "\t");
                }
            }
            System.out.println();
        }}

        public void spiralPattern(int size) {
            
        
    }
    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        bingo.snakePattern(5); // Set the size of the snake pattern
        System.out.println();
        bingo.spiralPattern(5); // Set the size of the spiral pattern
    }
}
