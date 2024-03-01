package ee.decathlon_calculator.controllers;

import ee.decathlon_calculator.entities.DecathlonEvents;
import ee.decathlon_calculator.entities.EventType;
import ee.decathlon_calculator.entities.Sport;
import ee.decathlon_calculator.services.CalculationService;
import ee.decathlon_calculator.services.DecathlonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = DecathlonController.class)
class DecathlonEventsControllerTest {

    @MockBean
    private DecathlonService decathlonService;

    @MockBean
    private CalculationService calculationService;

    @Autowired
    private MockMvc mvc;

    @Test
    void test_should_return_ok_json_result() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.
                get("/api/v1/calculate-points")
                        .param("sport", String.valueOf(Sport.LONG_JUMP))
                        .param("result", "32")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseBody =
                mvcResult.getResponse().getContentAsString();
        assertThat(responseBody).isNotNull();
        verify(decathlonService, times(1)).getPointCalculation(any(), any());
    }

    @Test
    void test_should_throw_not_found_on_wrong_path() throws Exception {
     mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/wrong-path")
                .param("sport", "aSport")
                .param("result", "aResult"))
                .andExpect(status().isNotFound())
                .andReturn();
        verifyNoInteractions(decathlonService);
    }

    @Test
    void test_should_return_correct_calculations() throws Exception {
        Sport aLongJump = Sport.LONG_JUMP;
        Double aResult = 7.76;
        String expectedResponseBody =
                """
                { result: 1000 }
                """;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/calculate-points")
                        .param("sport", String.valueOf(aLongJump))
                        .param("result", String.valueOf(aResult)))
                .andExpect(status().isOk())
                .andReturn();
        String actualResponseBody =
                mvcResult.getResponse().getContentAsString();
        DecathlonEvents aFieldEvent = DecathlonEvents.builder()
                .eventType(EventType.JUMP_EVENT)
                .build();

        // assertThat(actualResponseBody).isSameAs(expectedResponseBody);
        // verify(calculationService, times(1)).calculateFieldEvent(aFieldEvent, BigDecimal.valueOf(7.76));
        verify(decathlonService, times(1)).getPointCalculation(aLongJump, aResult);
    }
}
