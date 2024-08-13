package allstar.allstar_back.domain.Mission;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MissionRequestDTO {
    private Double latitude;
    private Double longitude;
    private String difficulty;
}
