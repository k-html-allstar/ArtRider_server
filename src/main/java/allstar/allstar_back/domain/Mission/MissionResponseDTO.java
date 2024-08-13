package allstar.allstar_back.domain.Mission;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MissionResponseDTO {
    private String missionTitle;           // Mission name
    private List<CoordinateDTO> coordinates;
}
