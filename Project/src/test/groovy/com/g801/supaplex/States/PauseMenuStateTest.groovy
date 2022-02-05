package com.g801.supaplex.States

import com.g801.supaplex.Controller.Menu.PauseMenuController
import com.g801.supaplex.Model.Menu.PauseMenu
import spock.lang.Specification;

class PauseMenuStateTest extends Specification {

    def "Pause Menu States"() {

        given:
            PauseMenuState pauseMenuState = new PauseMenuState(new PauseMenu());
        expect:
            pauseMenuState.getModel() instanceof PauseMenu;
            pauseMenuState.getController() instanceof PauseMenuController;
    }
}