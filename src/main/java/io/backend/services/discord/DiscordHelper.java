package io.backend.services.discord;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscordHelper {

    private static DiscordController discordController;

    public static DiscordController getDiscordController() {
        if (discordController == null) {
            log.info("Setting up the Discord Controller...");
            discordController = new DiscordController();
        }
        return discordController;
    }
}