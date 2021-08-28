package live.moku.search.controller;

import live.moku.search.models.HtDocDto;
import live.moku.search.service.HtDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/ht-doc")
@RestController
public class HtDocController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HtDocService htDocService;

    @RequestMapping("qryHtDocByMessage")
    public ResponseEntity qryHtDoc(String searchWord) {
        List<HtDocDto> list = new ArrayList<>();
        try {
            list = htDocService.findHtDocByMessage(searchWord);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Scheduled(cron = "*/30 * * * * ?")
    public void healthCheck() {
        restTemplate.getForObject("http://localhost:8080/actuator/health", String.class);
    }
}
