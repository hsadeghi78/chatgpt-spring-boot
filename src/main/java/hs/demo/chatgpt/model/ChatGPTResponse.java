package hs.demo.chatgpt.model;

import hs.demo.chatgpt.dto.Message;

import java.util.List;

public class ChatGPTResponse {

    private List<Choice> choices;


    public List<Choice> getChoices() {
        return choices;
    }

    public ChatGPTResponse setChoices(List<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public static class Choice {

        private String  text;

        public String getText() {
            return text;
        }

        public Choice setText(String text) {
            this.text = text;
            return this;
        }
    }
}
