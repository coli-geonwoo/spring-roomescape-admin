package roomescape.controller.request;

import java.time.LocalDate;

public record ReservationRequest(String name, LocalDate date, Long timeId) {

}