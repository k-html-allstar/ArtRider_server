package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.domain.Coordinate.CoordinateDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MissionRequestDTO {
    private Double latitude;
    private Double longitude;
    private String difficulty;
}
