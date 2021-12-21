package kr.co.landfuture.controllers;

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.landfuture.api.AbiMain;
import kr.co.landfuture.api.model.CompareData;
import kr.co.landfuture.api.model.OutAbi;
import kr.co.landfuture.api.model.OutCourse;
import kr.co.landfuture.api.model.OutJobtype;
import kr.co.landfuture.api.model.OutLesson;
import kr.co.landfuture.util.ResponseWrapperCjs;

@RestController
@RequestMapping({ "/api" })
public class APIController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    AbiMain abiMain;

    @GetMapping({ "/compares/{id}" }) // 지정된 과정
    public ResponseEntity<OutCourse> getCourseByIdaaa(@PathVariable("id") int id) {
        return new ResponseEntity<>(CompareData.COURSES[id - 1], HttpStatus.OK);
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.GET) // 수작업으로 바깥쪽 json 첨가
    @ResponseBody
    public String listforCompanies() {
        String objJackson = "";
        try {
            objJackson = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(Arrays.copyOfRange(CompareData.LESSONS, 2, 4));
            objJackson = "{ \"payload\":" + objJackson + "}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objJackson;
    }

    @RequestMapping(value = "/abis", method = RequestMethod.GET) // 사건 리스트 조회
    @ResponseBody
    public ResponseEntity<ResponseWrapperCjs<OutAbi[]>> searchAbis(@RequestParam("jobTypeId") int id,
            @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ParseException {
        ResponseWrapperCjs<OutAbi[]> wrapper = new ResponseWrapperCjs<OutAbi[]>(
                this.abiMain.abiMain(id, pageNumber, pageSize));
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/abis_org", method = RequestMethod.GET) // 사건 리스트 조회
    @ResponseBody
    public ResponseEntity<ResponseWrapperCjs<OutAbi[]>> searchAbis_org(@RequestParam("jobTypeId") Optional<Integer> id,
            @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ParseException {
        int f = pageNumber * pageSize;
        ResponseWrapperCjs<OutAbi[]> wrapper = new ResponseWrapperCjs<OutAbi[]>(
                Arrays.copyOfRange(CompareData.ABIS, f, f + pageSize));
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @GetMapping({ "/jobtypes_org/{id}" }) // 지정된 과정
    public ResponseEntity<OutJobtype> searchJobtypes_org(@PathVariable("id") int id) {
        return new ResponseEntity<>(CompareData.JOBTYPES[id - 1], HttpStatus.OK);
    }

    @GetMapping({ "/jobtypes/{id}" }) // 지정된 과정
    public ResponseEntity<OutJobtype> searchJobtypes(@PathVariable("id") int id) {
        return new ResponseEntity<>(this.abiMain.abiMeta(), HttpStatus.OK);
    }

    @RequestMapping(value = "/lessons", method = RequestMethod.GET) // wrapper로 json 첨가
    @ResponseBody
    public ResponseEntity<ResponseWrapperCjs<OutLesson[]>> searchLessons(@RequestParam("courseId") Optional<Integer> id)
            throws ParseException {
        ResponseWrapperCjs<OutLesson[]> wrapper = new ResponseWrapperCjs<OutLesson[]>(
                Arrays.copyOfRange(CompareData.LESSONS, 0, 4));
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @RequestMapping(value = "/compares", method = RequestMethod.GET) // wrapper로 json 첨가
    @ResponseBody
    public ResponseEntity<ResponseWrapperCjs<OutCourse[]>> getPartnersByDate() throws ParseException {
        ResponseWrapperCjs<OutCourse[]> wrapper = new ResponseWrapperCjs<OutCourse[]>(
                Arrays.copyOfRange(CompareData.COURSES, 0, 4));
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
