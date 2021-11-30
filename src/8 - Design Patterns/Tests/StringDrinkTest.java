import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.quality.MockitoHint;

public class StringDrinkTest {

    @Test
    public void stringDrink() {

        StringDrink drink = new StringDrink("ABCD");
        assertEquals("ABCD", drink.getText());
        drink.setText("DCBA");
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringInverter() {

        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter();
        si.execute(drink);
        assertEquals("DCBA", drink.getText());
    }

    @Test
    public void stringCaseChanger() {

        StringDrink drink = new StringDrink("aBcD");
        StringCaseChanger cc = new StringCaseChanger();
        cc.execute(drink);
        assertEquals("AbCd", drink.getText());
    }

    @Test
    public void stringReplacer() {

        StringDrink drink = new StringDrink("ABCDABCD");
        StringReplacer sr = new StringReplacer('A', 'X');
        sr.execute(drink);
        assertEquals("XBCDXBCD", drink.getText());
    }

    @Test
    public void stringRecipe() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        recipe.mix(drink);

        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void transformUndo() {

        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);

        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());

        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());

        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }

    @Test
    public void transformerGroup() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);

        StringTransformerGroup tg = new StringTransformerGroup(transformers);
        tg.execute(drink);

        assertEquals("dCbA-DcBa", drink.getText());
    }

    @Test
    public void transformerComposite() {

        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);

        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);

        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);

        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix(drink);

        assertEquals("DcBx-dCbA", drink.getText());
    }

    @Test
    public void happyHour() {

        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());

        bar.startHappyHour();
        assertTrue(bar.isHappyHour());

        bar.endHappyHour();
        assertFalse(bar.isHappyHour());
    }

    @Test
    public void addObserver() {

        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.startHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.endHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.times(1)).happyHourEnded(bar);
    }

    @Test
    public void removeObservers() {

        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        bar.removeObserver(clientMock);

        bar.startHappyHour();
        bar.endHappyHour();

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);
    }

    @Test
    public void orderStringRecipe() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        stringBar.order(drink, recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void impatientStrategy() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        ImpatientStrategy strategy = new ImpatientStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartOpened() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately as happy hour was already under way
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartClosed() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.addObserver(client); // this is important!

        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiAlreadyOpened() {

        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = stringBar.getRecipe();
        FerengiClient client = new FerengiClient();

        // Recipe is ordered immediately
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    
}
