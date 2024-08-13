package allstar.allstar_back.domain.Mission;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionDTO {
    private Long id;
    private String missionName;
    private String s3url;
}
