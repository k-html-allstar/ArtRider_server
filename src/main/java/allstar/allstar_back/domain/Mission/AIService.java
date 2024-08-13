package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.Entity.Coordinate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AIService {
    private final RestTemplate restTemplate;

    public AIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String processMissionData(List<Coordinate> coordinates, String difficulty) {
        // AI 서비스에 전달할 데이터 구조 정의
        Map<String, Object> aiRequestData = new HashMap<>();
        aiRequestData.put("coordinates", coordinates);
        aiRequestData.put("difficulty", difficulty);

        // AI 서비스에 POST 요청 보내기
        String aiServiceUrl = "http://ai-service-url/ai-process"; // AI 서비스의 실제 URL로 대체해야 함
        ResponseEntity<String> response = restTemplate.postForEntity(
                aiServiceUrl,
                aiRequestData,
                String.class
        );

        return response.getBody(); // AI 서비스의 응답 반환
    }
}
