package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.form.NoticeCredentials;
import ru.itmo.wp.form.validator.NoticeCredentialsValidator;
import ru.itmo.wp.service.NoticeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NoticePage extends Page{

    private final NoticeService noticeService;

    private final NoticeCredentialsValidator noticeCredentialsValidator;

    public NoticePage(NoticeService noticeService, NoticeCredentialsValidator noticeCredentialsValidator) {
        this.noticeService = noticeService;
        this.noticeCredentialsValidator = noticeCredentialsValidator;
    }

    @InitBinder("textForm")
    public void initBinder(WebDataBinder binder) {binder.addValidators(noticeCredentialsValidator);}

    @GetMapping("/notice")
    public String post(Model model) {
        model.addAttribute("textForm", new NoticeCredentials());
        return "NoticePage";
    }

    @PostMapping("/notice")
    public String post(@Valid @ModelAttribute("textForm") NoticeCredentials textForm,
                       BindingResult bindingResult,
                       HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "NoticePage";
        }

        setNotice(httpSession, noticeService.post(textForm));
        setMessage(httpSession, "The notice has been sent!");

        return "redirect:/";
    }
}
