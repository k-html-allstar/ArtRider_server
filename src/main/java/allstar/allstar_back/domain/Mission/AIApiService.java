//package allstar.allstar_back.domain.Mission;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class AIApiService {
//    private final RestTemplate restTemplate;
//
//    public AIApiService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public void sendMissionDataToBackend(MissionResponseDTO missionResponseDTO) {
//        String backendUrl = "http://52.78.24.194:8080/api/receive-mission"; // 백엔드의 URL
//
//        ResponseEntity<String> response = restTemplate.postForEntity(
//                backendUrl,
//                missionResponseDTO,
//                String.class
//        );
//
//        // 필요한 경우 응답 처리
//        System.out.println("Backend response: " + response.getBody());
//    }
//}
