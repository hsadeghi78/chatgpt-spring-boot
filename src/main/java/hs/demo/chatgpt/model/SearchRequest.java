package hs.demo.chatgpt.model;



public class SearchRequest {
    private String query;

    public String getQuery() {
        return query;
    }

    public SearchRequest setQuery(String query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "query='" + query + '\'' +
                '}';
    }
}
