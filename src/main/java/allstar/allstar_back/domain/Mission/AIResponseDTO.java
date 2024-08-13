package allstar.allstar_back.domain.Mission;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AIResponseDTO {
    private String missionTitle;           // AI가 생성한 작품 타이틀
    private List<CoordinateDTO> coordinates; // 위도 경도를 담은 2차원 배열
}
