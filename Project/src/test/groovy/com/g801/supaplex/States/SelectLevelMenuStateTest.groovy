package com.g801.supaplex.States

import com.g801.supaplex.Controller.Menu.SelectLevelMenuController
import com.g801.supaplex.Model.Menu.SelectLevelMenu
import spock.lang.Specification;

class SelectLevelMenuStateTest extends Specification {

    def "Select Level States"() {

        given:
            SelectLevelMenuState levelState = new SelectLevelMenuState(new SelectLevelMenu());
        expect:
            levelState.getModel() instanceof SelectLevelMenu;
            levelState.getController() instanceof SelectLevelMenuController;
    }
}