package com.mailsender.web.results;

import com.mailsender.domain.model.mail.MailMessageModel;
import com.mailsender.domain.model.mail.MailMessageType;
import com.mailsender.domain.model.user.UserModel;

import java.util.Date;
import java.util.List;

public class GetMailLogResult {
    private String username;
    private String email;
    private Count count;
    private Date first;
    private Date last;
    public GetMailLogResult (UserModel user, List<MailMessageModel> messageLogs){
        username = user.getUsername();
        email = user.getEmail();

        Long rest = messageLogs.stream().filter(x -> x.getType() == MailMessageType.REST).count();
        Long corn = messageLogs.stream().filter(x -> x.getType() == MailMessageType.CORN).count();
        count = new Count(rest, corn);

        first = messageLogs.getFirst().getСreatedOn();
        last =  messageLogs.getLast().getСreatedOn();
    }

    private class Count{
        private Long rest;
        private Long corn;

        public Count(Long rest, Long corn) {
            this.rest = rest;
            this.corn = corn;
        }

        public Long getRest() {
            return rest;
        }

        public void setRest(Long rest) {
            this.rest = rest;
        }

        public Long getCorn() {
            return corn;
        }

        public void setCorn(Long corn) {
            this.corn = corn;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public Date getFirst() {
        return first;
    }

    public void setFirst(Date first) {
        this.first = first;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }
}
