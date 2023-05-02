package paises.api.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import paises.api.domain.Country;

public interface CountryRepository extends JpaRepository<Country,Long>
{

}
