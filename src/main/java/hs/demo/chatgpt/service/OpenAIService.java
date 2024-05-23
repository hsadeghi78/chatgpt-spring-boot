package hs.demo.chatgpt.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;*/


public class OpenAIService {


    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "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";

    /*public String getChatGPTResponse(String prompt) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(API_URL);
            httpPost.setHeader("Authorization", "Bearer " + API_KEY);
            httpPost.setHeader("Content-Type", "application/json");

            CompletionRequest completionRequest = new CompletionRequest(prompt);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest = objectMapper.writeValueAsString(completionRequest);

            httpPost.setEntity(new StringEntity(jsonRequest, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                if (response.getCode() == 200) {
                    return new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
                } else {
                    throw new IOException("Error response: " + response.getCode() + " " + response.getReasonPhrase());
                }
            }
        }
    }*/

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class CompletionRequest {
        private String model = "text-davinci-003";
        private String prompt;
        private int max_tokens = 150;

        public CompletionRequest(String prompt) {
            this.prompt = prompt;
        }

        public String getModel() {
            return model;
        }

        public CompletionRequest setModel(String model) {
            this.model = model;
            return this;
        }

        public String getPrompt() {
            return prompt;
        }

        public CompletionRequest setPrompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public int getMax_tokens() {
            return max_tokens;
        }

        public CompletionRequest setMax_tokens(int max_tokens) {
            this.max_tokens = max_tokens;
            return this;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class ChatGPTResponse {
        @JsonProperty("choices")
        private Choice[] choices;

        public Choice[] getChoices() {
            return choices;
        }

        public ChatGPTResponse setChoices(Choice[] choices) {
            this.choices = choices;
            return this;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Choice {
            @JsonProperty("text")
            private String text;

            public String getText() {
                return text;
            }

            public Choice setText(String text) {
                this.text = text;
                return this;
            }
        }
    }

    /*public static void main(String[] args) {
        OpenAIService service = new OpenAIService();
        try {
            String response = service.getChatGPTResponse("Hello, ChatGPT!");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
