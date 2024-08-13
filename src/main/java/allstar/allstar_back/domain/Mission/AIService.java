package allstar.allstar_back.domain.Mission;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    private final RestTemplate restTemplate;
    private final String aiServiceUrl;

    public AIService(RestTemplate restTemplate, @Value("${ai.service.url}") String aiServiceUrl) {
        this.restTemplate = restTemplate;
        this.aiServiceUrl = aiServiceUrl;
    }

    public AIResponseDTO processMissionData(MissionRequestDTO requestDTO) {
        try {
            ResponseEntity<AIResponseDTO> response = restTemplate.postForEntity( // AI 서비스에 POST 요청을 보내고, ResponseEntity 객체
                    aiServiceUrl,
                    requestDTO,
                    AIResponseDTO.class
            );

            // 응답 확인을 위해 로그 출력
            System.out.println("AI Service Response: " + response.getBody());

            return response.getBody();


        } catch (HttpClientErrorException e) {
            // 서버가 4xx 또는 5xx 응답을 반환하는 경우
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // 기타 예외 처리
            e.printStackTrace();
            throw new RuntimeException("AI 서비스 호출 중 오류 발생", e);
        }
    }
}