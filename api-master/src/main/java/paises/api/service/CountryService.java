package paises.api.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import paises.api.domain.Country;
import paises.api.domain.CreateCountryCommand;
import paises.api.domain.ModifiyCountryCommand;

public interface CountryService
{

    Country create(CreateCountryCommand command);
    Page<Country> listall(Pageable pageable);
    Country update(Long id, ModifiyCountryCommand command);
    Country view(Long id);

}
