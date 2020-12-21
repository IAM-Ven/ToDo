package com.ventoday.util;

import com.ventoday.model.ToDo;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PayloadValidatorTest {

    @Test
    public void validatePayLoad() {
        ToDo toDo = new ToDo(1, "Sample ToDo 1", true);
        Assertions.assertThat(false).isEqualTo(PayloadValidator.validateCreatePayload(toDo));
    }

    @Test
    public void validateInvalidPayLoad() {
        ToDo toDo = new ToDo(0, "Sample ToDo 1", true);
        Assertions.assertThat(true).isEqualTo(PayloadValidator.validateCreatePayload(toDo));
    }


}
