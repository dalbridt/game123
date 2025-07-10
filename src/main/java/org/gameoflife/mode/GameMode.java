package org.gameoflife.mode;

import org.gameoflife.service.GameService;

public interface GameMode {
    void run(GameService gameService);
}
