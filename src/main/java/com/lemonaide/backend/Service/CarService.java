package com.lemonaide.backend.Service;

import com.lemonaide.backend.SpringRepository.CarRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lemonaide.backend.RedisRepository.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void populateCarInfo() {

        List<Car> list = new ArrayList<>();

        list.add(new Car(UUID.randomUUID().toString(), "Toyota", "Camry", "2018", "Black"));
        list.add(new Car(UUID.randomUUID().toString(), "Honda", "Accord", "2018", "Red"));

        carRepository.saveAll(list);
    }

    public Iterable<Car> getAllCarInfo() {
        return carRepository.findAll();
    }

    public String getGoogleSearchResult(String car) {
        Set<String> result = new HashSet<>();
        String request = "https://www.google.com/search?q=toyota+camry+2018&num=20";
//        System.out.println("Sending request..." + request);

        try {

            // need http protocol, set this as a Google bot agent :)
            Document doc = Jsoup
                    .connect(request)
                    .userAgent(
                            "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                    .timeout(5000).get();

            // get all links
            Element eml = doc.getElementById("rhs_block");
//            Elements links = doc.getElementsByTag("span");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//            System.out.println(eml.text());
//            System.out.println(eml.html());
//            ArrayList<Element> conf = new ArrayList<>();
            Elements links = eml.getElementsByTag("div");
            for (Element link : links) {

//                String temp = link.attr("href");
//                if(temp.startsWith("/url?q=")){
//                    //use regex to get domain name
//                    //result.add(getDomainName(temp));
//
// }
                if(link.text().contains("Configur")) {
                    links.remove(link);
                }

            }
            System.out.println(eml.html());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
