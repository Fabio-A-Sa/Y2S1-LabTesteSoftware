public class StringCaseChanger implements StringTransformer {

    public void execute(StringDrink drink) {

        String oldString = drink.getText();
        String newString = "";

        for (int i = 0 ; i < oldString.length() ; i++) {
            char currentChar = oldString.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                currentChar = Character.toUpperCase(currentChar);
            } else { currentChar = Character.toLowerCase(currentChar); }
            newString += currentChar;
        }

        drink.setText(newString);
    }

    public void undo (StringDrink drink) {
        execute(drink);
    }
}
