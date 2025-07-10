package org.gameoflife;

import org.gameoflife.config.MyConfig;
import org.gameoflife.mode.GameMode;
import org.gameoflife.service.GameService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment env = context.getEnvironment();

        String profile = "AUTO";
        for (String arg : args) {
            if (arg.startsWith("--profile=")) {
               profile = arg.substring("--profile=".length());
               break;
            }
        }
        env.addActiveProfile(profile);
        context.register(MyConfig.class);
        context.refresh();

        GameMode gameMode = context.getBean(GameMode.class);
        GameService gameService = context.getBean(GameService.class);
        System.out.println(gameMode.getClass().getName());
        gameMode.run(gameService);
    }
}
