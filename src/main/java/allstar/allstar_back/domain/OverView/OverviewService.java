package allstar.allstar_back.domain.OverView;

import allstar.allstar_back.Entity.Overview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OverviewService {
    @Autowired
    private OverviewRepository overViewRepository;

    public List<Overview> getAllMissions() {
        return overViewRepository.findAll();
    }

    public Optional<Overview> getMissionById(Long id) {
        return overViewRepository.findById(id);
    }

    public Overview createMission(Overview missionOverview) {
        return overViewRepository.save(missionOverview);
    }

    public void deleteMission(Long id) {
        overViewRepository.deleteById(id);
    }
}
