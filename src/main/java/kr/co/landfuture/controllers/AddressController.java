package kr.co.landfuture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.landfuture.ads.datainout.AddressIn;
import kr.co.landfuture.ads.datainout.AddressOut;
import kr.co.landfuture.ads.service.ParsingMain;

@RestController
@RequestMapping({ "/ads" })
public class AddressController {
    @Autowired
    ParsingMain pm;

    @Value("${spring.datasource.jdbcUrl}")
    private String spring_db;

    @GetMapping({ "/address/{address_org}" })
    public ResponseEntity<AddressOut> getAddressGet(@PathVariable("address_org") String address_only)
            throws IllegalArgumentException, IllegalAccessException {
        AddressIn addressIn = new AddressIn(address_only);
        return new ResponseEntity<>(this.pm.parsingMain(addressIn), HttpStatus.OK);
    }

    @PostMapping({ "/address" })
    public ResponseEntity<AddressOut> getAdressPost(@RequestBody AddressIn addressIn)
            throws IllegalArgumentException, IllegalAccessException {
        // System.out.println(addressIn.address_org);
        return new ResponseEntity<>(this.pm.parsingMain(addressIn), HttpStatus.OK);
    }
}
