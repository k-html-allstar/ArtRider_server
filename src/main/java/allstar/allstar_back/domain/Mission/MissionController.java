package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.global.dto.ApiResult;
import allstar.allstar_back.global.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
public class MissionController {
    private final MissionService missionService;
    private final AIService aiService;

    @Operation(summary = "난이도 미션 이미지 조회", description = "난이도 미션 이미지 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 처리됨",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MissionResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/image")
    public ApiResult<List<MissionDTO>> getAllBanners() {
        try {
            List<MissionDTO> banners = missionService.getAllMissions();
            return ApiResult.ok(banners);
        } catch (RuntimeException e) {
            return ApiResult.withError(ErrorCode.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Operation(summary = "현재 좌표배열과 난이도 정보를 처리하여 AI 서비스로 전달", description = "프론트로부터 좌표배열과 난이도 정보를 받아와 AI 서비스로 전달")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping
    public ResponseEntity<MissionResponseDTO> startMission(
            @RequestBody MissionRequestDTO missionRequestDTO) {

        // AI 서비스로 데이터를 전송하여 비동기 처리 요청
        AIResponseDTO aiResponseDTO = aiService.processMissionData(missionRequestDTO);

        // AI로부터 받은 데이터를 프론트엔드에 그대로 전달
        MissionResponseDTO response = new MissionResponseDTO();
        response.setCoordinates(aiResponseDTO.getCoordinates());
        response.setMissionTitle(aiResponseDTO.getMissionTitle());

        return ResponseEntity.ok(response);
    }
}
//    @Operation(summary = "AI에서 받은 자전거도로의 좌표배열과 ai생성 제목 정보를 처리하여 프론트로 전달", description = "AI에서 받은 자전거도로의 좌표배열과 ai생성 제목 정보를 처리하여 프론트로 전달")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
//            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
//            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
//    })
//    @PostMapping("/receive-mission")
//    public ResponseEntity<MissionResponseDTO> receiveMissionData(@RequestBody MissionResponseDTO missionResponseDTO) {
//        // AI 서비스로부터 받은 데이터 처리
//        String missionTitle = missionResponseDTO.getMissionTitle();
//
//        // MissionService를 통해 MissionTitle을 저장
//        missionService.saveMissionTitle(missionTitle);
//
//        // 데이터를 그대로 프론트엔드로 전달
//        return ResponseEntity.ok(missionResponseDTO);
//    }
//}
