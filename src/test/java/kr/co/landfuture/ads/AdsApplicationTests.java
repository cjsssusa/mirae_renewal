package kr.co.landfuture.ads;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.landfuture.ads.datainout.AddressIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdsApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private WebApplicationContext ctx;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).addFilters(new CharacterEncodingFilter("UTF-8", true)) // 필터추가
				// .alwaysDo(print())
				.build();
	}

	@Test
	public void jb_no_space() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/ads/address/경기도하남시광암동58-2").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido", is("경기도")))
				.andExpect(jsonPath("$.sido_s", is("경기"))).andExpect(jsonPath("$.sgg", is("하남시")))
				.andExpect(jsonPath("$.umd", is("광암동"))).andExpect(jsonPath("$.li", is("")))
				.andExpect(jsonPath("$.bon", is("58"))).andExpect(jsonPath("$.bu", is("2")))
				.andExpect(jsonPath("$.a_dong", is(""))).andExpect(jsonPath("$.a_floor", is("")))
				.andExpect(jsonPath("$.a_ho", is(""))).andExpect(jsonPath("$.umd_st", is("")))
				.andExpect(jsonPath("$.a_place", is(""))).andExpect(jsonPath("$.each_else", is("")))
				.andExpect(jsonPath("$.a_first", is("경기도 하남시"))).andExpect(jsonPath("$.a_second", is("광암동 58-2")))
		//
		;
	}

	@Test
	public void sido_sgg() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ads/address/충청북도 음성군").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido", is("충청북도")))
				.andExpect(jsonPath("$.sido_s", is("충북"))).andExpect(jsonPath("$.sgg", is("음성군")))
		//
		;
	}

	@Test
	void street_full() throws Exception {
		this.mockMvc.perform(post("/ads/address").contentType(MediaType.APPLICATION_JSON).content(
				"{\"address_org\": \"경기도 화성시 효행로853번길 12-16, 2동 6층610호 (송산동,신현대주택)\",\"job_cate\": \"\",\"address\": \"\"}")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.sido", is("경기도"))).andExpect(jsonPath("$.sido_s", is("경기")))
				.andExpect(jsonPath("$.sgg", is("화성시"))).andExpect(jsonPath("$.st_nm", is("효행로853번길")))
				.andExpect(jsonPath("$.b_bon", is("12"))).andExpect(jsonPath("$.b_bu", is("16")))
				.andExpect(jsonPath("$.a_dong", is("2동"))).andExpect(jsonPath("$.a_floor", is("6층")))
				.andExpect(jsonPath("$.a_ho", is("610호"))).andExpect(jsonPath("$.umd_st", is("송산동")))
				.andExpect(jsonPath("$.a_place", is("신현대주택"))).andExpect(jsonPath("$.each_else", is("신현대주택")))
				.andExpect(jsonPath("$.a_first", is("경기도 화성시")))
		//
		;
	}

	@Test
	void jibun_s_2() throws Exception {
		AddressIn user = new AddressIn("울산광역시 중구 종가25길 2-1, 1층115호", "", "");
		this.mockMvc
				.perform(post("/ads/address").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido", is("울산광역시")))
				.andExpect(jsonPath("$.sido_s", is("울산"))).andExpect(jsonPath("$.sgg", is("중구")))
				.andExpect(jsonPath("$.umd", is("장현동"))).andExpect(jsonPath("$.li", is("")))
				.andExpect(jsonPath("$.bon", is("162"))).andExpect(jsonPath("$.bu", is("3")))
				.andExpect(jsonPath("$.a_dong", is(""))).andExpect(jsonPath("$.a_floor", is("1층")))
				.andExpect(jsonPath("$.a_ho", is("115호"))).andExpect(jsonPath("$.umd_st", is("")))
				.andExpect(jsonPath("$.a_place", is(""))).andExpect(jsonPath("$.each_else", is("")))
				.andExpect(jsonPath("$.a_first", is("울산광역시 중구"))).andExpect(jsonPath("$.a_second", is("")))

				.andExpect(jsonPath("$.st_nm", is("종가25길"))).andExpect(jsonPath("$.bs", is("")))
				.andExpect(jsonPath("$.b_bon", is("2"))).andExpect(jsonPath("$.b_bu", is("1")))
				.andExpect(jsonPath("$.lat", is("35.587352583862"))).andExpect(jsonPath("$.lng", is("129.34244364111")))
				.andExpect(jsonPath("$.e_lat", is("35.587238283664")))
				.andExpect(jsonPath("$.e_lng", is("129.3423795771")))
		//
		;
	}

	@Test
	void jibun_f_1() throws Exception {
		AddressIn user = new AddressIn("강원도 영월군 영월읍 하송리 389하송2차아파트 201동 2층 206호", "", "");
		this.mockMvc
				.perform(post("/ads/address").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido", is("강원도")))
				.andExpect(jsonPath("$.sido_s", is("강원"))).andExpect(jsonPath("$.sgg", is("영월군")))
				.andExpect(jsonPath("$.umd", is("영월읍"))).andExpect(jsonPath("$.li", is("하송리")))
				.andExpect(jsonPath("$.bon", is("389"))).andExpect(jsonPath("$.bu", is("")))
				.andExpect(jsonPath("$.a_dong", is("201동"))).andExpect(jsonPath("$.a_floor", is("2층")))
				.andExpect(jsonPath("$.a_ho", is("206호"))).andExpect(jsonPath("$.umd_st", is("")))
				.andExpect(jsonPath("$.a_place", is("하송2차아파트"))).andExpect(jsonPath("$.each_else", is("하송2차아파트")))
				.andExpect(jsonPath("$.a_first", is("강원도 영월군"))).andExpect(jsonPath("$.a_second", is("영월읍 하송리 389")))
				.andExpect(jsonPath("$.st_nm", is("동강로"))).andExpect(jsonPath("$.bs", is("0")))
				.andExpect(jsonPath("$.b_bon", is("1488"))).andExpect(jsonPath("$.b_bu", is("126")))
				.andExpect(jsonPath("$.lat", is("37.268174820066"))).andExpect(jsonPath("$.lng", is("128.52733411971")))
				.andExpect(jsonPath("$.e_lat", is("37.268197549989")))
				.andExpect(jsonPath("$.e_lng", is("128.52734790964")))
		//
		;
	}

	@Test
	void jibun_f_2() throws Exception {
		AddressIn user = new AddressIn("경기도 안산시 상록구 부곡동 656-17번지 오페라하우스A동", "", "");
		this.mockMvc
				.perform(post("/ads/address").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido", is("경기도")))
				.andExpect(jsonPath("$.sido_s", is("경기"))).andExpect(jsonPath("$.sgg", is("안산시 상록구")))
				.andExpect(jsonPath("$.umd", is("부곡동"))).andExpect(jsonPath("$.li", is("")))
				.andExpect(jsonPath("$.bon", is("656"))).andExpect(jsonPath("$.bu", is("17")))
				.andExpect(jsonPath("$.a_dong", is("A동"))).andExpect(jsonPath("$.a_floor", is("")))
				.andExpect(jsonPath("$.a_ho", is(""))).andExpect(jsonPath("$.umd_st", is("")))
				.andExpect(jsonPath("$.a_place", is("오페라하우스"))).andExpect(jsonPath("$.each_else", is("오페라하우스")))
				.andExpect(jsonPath("$.a_first", is("경기도 안산시 상록구"))).andExpect(jsonPath("$.a_second", is("부곡동 656-17")))

				.andExpect(jsonPath("$.st_nm", is("성호로"))).andExpect(jsonPath("$.bs", is("0")))
				.andExpect(jsonPath("$.b_bon", is("374"))).andExpect(jsonPath("$.b_bu", is("")))
				.andExpect(jsonPath("$.lat", is("37.335617264907"))).andExpect(jsonPath("$.lng", is("126.86333818612")))
				.andExpect(jsonPath("$.e_lat", is("37.335648022192")))
				.andExpect(jsonPath("$.e_lng", is("126.86335467775")))
		//
		;
	}

	// @Test
	// void jibun_f_3() throws Exception {
	// AddressIn user = new AddressIn("제주특별자치도 제주시 구좌읍 종달리 산71", "", "");
	// this.mockMvc
	// .perform(post("/ads/address").contentType(MediaType.APPLICATION_JSON)
	// .content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
	// .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.sido",
	// is("경기도")))
	// .andExpect(jsonPath("$.sido_s", is("경기"))).andExpect(jsonPath("$.sgg",
	// is("안산시 상록구")))
	// .andExpect(jsonPath("$.umd", is("부곡동"))).andExpect(jsonPath("$.li", is("")))
	// .andExpect(jsonPath("$.bon", is("656"))).andExpect(jsonPath("$.bu",
	// is("17")))
	// .andExpect(jsonPath("$.a_dong", is("A동"))).andExpect(jsonPath("$.a_floor",
	// is("")))
	// .andExpect(jsonPath("$.a_ho", is(""))).andExpect(jsonPath("$.umd_st",
	// is("")))
	// .andExpect(jsonPath("$.a_place",
	// is("오페라하우스"))).andExpect(jsonPath("$.each_else", is("오페라하우스")))
	// .andExpect(jsonPath("$.a_first", is("경기도 안산시
	// 상록구"))).andExpect(jsonPath("$.a_second", is("부곡동 656-17")))
	//
	// .andExpect(jsonPath("$.st_nm", is("성호로"))).andExpect(jsonPath("$.bs",
	// is("0")))
	// .andExpect(jsonPath("$.b_bon", is("374"))).andExpect(jsonPath("$.b_bu",
	// is("")))
	// .andExpect(jsonPath("$.lat",
	// is("37.335617264907"))).andExpect(jsonPath("$.lng", is("126.86333818612")))
	// .andExpect(jsonPath("$.e_lat", is("37.335648022192")))
	// .andExpect(jsonPath("$.e_lng", is("126.86335467775")))
	// //
	// ;
	// }

}
