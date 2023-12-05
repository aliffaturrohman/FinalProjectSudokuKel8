package sudoku;

public enum CellStatus {
    GIVEN, //clue, angka yang muncul di papan
    TO_GUESS, //need to guess, kolom kosong yang perlu diisi
    CORRECT_GUESS, //isi benar
    WRONG_GUESS, //isi salah
    //sudoku akan solved jika semua angka terisi benar
}
