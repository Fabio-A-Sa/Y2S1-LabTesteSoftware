public class StringInverter implements StringTransformer {

    public void execute(StringDrink drink) {

        String invert = "";
        for (int i = 0 ; i < drink.getText().length() ; i++) {
            invert = drink.getText().charAt(i) + invert;
        }

        drink.setText(invert);
    }

    public void undo(StringDrink drink) {
        execute(drink);
    }
}