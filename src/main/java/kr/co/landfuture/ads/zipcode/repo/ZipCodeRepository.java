package kr.co.landfuture.ads.zipcode.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.landfuture.ads.zipcode.data.ZipCodeModel;

@Repository
public class ZipCodeRepository {
    @Autowired
    private NamedParameterJdbcOperations jdbcOperations;
    private static String BASIC_QUERY = "select sido, sgg from zipcode_nsdi_20200329 where\t1 = 1";

    @Transactional("zipcodeTransactionManager")
    public List<ZipCodeModel> selectSido(String sgg, String umd) {
        String query = BASIC_QUERY;
        if (!sgg.equals(""))
            query = query + " and (sgg = '" + sgg + "' or sgg2 = '" + sgg + "' )";
        if (umd.length() > 3)
            query = query + " and umd like '" + umd.substring(0, 4) + "%' ";
        query = query + " limit 1 ";

        return this.jdbcOperations.query(query,
                (rs, rowNum) -> new ZipCodeModel(rs.getString("sido"), rs.getString("sgg"), "", ""));
    }
}
