package hs.demo.chatgpt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hs.demo.chatgpt.model.ChatGPTRequest;
import hs.demo.chatgpt.model.ChatGPTResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {

    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY1 = "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";
    private static final String API_KEY = "sk-proj-RArSyPpc79xqAeY9YKgPT3BlbkFJNcakczUksY1L0Q0Ju7Pl";

    ObjectMapper mapper= new ObjectMapper();

    public String processChat(String query){
        ChatGPTRequest request = new ChatGPTRequest();
        request.setPrompt(query);


        HttpPost post = new HttpPost(API_URL);
        post.addHeader("Authorization", "Bearer " + API_KEY);
        post.addHeader("Content-Type", "application/json");



        try{
            String body = mapper.writeValueAsString(request);

            System.out.println("body:"+body);
            final StringEntity entity = new StringEntity(body);
            post.setEntity(entity);

            try(CloseableHttpClient httpClient = HttpClients.custom().build();
                CloseableHttpResponse response = httpClient.execute(post)){

                String responseEntity = EntityUtils.toString(response.getEntity());
                System.out.println("responseEntity:"+responseEntity);
                ChatGPTResponse gptResponse= mapper.convertValue(responseEntity, ChatGPTResponse.class);
                return gptResponse.getChoices().get(0).getText();

            }catch (Exception e){
                e.printStackTrace();
                return "Failed";
            }

        } catch (Exception e){
            e.printStackTrace();
            return "Failed";
        }
    }
}
