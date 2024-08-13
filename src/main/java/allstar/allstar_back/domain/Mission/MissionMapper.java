package allstar.allstar_back.domain.Mission;

import allstar.allstar_back.Entity.Coordinate;
import allstar.allstar_back.Entity.Overview;
import allstar.allstar_back.domain.Coordinate.CoordinateDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionMapper {

    // DTO를 엔티티로 변환
    public static Coordinate dtoToEntity(CoordinateDTO dto, Overview overView) {
        return Coordinate.builder()
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .overView(overView) // 해당 엔티티와 연관된 Overview 설정
                .build();
    }

    // 엔티티를 DTO로 변환
    public static CoordinateDTO entityToDto(Coordinate entity) {
        CoordinateDTO dto = new CoordinateDTO();
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        return dto;
    }

    // DTO 리스트를 엔티티 리스트로 변환
    public static List<Coordinate> dtoListToEntityList(List<CoordinateDTO> dtoList, Overview overView) {
        return dtoList.stream()
                .map(dto -> dtoToEntity(dto, overView))
                .collect(Collectors.toList());
    }

    // 엔티티 리스트를 DTO 리스트로 변환
    public static List<CoordinateDTO> entityListToDtoList(List<Coordinate> entityList) {
        return entityList.stream()
                .map(MissionMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
