package devflix.data.mappers;

import devflix.models.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setCountryID(rs.getInt("country_id"));
        country.setName(rs.getString("name"));

        return country;
    }
}
