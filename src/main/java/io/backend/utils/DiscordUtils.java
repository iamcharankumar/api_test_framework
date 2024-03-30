package io.backend.utils;

import io.backend.entities.request.discord.SendMessageRequest;
import io.backend.exceptions.DiscordException;
import io.backend.services.discord.DiscordHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscordUtils {
    public static String buildDiscordMessage(int passedTestCases, int failedTestCases, int skippedTestCases, int totalTestCases) {
        StringBuilder discordMessageBuilder = new StringBuilder();
        discordMessageBuilder.append("\n******************************\n")
                .append("\nPASS: ").append(passedTestCases)
                .append("\nFAIL: ").append(failedTestCases)
                .append("\nSKIP: ").append(skippedTestCases)
                .append("\nTOTAL: ").append(totalTestCases).append("\n")
                .append("\nPASS% : ").append(TestUtils.calculateTestCasePercentage(passedTestCases, totalTestCases))
                .append("\nFAIL% : ").append(TestUtils.calculateTestCasePercentage(failedTestCases, totalTestCases))
                .append("\nReport Portal Run: ").append(TestUtils.getReportPortalLaunchUrl())
                .append("\n******************************\n");
        return String.valueOf(discordMessageBuilder);
    }

    public static void sendMessageToChannel(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(message);
        String sendMessageResponse = DiscordHelper.getDiscordController().getSendMessageResponse(sendMessageRequest);
        if (sendMessageResponse.isEmpty())
            return;
        else
            throw new DiscordException("DISCORD UTILS: Send Message Failed!");
    }
}