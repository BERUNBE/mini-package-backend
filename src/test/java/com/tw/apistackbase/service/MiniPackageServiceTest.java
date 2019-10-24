package com.tw.apistackbase.service;

import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.repository.MiniPackageRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiniPackageServiceTest {

    @MockBean
    private MiniPackageRepository miniPackageRepository;

    @Autowired
    private MiniPackageService miniPackageService;

    @Test
    void createMiniPackage_should_return_parkinglot() {
        MiniPackage miniPackage = createMiniPackage(10001110101L, "Alpha", 8675309L, "Booked", "2019-01-01");
        when(miniPackageRepository.save(any())).thenReturn(miniPackage);
        miniPackage = miniPackageService.createMiniPackage(miniPackage);

        assertThat(miniPackage, is(notNullValue()));
    }

    @Test
    void getMiniPackages_should_return_list_of_minipackages() {
        MiniPackage miniPackage1 = createMiniPackage(10001110101L, "Alpha", 8675309L, "Booked", "2019-01-01");
        MiniPackage miniPackage2 = createMiniPackage(20002220202L, "Bravissimo", 8675309L, "Booked", "2019-02-02");
        when(miniPackageRepository.findAll()).thenReturn(asList(miniPackage1, miniPackage2));

        assertThat(miniPackageService.getAllMiniPackages(), containsInAnyOrder(miniPackage1, miniPackage2));
    }

    private MiniPackage createMiniPackage(Long packageNumber, String receiver, Long phone, String status, String bookingTime) {
        MiniPackage miniPackage = new MiniPackage();
        miniPackage.setPackageNumber(packageNumber);
        miniPackage.setReceiver(receiver);
        miniPackage.setPhone(phone);
        miniPackage.setStatus(status);
        miniPackage.setBookingTime(bookingTime);
        return miniPackage;
    }
}
