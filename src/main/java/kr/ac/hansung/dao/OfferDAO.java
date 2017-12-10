package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	/* 상세보기 */
	public List<Offer> getDetails(int year, int semester) {
		String sqlstatement = "select * from datas where year=? and semester=?";
		return jdbcTemplate.query(sqlstatement, new Object [] {year, semester}, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rownum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setName(rs.getString("name"));
				offer.setSeperation(rs.getString("seperation"));
				offer.setCredit(rs.getInt("credit"));
				
				return offer;
			}
			
		});
	}
	
	/* 학기별 학점 */
	public int getCredit(int year, int semester) {
		String sqlstatement = "select sum(credit) from datas where year=? and semester=?";
		return jdbcTemplate.queryForObject(sqlstatement, new Object [] {year, semester}, Integer.class);
	}

	/* 이수별 학점 */
	public int getSeperation(String seperation) {
		String sqlstatement = "select sum(credit) from datas where seperation=?";
		return jdbcTemplate.queryForObject(sqlstatement, new Object [] {seperation}, Integer.class);
	}
	
	/* 총학점 */
	public int getTotalCredit() {
		String sqlstatement = "select sum(credit) from datas";
		return jdbcTemplate.queryForObject(sqlstatement, Integer.class);
	}
	
	/* 수강 신청 */
	public boolean insert(Offer offer) {
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String seperation = offer.getSeperation();
		int credit = offer.getCredit();
		
		String sqlstatement = "insert into datas (year, semester, code, name, seperation, credit) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlstatement, new Object [] {year, semester, code, name, seperation, credit}) == 1);
	}
}

