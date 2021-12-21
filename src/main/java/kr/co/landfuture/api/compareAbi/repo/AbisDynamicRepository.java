package kr.co.landfuture.api.compareAbi.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.landfuture.api.def.SqlAbi;
import kr.co.landfuture.api.model.OutAbi;

@Repository

public class AbisDynamicRepository {
       @Autowired
       private NamedParameterJdbcOperations jdbcOperations;

       @Transactional("abiTransactionManager")
       public List<OutAbi> srchAbislist(OutAbi aAbi, int id, int pageNumber, int pageSize) {

              String query = SqlAbi.sqlAbiCols + SqlAbi.sqlAbiFrom + SqlAbi.sqlAbiWhere + SqlAbi.sqlAbiGroupBy
                            + SqlAbi.sqlAbiOrderBy;
              query += " LIMIT  " + (pageNumber * pageSize) + ", " + pageSize;

              return this.jdbcOperations.query(query, (rs, rowNum) -> {
                     aAbi.setAd(rs.getString("ad"));
                     aAbi.setSt(rs.getString("st"));
                     aAbi.setTn(rs.getString("tn"));
                     aAbi.setCourt_name(rs.getString("court_name"));
                     aAbi.setCourt_code(rs.getString("court_code"));
                     aAbi.setSa_num(rs.getString("sa_num"));
                     aAbi.setR(rs.getString("r"));
                     aAbi.setBa(rs.getString("ba"));
                     aAbi.setB_u(rs.getString("b_u"));
                     aAbi.setB_s(rs.getString("b_s"));
                     aAbi.setL_n_right(rs.getString("l_n_right"));
                     aAbi.setLa(rs.getString("la"));
                     aAbi.setL_u(rs.getString("l_u"));
                     aAbi.setL_s(rs.getString("l_s"));
                     aAbi.setB_i2(rs.getString("b_i2"));
                     aAbi.setL_i2(rs.getString("l_i2"));
                     aAbi.setSp(rs.getString("sp"));
                     try {
                            return aAbi.copy();
                     } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                     } catch (IllegalAccessException e) {
                            e.printStackTrace();
                     }
                     return aAbi;
              });
       }

       @Transactional("abiTransactionManager")
       public List<String> srchAbisMeta() { // 해당 sql의 결과 총 수를 구함

              String query = "Select count(*) total " + SqlAbi.sqlAbiFrom + SqlAbi.sqlAbiWhere;
              query = "SELECT COUNT(*) total FROM (" + query + ") aaa";

              return this.jdbcOperations.query(query, (rs, rowNum) -> {
                     return rs.getString("total");
              });
       }
}
