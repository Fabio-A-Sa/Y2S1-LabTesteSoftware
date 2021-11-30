import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {

    public StringBar() {
        super();
    }

    private StringRecipe gerRecipe() {

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

}
