package kr.co.landfuture.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.landfuture.api.compareAbi.repo.AbisDynamicRepository;
import kr.co.landfuture.api.model.OutAbi;
import kr.co.landfuture.api.model.OutJobtype;

@Service
public class AbiMain {
    @Autowired
    AbisDynamicRepository abisDynamicRepository;

    public OutAbi[] abiMain(int id, int pageNumber, int pageSize) {
        OutAbi outAbi = new OutAbi();
        List<OutAbi> abiItems = this.abisDynamicRepository.srchAbislist(outAbi, id, pageNumber, pageSize);
        return abiItems.toArray(new OutAbi[abiItems.size()]);
    }

    public OutJobtype abiMeta() {
        OutJobtype outJobtype = new OutJobtype();
        List<String> abiItems = this.abisDynamicRepository.srchAbisMeta();
        outJobtype.setJobtypesCount(Integer.parseInt(abiItems.get(0)));
        return outJobtype;
    }
}
