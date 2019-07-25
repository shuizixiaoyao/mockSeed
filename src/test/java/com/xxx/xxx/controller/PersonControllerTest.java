package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.StringUtil;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;

    @Test
    public void should_get_name() {
        //given
        Person person = new Person("a", "b", new BigDecimal(1));
        given(personService.find(argThat(argument -> "name".equals(argument.getName())))).willReturn(person);
        //when
        String name = personController.getName("name");
        //then
        assertThat(name).isEqualTo("a,b");
    }
}