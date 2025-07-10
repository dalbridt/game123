package org.gameoflife.mode;

import org.gameoflife.entities.GameField;
import org.gameoflife.service.GameService;
import org.gameoflife.ui.ConsolePrinter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Profile("AUTO")
public class AutoMode implements GameMode {
    @Override
    public void run(GameService gameService) {
        while (true) {
            gameService.calculateNextGeneration();
            String s = gameService.getFieldAsString();
            ConsolePrinter.print(s);
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
