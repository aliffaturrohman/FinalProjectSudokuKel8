package sudoku;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Cell extends JTextField{
    //cell class untuk membuat model kolom sudoku

    //define constants for color and fonts
    public static final Color BG_GIVEN = Color.white;
    public static final Color FG_GIVEN = Color.BLACK;
    public static final Color FG_NOT_GIVEN = Color.black;
    public static final Color BG_TO_GUESS = Color.white;
    public static final Color BG_CORRECT_GUESS = new Color(0,216,0);
    public static final Color BG_WRONG_GUESS = new Color(216,0,0);
    public static final Font FONT_NUMBERS = new Font("Comic Sans MS", Font.PLAIN, 28);

    int row, col;
    int number;
    boolean status;

    //constructor
    public Cell(int row, int col){
        super(); //JTextField
        this.row = row;
        this.col = col;

        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }

    /** Reset this cell for a new game, given the puzzle number and isGiven */
    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven;
        paint();    // paint itself
    }

    /** This Cell (JTextField) paints itself based on its status */
    public void paint() {
        super.setBorder(new LineBorder(Color.lightGray,1));
        if (status == true) {
            // Inherited from JTextField: Set display properties
            super.setText(number + "");
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        } else if (status == false) {
            // Inherited from JTextField: Set display properties
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        }
    }
    public void painttrue(){
        super.setBackground(BG_CORRECT_GUESS);
    }
    public void paintfalse(){
        super.setBackground(BG_WRONG_GUESS);
    }
}
