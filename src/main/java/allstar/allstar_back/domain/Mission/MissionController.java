package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.Entity.Coordinate;
import allstar.allstar_back.domain.Coordinate.CoordinateDTO;
import allstar.allstar_back.global.dto.ApiResult;
import allstar.allstar_back.global.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
public class MissionController {
    private final MissionService missionService;
    private final AIService aiService;

    @Operation(summary = "난이도 미션 이미지 조회", description = "난이도 미션 이미지 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
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
    @PostMapping("/start-mission")
    public ResponseEntity<?> startMission(@RequestBody MissionRequestDTO missionRequestdto) {
        // 프론트로부터 좌표 배열과 난이도 데이터 받기 (DTO에서 데이터 추출)
        Double latitude = missionRequestdto.getLatitude();
        Double longitude = missionRequestdto.getLongitude();
        String difficulty = missionRequestdto.getDifficulty();

        String aiResponse = aiService.processMissionData(latitude, longitude, difficulty);

        return ResponseEntity.ok(aiResponse);
    }
}
