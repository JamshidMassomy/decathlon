package ee.decathlon_calculator.controllers;

import ee.decathlon_calculator.dto.DecathlonCalculationResponse;
import ee.decathlon_calculator.entities.Sport;
import ee.decathlon_calculator.services.DecathlonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public final class DecathlonController extends BaseController {

    private final DecathlonService decathlonService;
    @GetMapping(
            path = "calculate-points",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("Api for the decathlon calculations")
    @Operation(
            summary = "GET calculation result",
            description = "GET decathlon calculation result")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetches result successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request or failed to fetch calculations"),
            @ApiResponse(responseCode = "500", description = "Server error or server not available")
    })
    public ResponseEntity<DecathlonCalculationResponse> getCalculation(
           @Validated @RequestParam Sport sport,
           @Validated @RequestParam BigDecimal result) {
        return ResponseEntity.ok(decathlonService.getCalculations(sport, result));
    }
}
