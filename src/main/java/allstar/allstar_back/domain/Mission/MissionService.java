package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.Entity.MissionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;

    public List<MissionDTO> getAllMissions() {
        return missionRepository.findAll().stream().map(mission -> new MissionDTO(
                mission.getId(),
                mission.getMissionTitle(),
                mission.getS3url()
        )).collect(Collectors.toList());
    }

    public void saveMissionTitle(String missionTitle) {
        MissionLevel mission = MissionLevel.builder()
                .missionTitle(missionTitle)
                .build();

        missionRepository.save(mission);
    }
}
