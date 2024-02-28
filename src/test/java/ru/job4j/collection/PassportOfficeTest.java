package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenPassportIsDoubled() {
        Citizen citizenOne = new Citizen("13455", "Pozharov Aleksandr");
        Citizen citizenTwo = new Citizen("13455", "Grizlov Boris");
        PassportOffice office = new PassportOffice();
        office.add(citizenOne);
        assertThat(office.add(citizenTwo)).isFalse();
    }
}