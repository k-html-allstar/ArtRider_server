package allstar.allstar_back.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Overview")
public class Overview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "overview_id")
    private Long id;

    private Double achieveDistance;
    private LocalDate completionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String generatedTitle;
    private String userDrawnMapImage;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private MissionLevel missionLevel;
}
