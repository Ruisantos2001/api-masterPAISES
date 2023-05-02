package paises.api.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paises.api.domain.CountryMapper;
import paises.api.domain.CreateCountryCommand;
import paises.api.domain.ModifiyCountryCommand;
import paises.api.persistence.CountryRepository;
import paises.api.service.*;

@RestController
@RequestMapping("/paises")
@RequiredArgsConstructor
public class CoutryController {

    private final CountryServiceImpl countryService;
    private final CountryRepository countryRepository;

    //countrycreate no retorno
    @PostMapping()
    public ResponseEntity <CountryJson> create(@RequestBody@Valid CreateCountryCommand command)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(CountryMapper.INSTANCE.toJson(countryService.create(command)));
    }

    @GetMapping()
    public ResponseEntity<?> listall(@PageableDefault(size=10,sort={"name"}) Pageable pageable)
    {
        return ResponseEntity.ok(countryService.listall(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryJson> modify(@RequestBody@Valid ModifiyCountryCommand data, @PathVariable Long id)
    {
        return ResponseEntity.ok(CountryMapper.INSTANCE.toJson(countryService.update(id, data)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id )
    {
        if (countryRepository.existsById(id)) {
             countryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Pais eliminado com sucesso");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("THIS COUNTRY CANNOT BE DELETED");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity view(@PathVariable Long id)
    {
        return ResponseEntity.ok(countryService.view(id));
    }
}