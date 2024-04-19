package roomescape.domain.reservation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Reservations {

    private final Map<Long, Reservation> reservations;

    public Reservations(Map<Long, Reservation> reservations) {
        this.reservations = reservations;
    }

    public Reservations() {
        this(new HashMap<>());
    }

    public void add(Long id, Reservation reservation) {
        if (hasDuplicatedId(id)) {
            throw new IllegalArgumentException("예약 객체의 중복된 키가 존재합니다");
        }

        reservations.put(id, reservation);
    }

    public void delete(Long id) {
        reservations.remove(id);
    }

    public Set<Reservation> getReservations() {
        return Set.copyOf(reservations.values());
    }

    private boolean hasDuplicatedId(Long otherId) {
        return reservations.keySet()
                .stream()
                .anyMatch(id -> id.equals(otherId));
    }
}