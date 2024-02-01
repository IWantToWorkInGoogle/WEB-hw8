package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.form.NoticeCredentials;
import ru.itmo.wp.repository.NoticeRepository;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public String isCorrect(String content) {
        return content.isEmpty() || content == null ? null : content;
    }
    public List<Notice> findAllNotices() {
        return noticeRepository.findAllByOrderByCreationTimeDesc();
    }

    public Notice post(NoticeCredentials noticeCredentials) {
        Notice notice = new Notice();
        notice.setContent(noticeCredentials.getContent());
        noticeRepository.save(notice);
        return notice;
    }
}
