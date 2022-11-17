package com.javateam.TimeLabel.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration("file:src/main/resources/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageCondesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
    // 구현체를 바꾸어도 크게 상관은 없음

    @Test
    public void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "product");
        /*for(String messageCode : messageCodes){
            System.out.println("messageCodes = " + messageCodes);
        }*/
        // 테스트 성공
        assertThat(messageCodes).containsExactly("required.product", "required");
    }

    @Test
    public void messageCodesResolverField() {
        // 	String[] resolveMessageCodes(String errorCode, String objectName, String field, @Nullable Class<?> fieldType);
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "product", "productName", String.class);
        for(String messageCode : messageCodes){
            System.out.println("messageCodes = " + messageCodes);
        }

    }

}
