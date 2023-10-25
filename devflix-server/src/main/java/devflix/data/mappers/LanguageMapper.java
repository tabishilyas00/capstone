package devflix.data.mappers;

import devflix.models.Language;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageMapper implements RowMapper<Language> {
    @Override
    public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
        Language language = new Language();
        language.setLanguageID(rs.getInt("language_id"));
        language.setName(rs.getString("name"));

        return language;
    }
}
