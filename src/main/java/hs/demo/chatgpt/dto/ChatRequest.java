package hs.demo.chatgpt.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatRequest {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequest(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

    // getters and setters


    public String getModel() {
        return model;
    }

    public ChatRequest setModel(String model) {
        this.model = model;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public ChatRequest setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public int getN() {
        return n;
    }

    public ChatRequest setN(int n) {
        this.n = n;
        return this;
    }

    public double getTemperature() {
        return temperature;
    }

    public ChatRequest setTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }
}
