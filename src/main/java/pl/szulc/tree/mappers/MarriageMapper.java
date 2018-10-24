package pl.szulc.tree.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.szulc.tree.dto.MarriageDto;
import pl.szulc.tree.entity.Marriage;
@Component
public class MarriageMapper {
	
public Marriage mapToEntity(Marriage marriage, MarriageDto marriageDto) {
		
		if (marriage == null) {
			marriage = new Marriage();
		}
		
		if (marriageDto != null) {
			marriage.setId(marriageDto.getId());
			marriage.setDateOfMarriage(marriageDto.getDateOfMarriage());
			marriage.setPlaceOfMarriage(marriageDto.getPlaceOfMarriage());
			return marriage;
		}
		return null;
	}
	
	public MarriageDto mapToDto(Marriage marriage){
		if (marriage != null) {
			MarriageDto marriageDto = new MarriageDto();
			marriageDto.setId(marriage.getId());
			marriageDto.setDateOfMarriage(marriageDto.getDateOfMarriage());
			marriageDto.setPlaceOfMarriage(marriageDto.getPlaceOfMarriage());
			return marriageDto;
		}
		return null;
	}
	
	public List<MarriageDto> mapMarriageEntityListToMarriageDtoList(List<Marriage>marriages){
		List<MarriageDto>marriagesDto = new ArrayList<>();
		for (int i = 0; i < marriages.size(); i++) {
			marriagesDto.add(mapToDto(marriages.get(i)));
		}
		return marriagesDto;
	}
}
