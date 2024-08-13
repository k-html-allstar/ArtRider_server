package allstar.allstar_back.domain.OverView;

import allstar.allstar_back.Entity.Overview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class OverviewController {

    private final OverviewService overviewService;

    @GetMapping
    public List<Overview> getAllMissions() {
        return overviewService.getAllMissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Overview> getMissionById(@PathVariable Long id) {
        Optional<Overview> missionOverview = overviewService.getMissionById(id);
        return missionOverview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Overview> createMission(@RequestBody Overview missionOverview) {
        Overview createdMission = overviewService.createMission(missionOverview);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        overviewService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }
}