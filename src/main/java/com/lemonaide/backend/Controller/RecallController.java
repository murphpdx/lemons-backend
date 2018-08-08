package com.lemonaide.backend.Controller;


import com.lemonaide.backend.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecallController {

    private String baseUri = "https://one.nhtsa.gov/webapi/api/Recalls";

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public String getAll() {
        return "All car info";
    }

    @GetMapping("/years")
    public String getAllYears() {
        final String uri = baseUri + "/vehicle?format=json";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return result;

    }

    @GetMapping("/year/{year}")
    public String makersWithRecallsByYear(@PathVariable("year") int year) {
        final String uri = baseUri + "/vehicle/modelyear/" + String.valueOf(year);

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return result;

    }

    @GetMapping("/year/{year}/make/{make}")
    public String recalledModelsByYearAndMake(@PathVariable("year") int year,
                                      @PathVariable("make") String make) {
        final String uri = baseUri + "/vehicle/modelyear/" + String.valueOf(year) + "/make/" + make;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return result;
    }

    @GetMapping("year/{year}/make/{make}/model/{model}")
    public String recallsByYearAndMakeAndModel(@PathVariable("year") int year,
                                               @PathVariable("make") String make,
                                               @PathVariable("model") String model) {
        final String uri = baseUri + "/vehicle/modelyear/" + String.valueOf(year) + "/make/" + make
                            + "/model/" + model;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }


    @GetMapping("campaign/{campaignNum}")
    public String recallsByCampaignNumber(@PathVariable("campaignNum") String campaignNum) {
        final String uri = baseUri + "/vehicle/campaignnumber/" + campaignNum;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping("/googleSearch")
    public String googleScrape() {
        return carService.getGoogleSearchResult("bmw");
    }

}
