package io.backend.services.discord;

import io.backend.commons.RestResource;
import io.backend.constants.ApiConstants;
import io.backend.constants.ApiRoutes;
import io.backend.entities.request.discord.SendMessageRequest;
import io.backend.exceptions.DiscordException;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor
public class DiscordClient {

    @SneakyThrows
    public Response getSendMessageResponse(SendMessageRequest sendMessageRequest) {
        String discordWebHookEndPoint = ApiRoutes.DISCORD_WEBHOOK + ApiConstants.WEBHOOK_TOKEN;
        String discordMessage = RestResource.getInstance().serialize(sendMessageRequest);
        Response sendMessageResponse = RestResource.getInstance().postApiResponse(discordMessage, discordWebHookEndPoint);
        if (sendMessageResponse != null)
            return sendMessageResponse;
        else
            throw new DiscordException("Client Exception: Discord Send Message API");
    }
}