package io.backend.services.discord;

import io.backend.commons.RestResource;
import io.backend.constants.ApiRoutes;
import io.backend.entities.request.discord.SendMessageRequest;
import io.backend.exceptions.DiscordException;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor
public class DiscordClient {

    private static final String WEBHOOK_TOKEN = "{your_web_hook_token}";

    @SneakyThrows
    public Response getSendMessageResponse(SendMessageRequest sendMessageRequest) {
        String discordWebHookEndPoint = ApiRoutes.DISCORD_WEBHOOK + WEBHOOK_TOKEN;
        String discordMessage = RestResource.getInstance().serialize(sendMessageRequest);
        Response sendMessageResponse = RestResource.getInstance().postApiResponse(discordMessage, discordWebHookEndPoint);
        if (sendMessageResponse != null)
            return sendMessageResponse;
        else
            throw new DiscordException("Client Exception: Discord Send Message API");
    }
}