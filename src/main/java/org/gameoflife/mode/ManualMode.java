package org.gameoflife.mode;

import org.gameoflife.service.GameService;
import org.gameoflife.ui.ConsolePrinter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("MANUAL")
public class ManualMode implements GameMode {
    @Override
    public void run(GameService gameService) {
        System.out.println("PRESS ENTER TO PLAY");
        // TODO - криво читает кнопку
        try {
            int key = System.in.read();
            while (key == 10) {
                gameService.calculateNextGeneration();
                String s = gameService.getFieldAsString();
                ConsolePrinter.print(s);
                key = System.in.read();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading input");
        }
    }
}
