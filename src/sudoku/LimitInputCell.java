/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #8
 * 1 - 5026221040 - Alif Faturrohman
 * 2 - 5026221104- Muhamad Arif Satriyo
 * 3 - 5026221132 - Zikrul Khalis
 */
package sudoku;

import javax.swing.*;
import javax.swing.text.*;
import java.text.NumberFormat;

class LimitInputCell extends PlainDocument {
    private JFormattedTextField textField;
    private int limit;

    LimitInputCell(int limit) {
        super();
        this.limit = limit;
        this.textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textField.setDocument(this); // Set document for the text field
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

        if (str == null) {
            return;
        }

        // Only allow digits
        if (str.matches("\\d+")) {
            if ((getLength() + str.length()) <= limit && Integer.parseInt(str) > 0) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
