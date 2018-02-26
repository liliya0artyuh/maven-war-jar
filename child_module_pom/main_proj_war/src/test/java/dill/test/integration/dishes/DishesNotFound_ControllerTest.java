package dill.test.integration.dishes;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.dill.app.App;
import com.example.dill.app.domain.dishes.Dish;
import com.example.dill.app.domain.dishes.DishRepository;
import com.example.dill.app.rest.dishes.dto.DishesService;

/**
 * @author Liliya Artyukh
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class DishesNotFound_ControllerTest {

	private MediaType contentType = new MediaType("application", "json", Charset.forName("UTF-8"));;

	private MockMvc mockMvc;

	private String userName = "bdussault";

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	// private DishDto dishDto;
	//
	// private Dish dish;

	private List<Dish> dishList = new ArrayList<Dish>();

	// private List<DishDto> dishDtoList = new ArrayList<>();

	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private DishesService dishesService;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		this.dishRepository.deleteAll();
		// this.accountRepository.deleteAllInBatch();

		// this.dish = dishRepository.save(new Dish(userName, "password"));
		//this.dishList.add(dishRepository.save(new Dish("name 1", "A description 1")));
	//	this.dishList.add(dishRepository.save(new Dish("name 2", "A description 2")));
	}

//	@Test
//	public void userNotFound() throws Exception {
//		mockMvc.perform(post("/george/bookmarks/").content(this.json(new Dish())).contentType(contentType))
//				.andExpect(status().isNotFound());
//	}

	
	@Test
	public void readSingleDish_NotFound() throws Exception {
		mockMvc.perform(get("/dishes/" + "9874554566")).andExpect(status().isNotFound());
	}
	

	@Test
	public void readDishes_NotFound() throws Exception {
		mockMvc.perform(get("/dishes")).andExpect(status().isNotFound());
	}

//	@Test
//	public void createDish() throws Exception {
//		String bookmarkJson = json(new Dish("new dish 999", "new dish 9999"));
//
//		this.mockMvc.perform(post("/dishes").contentType(contentType).content(bookmarkJson))
//				.andExpect(status().isCreated());
//	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

	public DishesService getDishesService() {
		return dishesService;
	}

	public void setDishesService(DishesService dishesService) {
		this.dishesService = dishesService;
	}
}
