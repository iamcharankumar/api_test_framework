package io.backend.services.discord;

import io.backend.commons.HttpStatuses;
import io.backend.commons.RestResource;
import io.backend.entities.request.discord.SendMessageRequest;
import io.backend.utils.RetryUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;

@Slf4j
public class DiscordController {

    DiscordClient discordClient;

    public DiscordController() {
        this.discordClient = new DiscordClient();
    }

    public String getSendMessageResponse(SendMessageRequest sendMessageRequest) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForDiscordException(2, 3)).get(() -> {
            Response sendMessageResponse = discordClient.getSendMessageResponse(sendMessageRequest);
            if (sendMessageResponse.getStatusCode() != HttpStatuses.NO_CONTENT.getCode())
                log.error("Retrying for the Discord Send Message Code. Please stay with us...");
            return sendMessageResponse.asString();
        });
    }
}