package com.LuckBattle.Webservices.controller;

import com.LuckBattle.Webservices.entity.UserLuck;
import com.LuckBattle.Webservices.service.LuckService;
import com.LuckBattle.Webservices.service.UserLuckService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LuckControllerTest {
    @Mock
    private LuckService luckService;

    @Mock
    private UserLuckService userLuckService;

    @InjectMocks
    private LuckController luckController;

    @Test
    public void addUserLuck(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        UserLuck userLuck = Mockito.mock(UserLuck.class);
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        String stringDate= DateFor.format(date);
        when(userLuckService.saveLuck(any(UserLuck.class))).thenReturn(userLuck);

        ResponseEntity<UserLuck> responseEntity = luckController.generateUserLuck(stringDate, Integer.toString(userLuck.getUser_id()));
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getUser_id()).isEqualTo(userLuck.getUser_id());
    }
}
