package com.lab4.demo.ai;

import com.lab4.demo.hotel.model.Hotel;
import com.lab4.demo.label.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AiService {


    public Hotel[] recommend(double lat, double lon, String desc) {
        final String uri = "http://127.0.0.1:5000/recommend?lat="+lat+"&lon="+lon+"&description=" + desc;
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        Hotel[] result = restTemplate.getForObject(uri, Hotel[].class);
        System.out.println(result);
        return result;
    }

    public List<String> getObjectsFromImage(List<String> photos) {
        final String uri = "http://127.0.0.1:5000/generate_profile";

        String[] result ;
        List<String> objects = new ArrayList<>();
        for (String photo : photos) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(photo,headers);


            RestTemplate restTemplate = new RestTemplate();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
            messageConverters.add(converter);
            restTemplate.setMessageConverters(messageConverters);
            result= restTemplate.postForObject(uri, entity, String[].class);
            objects.addAll(Arrays.asList(result));
        }


        return objects;
    }


}
