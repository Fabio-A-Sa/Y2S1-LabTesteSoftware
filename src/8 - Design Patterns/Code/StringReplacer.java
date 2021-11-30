public class StringReplacer implements StringTransformer {

    private char i;
    private char f;

    public StringReplacer (char i, char f) {
        this.i = i;
        this.f = f;
    }

    public void execute(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (currentChar == this.i) currentChar = f;
            newString += currentChar;
        }
        drink.setText(newString);
    }

    public void undo(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (currentChar == this.f) currentChar = this.i;
            newString += currentChar;
        }
        drink.setText(newString);
    }
}
