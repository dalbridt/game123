package org.gameoflife.mode;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("MANUAL")
public class ManualMode implements GameMode {
    @Override
    public void run() {}
}
