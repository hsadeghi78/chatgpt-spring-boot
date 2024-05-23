package hs.demo.chatgpt.model;

import hs.demo.chatgpt.dto.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatGPTRequest {

    private String model = "gpt-3.5-turbo";// = "gpt-3.5-turbo-instruct";
    private String prompt;
    private int max_tokens = 100;
    private int temperature = 1;

    public String getModel() {
        return model;
    }

    public ChatGPTRequest setModel(String model) {
        this.model = model;
        return this;
    }

    public String getPrompt() {
        return prompt;
    }

    public ChatGPTRequest setPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public ChatGPTRequest setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
        return this;
    }

    public int getTemperature() {
        return temperature;
    }

    public ChatGPTRequest setTemperature(int temperature) {
        this.temperature = temperature;
        return this;
    }
}
