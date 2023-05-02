package paises.api.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import paises.api.domain.Country;
import paises.api.domain.CountryMapper;
import paises.api.domain.CreateCountryCommand;
import paises.api.domain.ModifiyCountryCommand;
import paises.api.persistence.CountryRepository;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl //implements CountryService
{
    public final CountryRepository repository;

    public Page<Country>listall(Pageable pageable) //método para mostrar paises, e ordenar os países por qualquer uma das suas propriedades.
    {
        return repository.findAll(pageable);
    }

    public Country create(CreateCountryCommand command)
    {
        //Country country=new Country();
        var country= CountryMapper.INSTANCE.toCountry(command);
        country.setName(command.getName());
        country.setRegion(command.getRegion());
        country.setSubregion(command.getSubregion());
        country.setArea(command.getArea());
        country.setCapital(command.getCapital());

        return repository.save(country);
    }

    public Country findbyId(Long id)
    {
        return repository.findById(id).orElseThrow(
                () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "THIS COUNTRY CANNOT EXIT"));
    }

    public Country update(Long id, ModifiyCountryCommand command)
    {
        if(repository.existsById(id)) {
            Country country = findbyId(id);
            CountryMapper.INSTANCE.toCountry(command,country);
            country.setCapital(command.getCapital());
            country.setArea(command.getArea());
            return repository.save(country);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "THIS COUNTRY CANNOT BE MODIFY");
    }

    public Country view(Long id)
    {
        if(repository.existsById(id))
           return repository.getReferenceById(id);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "THIS COUNTRY CANNOT BE VIEW");
    }
}