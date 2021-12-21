package kr.co.landfuture.ads.landrule.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.landfuture.ads.landrule.data.LandRuleId;
import kr.co.landfuture.ads.landrule.data.LandRuleModel;

@Repository
public interface LandRuleRepository extends JpaRepository<LandRuleModel, LandRuleId> {
  @Query(nativeQuery = true, value = " SELECT * from c_ads.land_rule_cd_v3 where st_nm like :word LIMIT 1")
  @Transactional("landruleTransactionManager")
  public List<LandRuleModel> listAddressesLikeWord(String word);
}
