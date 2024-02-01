package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.NoticeCredentials;
import ru.itmo.wp.service.NoticeService;

@Component
public class NoticeCredentialsValidator implements Validator {
    private final NoticeService noticeService;

    public NoticeCredentialsValidator(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public boolean supports(Class<?> clazz) {
        return NoticeCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            NoticeCredentials textForm = (NoticeCredentials) target;
            if (noticeService.isCorrect(textForm.getContent()) == null) {
                errors.rejectValue("content", "content.is-invalid", "Content is invalid");
            }
        }
    }
}
