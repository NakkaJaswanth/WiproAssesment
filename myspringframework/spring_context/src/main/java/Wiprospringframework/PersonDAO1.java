package Wiprospringframework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

public class PersonDAO1 implements PersonDAO  {
	  private JdbcTemplate jdbcTemplate;

	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    private static class PersonMapper implements RowMapper<Person> {
	        
	        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Person p = new Person();
	            p.setId(rs.getInt("id"));
	            p.setAge(rs.getInt("age"));
	            p.setFirstName(rs.getString("firstName"));
	            p.setLastName(rs.getString("lastName"));
	            return p;
	        }
	    }

	    public List<Person> getAllPersons() {
	        String sql = "SELECT * FROM person";
	        return jdbcTemplate.query(sql, new PersonMapper());
	    }

	    public Person getPersonById(int id) {
	        String sql = "SELECT * FROM person WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonMapper());
	    }

	    public void createPerson(Person person) {
	        String sql = "INSERT INTO person(age, firstName, lastName) VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, person.getAge(), person.getFirstName(), person.getLastName());
	    }

	 
	    public void updatePerson(Person person) {
	        String sql = "UPDATE person SET age=?, firstName=?, lastName=? WHERE id=?";
	        jdbcTemplate.update(sql, person.getAge(), person.getFirstName(), person.getLastName(), person.getId());
	    }
	    public void deletePerson(int id) {
	        String sql = "DELETE FROM person WHERE id=?";
	        jdbcTemplate.update(sql, id);
	    }

	

}
