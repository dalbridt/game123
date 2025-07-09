package org.gameoflife.mode;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("AUTO")
public class AutoMode implements GameMode {
    @Override
    public void run() {}
}
