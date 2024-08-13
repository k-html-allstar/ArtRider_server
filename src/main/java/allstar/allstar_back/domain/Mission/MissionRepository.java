package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.Entity.MissionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionLevel, Long> {
}
