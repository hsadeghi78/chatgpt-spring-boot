package hs.demo.chatgpt.web;

import hs.demo.chatgpt.model.SearchRequest;
import hs.demo.chatgpt.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class SearchController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    private final ChatGPTService gptService;

    public SearchController(ChatGPTService gptService) {
        this.gptService = gptService;
    }

    @PostMapping("/searchGPT")
    public String search(@RequestBody SearchRequest search) {
        // create a request
        System.out.println(search.toString());

        return gptService.processChat(search.getQuery());
    }
}
