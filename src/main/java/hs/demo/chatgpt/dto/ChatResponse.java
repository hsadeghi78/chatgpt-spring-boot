package hs.demo.chatgpt.dto;

import java.util.List;

public class ChatResponse {

    private List<Choice> choices;

    // constructors, getters and setters


    public List<Choice> getChoices() {
        return choices;
    }

    public ChatResponse setChoices(List<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public static class Choice {

        private int index;
        private Message message;

        // constructors, getters and setters

        public int getIndex() {
            return index;
        }

        public Choice setIndex(int index) {
            this.index = index;
            return this;
        }

        public Message getMessage() {
            return message;
        }

        public Choice setMessage(Message message) {
            this.message = message;
            return this;
        }
    }
}
