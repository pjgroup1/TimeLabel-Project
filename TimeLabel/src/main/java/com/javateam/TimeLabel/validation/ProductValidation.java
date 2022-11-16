package com.javateam.TimeLabel.validation;

import com.javateam.TimeLabel.model.ProductVO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/**
 * bindingResult.addError(new FieldError("product", "productName", product.getProductPrice(), false, null, null, "상품 이름은 필수 입니다."));
 * public FieldError(String objectName, String field, @Nullable Object rejectedValue, boolean bindingFailure,
 *
 * @Nullable String[] codes, @Nullable Object[] arguments, @Nullable String defaultMessage)
 * FieldError 오류 발생시
 * objectName : 오류가 발생한 객체 이름
 * field : 오류 필드
 * redirectValue : 사용자가 입력한 값(거절한 값)
 * bindingFailure : 타입 오류 같은 바인딩 실패인지, 검증 실패인지 구분 값
 * codes : 메시지 코드
 * arguments : 메시지에서 사용하는 인자
 * defaultMessage : 기본 오류 메시지
 */

/**
 *  스프링이 Validator 인터페이스를 별도로 제공하는 이유는 체계적으로 검증 기능을 도입하기 위해서다.
 *  검증기를 직접 불러서 사용해도 괜찮지만 그렇지만 Validator 인터페이스를 사용해서 검증기를 만들면
 *  스프링의 추가적인 도음을 받을 수 있다.
 */
@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // supports 해당 검증기를 지원하는 여부 확인
        // 파라미터로 넘어오는 클래스가 지원이 되는지 확인
        // ProductVO == clazz
        return ProductVO.class.isAssignableFrom(clazz);
    }

    // BindingResult는 ModelAttribute 의 뒤에 와야함..(중요함)
    // BindingResult가 없으면 스프링은 오류발생시 컨트롤러로 접근을 못하게됨 하지만 있으면
    // BindingResult는에 담아서 컨트롤러를 정상 호출해줌
    // ModelAttribute 뒤에 있는 객체가 자동으로 model.addAttribute(ProductVO, product) 로 들어감
    // 가격(Integer) 부분에 문자가 들어오면 아예 컨트롤러에 진입도 전에 오류가 터진다.

    @Override // 검증 로직
    public void validate(Object target, Errors errors) {
        // ProductVO를 캐스팅해서 사용
        ProductVO product = (ProductVO) target;

        // Errors는 bindingResult의 부모 클래스임
        if (!StringUtils.hasText(product.getProductName())) {
            // bindingResult 는 무엇을 대상으로 하는지 알고있기 떄문에 코드가 간결해짐
            errors.rejectValue("productName", "required");
        }
        // 참고로 price 가 인트일때 == null 사용 불가임
        if (product.getProductPrice() == null || product.getProductPrice() < 1000 || product.getProductPrice() > 1000000) {
            // bindingResult.addError(new FieldError("product", "productName", product.getProductPrice(), false, null, null, "상품 이름은 필수 입니다."));
            errors.rejectValue("productPrice", "reange", new Object[]{1000, 1000000}, null);
        }
        if (product.getProductQuantity() == null || product.getProductQuantity() >= 9999) {
            // bindingResult.addError(new FieldError("product", "productName", product.getProductQuantity(), false, null, null, "상품 이름은 필수 입니다."));
            errors.rejectValue("productQuantity", "max", new Object[]{9999}, null);
        }
        // 특정 필드가 아닌 복합 룰 검증
        if (product.getProductPrice() != null && product.getProductQuantity() != null) {
            int resultPrice = product.getProductPrice() * product.getProductQuantity();
            if (resultPrice < 10000) {
                // bindingResult.addError(new ObjectError("product", null, null, "가격 * 수량의 합은 10.000원 이상이어야 합니다."));
            }
        }

    }


}

