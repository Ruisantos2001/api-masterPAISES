package paises.api.domain;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import paises.api.presentation.CountryJson;

@Mapper
public abstract class CountryMapper {
    public static final CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    public abstract Country toCountry (CreateCountryCommand command);

    public abstract void  toCountry(ModifiyCountryCommand command,@MappingTarget Country country);

    public abstract CountryJson maptoJson(Country country);
    public abstract CountryJson toJson(Country country);

    public Page<CountryJson> toJson(Page<Country> countries) { return countries.map(this::toJson);}

}
